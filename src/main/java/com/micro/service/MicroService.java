package com.micro.service;

import java.util.List;

import com.micro.model.MicroProModel;

public interface MicroService {

	
	public MicroProModel createUser(MicroProModel proModel);
	
	public List<MicroProModel> getAllUser();
	
	public MicroProModel getSingleUSer(int id);
	
	public MicroProModel updateUser(MicroProModel microProModel);
	
	public void deleteUser(int id);
}
