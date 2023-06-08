package com.micro.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.micro.model.MicroProModel;


public interface MicroProDao extends JpaRepository<MicroProModel, Integer> {

}
