package com.edrickrenan.startpoint.StartPoint;

import java.util.List;

import org.junit.Test;

import com.edrickrenan.startpoint.bc.UserBC;
import com.edrickrenan.startpoint.entity.User;

public class UserTest {
	
	
	
	@Test
	public void insertUser(){
		User user = new User();
		UserBC bc = new UserBC();
		user.setCpf("1023910");
		user.setNome("edrick");
		bc.createNewUser(user);
	}
	
	@Test
	public void getUser(){
		UserBC bc = new UserBC();
		User user = bc.getUser(51L);
		System.out.println(user.getId());
		System.out.println(user.getNome());
		System.out.println(user.getCpf());
	}
	
	@Test
	public void getAllUsers(){
		UserBC bc = new UserBC();
		List<User> users = bc.getAllUsers();
		System.out.println(users.toString());
	}
	
	@Test
	public void deleteUser(){
		UserBC bc = new UserBC();
		User user = bc.getUser(1L);
		bc.deleteUser(user);
	}
	
	@Test
	public void updateUser(){
		UserBC bc = new UserBC();
		User user = bc.getUser(101L);
		user.setCpf("atualizando o cpf");
		user.setNome("atualizando o nome");
		user = bc.updateUser(user);
		System.out.println(user.toString());
	}
}
