package com.kodgemisi.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

import com.kodgemisi.usermanagement.Phone;
import com.kodgemisi.usermanagement.User;
import com.kodgemisi.usermanagement.UserService;



public class FilterApiImpl implements FilterApi {

	private final UserService userService;

	public FilterApiImpl(UserService userService) {
		this.userService = userService;
	}

	@Override
	public List<User> unverifiedUnder18() {
		List<User> users = new ArrayList<User>();
		for (User user : userService.list()) {
			if(user.getAge()<18 && !user.isVerified()){
				users.add(user);
			}
		}
		//FIXME currently returns all the users unfiltered, you should fix this method
		// If you are not sure how to implement this method, please refer to the Javadoc or the FilterApi interface
		return users;
	}

	@Override
	public List<User> verifiedWithTrPrimaryPhone() {
		//FIXME currently returns all the users unfiltered, you should fix this method
		// If you are not sure how to implement this method, please refer to the Javadoc or the FilterApi interface
		List<User> users = new ArrayList<User>();
		for(User user : userService.list()) {
			if(user.isVerified()){
				Phone phone = user.getProfile().getPrimaryPhone();
				if(phone.subSequence(0, 3).equals("+90")){
					users.add(user);
				}
			}
		}
		return users;
	}
}
