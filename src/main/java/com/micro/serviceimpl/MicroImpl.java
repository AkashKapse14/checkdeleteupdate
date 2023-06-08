package com.micro.serviceimpl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.micro.dao.MicroProDao;
import com.micro.model.MicroProModel;
import com.micro.service.MicroService;


@Service
public class MicroImpl implements MicroService {
	
	@Autowired
	private MicroProDao microProDao;

	@Override
	public MicroProModel createUser(MicroProModel proModel) {
		// TODO Auto-generated method stub
		return this.microProDao.save(proModel);
	}

	@Override
	public List<MicroProModel> getAllUser() {
		List<MicroProModel> findAll = this.microProDao.findAll();
		return findAll;
	}

	@Override
	public MicroProModel getSingleUSer(int id) {
		// TODO Auto-generated method stub
		return this.microProDao.findById(id).get();
	}

	@Override
	public MicroProModel updateUser(MicroProModel microProModel) {
		// TODO Auto-generated method stub
		return this.microProDao.save(microProModel);
	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		this.microProDao.deleteById(id);
	}

}
