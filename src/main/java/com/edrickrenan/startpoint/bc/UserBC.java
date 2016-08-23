package com.edrickrenan.startpoint.bc;

import java.util.List;

import com.edrickrenan.startpoint.dao.DAOUser;
import com.edrickrenan.startpoint.entity.User;

public class UserBC {
	
	DAOUser dao = new DAOUser();
	
	@SuppressWarnings("static-access")
	public User createNewUser(User user){
		dao.open();
		dao.begin();
		dao.create(user);
		dao.commit();
		dao.close();
		return user;
	}
	
	@SuppressWarnings("static-access")
	public List<User> getAllUsers (){
		dao.open();
		dao.begin();
		List<User> list = dao.readAll();
		dao.commit();
		dao.close();
		return list;
	}
	
	@SuppressWarnings("static-access")
	public User getUser(int id){
		dao.open();
		dao.begin();
		User user = dao.read(id);
		dao.commit();
		dao.close();
		return user;
	}
	
	@SuppressWarnings("static-access")
	public User updateUser(User user){
		dao.open();
		dao.begin();
		User returnUser = dao.update(user);
		dao.commit();
		dao.close();
		return returnUser;
	}
	
	@SuppressWarnings("static-access")
	public void deleteUser(User user){
		dao.open();
		dao.begin();
		dao.delete(user);
		dao.commit();
		dao.close();
	}
}
