package com.qa.ims.controller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.ims.model.UserModel;
import com.qa.ims.model.repository.UserModelRepository;

/**
 * Created by Administrator on 19/05/2016.
 */
@Service
public class UserService {

	@Autowired
	private UserModelRepository userModelRepository;

	public boolean valid(String username, String password) {
		UserModel userModel = userModelRepository.getOne(username);
		if (userModel == null) {
			return false;
		}

		if (userModel.getPassword().equals(password)) {
			return true;
		}

		return false;
	}

}
