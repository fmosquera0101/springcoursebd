package com.fredymosquera.springcoursebd.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fredymosquera.springcoursebd.beans.Marca;
import com.fredymosquera.springcoursebd.dao.IDaoMarca;

@Service
public class ServiceMarcaImpl implements IServiceMarca {

	@Autowired
	private IDaoMarca daoMarca;
	@Override
	public void registrarMarca(Marca marca) throws Exception {
		daoMarca.registrarMarca(marca);
		
	}

}
