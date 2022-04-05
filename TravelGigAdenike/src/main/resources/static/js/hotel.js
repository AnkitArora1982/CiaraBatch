$( document ).ready(function() {
	
	
	  $("#searchBtn").click(function(event){
		var searchLocation = $("#searchLocation").val();
		
		var search = {
				"searchString":searchLocation
		};

		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "http://localhost:8282/searchHotel",
			dataType: "json",	
			data: JSON.stringify(search),	
			cache: false,
			success : function(result) {
				
				$.each(result, function (key, val) {
			        $("#hotelTable").append("<tr><td>"+val.hotelId+"</td><td>"+val.hotelName+"</td><td>"+val.averagePrice+"</td><td>"+val.starRating+"</td><td><img src='"+val.imageURL+"' width='100' height='100' class='hotelImg'/></td></tr>");
			    });
			},
			error : function(e) {
				alert("Error!")
				console.log("ERROR: ", e);
			}
		});

	});
	
	
	$("#filterBtn").click(function(event){
		var hotelRow = $('#hotelTable tr').not(':first');
		$('#hotelTable tr').show();
		$.each($('#hotelTable tr').not(':first'), function (key, val) {
	        var hotelPrice = parseInt($(this).children("td").eq(2).text());
	        var selectedPrice = parseInt($("#priceValue").text())
	        var hotelRating = parseInt($(this).children("td").eq(3).text());
	        var selectedHotel = $(this);
	        var ratingFlag = 0;
	        
	        
	        $.each($("input[type='checkbox']:checked"), function(){
	        	var selectedRating = $(this).val();
	            if(selectedRating==hotelRating){
	            	ratingFlag = 1;
	            }
	            else{
	            	ratingFlag = 2;
	            }
	            
	        });
	        if((hotelPrice <= selectedPrice) && (ratingFlag ==  1 || ratingFlag ==  0)){
	        	$(selectedHotel).show();
	        }
	        else{
	        	$(selectedHotel).hide();
	        }
	    });
		
		
		
	});
	
	$("#hotelTable").on('click','.hotelImg',	 function() {
	
		$("#select_roomTypes option").remove();
		var hotelName = $(this).parent().parent().children("td").eq(1).text();
		var hotelId = $(this).parent().parent().children("td").eq(0).text();
		var price = $(this).parent().parent().children("td").eq(2).text();
		
		$("#modal_hotelName").val(hotelName);
		$("#modal_hotelName").attr("data-hotelId",hotelId);
		$("#modal_hotelName").attr("data-price",price);
		
		var hotel = {
				"hotelId":hotelId
		};
		
		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "http://localhost:8282/getHotelRoom",
			dataType: "json",	
			data: JSON.stringify(hotel),	
			cache: false,
			success : function(result) {
				
				$.each(result, function (key, val) {
					$("#select_roomTypes").append("<option value='"+val.hotelRoomId+"'>"+val.type.name+"</option>")
			    });
				
			},
			error : function(e) {
				alert("Error!")
				console.log("ERROR: ", e);
			}
		});

		$("#myModal").toggle();
		
	});
	
	$("#closeBtn").click(function(event){
		
		$("#myModal").toggle();
		
	});
	
	$("#bookRoomBtn").click(function(event){
		
		var hotelId = $("#modal_hotelName").attr("data-hotelId");
		var price = $("#modal_hotelName").attr("data-price");
		var noOfGuest = $("#modal_noGuests").val();
		var checkInDate = $("#modal_checkInDate").val();
		var checkOutDate = $("#modal_checkOutDate").val();
		var hotelRoomId = $('#select_roomTypes option:selected').val();
		var noRooms = $("#modal_noRooms").val();
		var roomType = $('#select_roomTypes :selected').text();
		var booking = {
				"hotelId":hotelId,
				"hotelRoomId":hotelRoomId,
				"noRooms":noRooms,
				"checkInDate":checkInDate,
				"checkOutDate":checkOutDate,
				"status" : "Open",
				"price" : price,
				"roomType" : roomType,
				"noOfGuests" : noOfGuest
		};
		
		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "http://localhost:8282/saveBooking",
			dataType: "json",	
			data: JSON.stringify(booking),	
			cache: false,
			success : function(result) {
				alert("hey your booking is done with us & booking id is: "+result.bookingId);				
			},
			error : function(e) {
				alert("Error!")
				console.log("ERROR: ", e);
			}
		});

		$("#myModal").toggle();
		
	});
	
});