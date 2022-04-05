$( document ).ready(function() {
	

	 	$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "http://localhost:8282/getMyBookings",
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