package com.fredymosquera.springcoursebd.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fredymosquera.springcoursebd.beans.Equipo;
import com.fredymosquera.springcoursebd.dao.IDaoEquipo;

@Service
public class ServiceEquipoImp implements IServiceEquipo{

	@Autowired
	IDaoEquipo daoEquipo;
	
	@Override
	public Equipo getEquipo(int idEquipo) throws Exception {
		return daoEquipo.getEquipo(idEquipo);
	}

}
