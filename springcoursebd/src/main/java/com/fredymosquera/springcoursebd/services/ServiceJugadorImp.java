package com.fredymosquera.springcoursebd.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fredymosquera.springcoursebd.beans.Jugador;
import com.fredymosquera.springcoursebd.dao.IDaoJugador;

@Service
public class ServiceJugadorImp implements IServiceJugador {
	@Autowired
	private IDaoJugador daoJugador;

	@Override
	public void registrarJugador(Jugador jugador) throws Exception {
		daoJugador.registrarJugador(jugador);
		
	}

}
