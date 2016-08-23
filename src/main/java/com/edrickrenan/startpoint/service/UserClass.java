package com.edrickrenan.startpoint.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.edrickrenan.startpoint.bc.UserBC;
import com.edrickrenan.startpoint.entity.User;

@Path("user")
public class UserClass {
	@PUT
	@Path("/new")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User newUser(User user){
		try {
			UserBC bc = new UserBC();
			User newUser = bc.createNewUser(user);
			return newUser;
		} catch (Exception e) {
			System.out.println("Hello World! ;)");
			return null;
		}	
	}
	
	@GET
	@Path("/getall")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getAll(){
		try {
			UserBC bc = new UserBC();
			List<User> list = bc.getAllUsers();
			return list;
		} catch (Exception e) {
			return null;
		}	
	}
	
	@GET
	@Path("/get")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User newUser(int id){
		try {
			UserBC bc = new UserBC();
			User user = bc.getUser(id);
			return user;
		} catch (Exception e) {
			return null;
		}	
	}
	
	@GET
	@Path("/getall")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> newUser(){
		try {
			UserBC bc = new UserBC();
			List<User> list = bc.getAllUsers();
			return list;
		} catch (Exception e) {
			return null;
		}	
	}
	
	@GET
	@Path("/delete")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteUser(int id){
		try {
			UserBC bc = new UserBC();
			User user = bc.getUser(id);
			bc.deleteUser(user);
		} catch (Exception e) {
			
		}	
	}
	
	@GET
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User updateUser(int id){
		try {
			UserBC bc = new UserBC();
			User user = bc.getUser(id);
			bc.updateUser(user);
			return user;
		} catch (Exception e) {
			return null;
		}	
	}
}
