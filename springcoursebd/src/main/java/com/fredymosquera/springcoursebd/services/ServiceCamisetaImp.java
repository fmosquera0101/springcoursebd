package com.fredymosquera.springcoursebd.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fredymosquera.springcoursebd.beans.Camiseta;
import com.fredymosquera.springcoursebd.dao.IDaoCamiseta;

@Service
public class ServiceCamisetaImp implements IServiceCamiseta{

	@Autowired
	IDaoCamiseta daoCamiseta;
	@Override
	public Camiseta getCamiseta(int idCamiseta) throws Exception {
		return daoCamiseta.getCamiseta(idCamiseta);
	}

}
