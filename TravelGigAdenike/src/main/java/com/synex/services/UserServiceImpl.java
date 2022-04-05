package com.synex.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synex.domain.User;
import com.synex.repository.UserRepository;


@Service

public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository repository;
	
	@Override
	public List<User> findAll() {
		return repository.findAll();
	}

	@Override
	public User save(User u) {
		User user = repository.save(u);
		return user;
	}

	@Override
	public void deleteUserById(long userId) {
		repository.deleteById(userId);
	}

	@Override
	public User findByUserId(long userId) {
		Optional<User> user = repository.findById(userId);
		if (user.isPresent())
			return user.get();
		return null;
	}

	@Override
	public User findByUserName(String userName) {
		return repository.findByUserName(userName);
	}

}
