package com.fredymosquera.springcoursebd;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fredymosquera.springcoursebd.beans.Camiseta;
import com.fredymosquera.springcoursebd.beans.Equipo;
import com.fredymosquera.springcoursebd.beans.Jugador;
import com.fredymosquera.springcoursebd.services.IServiceCamiseta;
import com.fredymosquera.springcoursebd.services.IServiceEquipo;
import com.fredymosquera.springcoursebd.services.IServiceJugador;

/**
 * 
 *
 */
public class App {
	public static void main( String[] args ){
		ApplicationContext appContext = new ClassPathXmlApplicationContext("com/fredymosquera/springcoursebd/resources/xml/beans.xml");
		
		IServiceEquipo serviceEquipo = (IServiceEquipo) appContext.getBean("serviceEquipoImp");
		IServiceCamiseta  serviceCamiseta =(IServiceCamiseta) appContext.getBean("serviceCamisetaImp");
		IServiceJugador serviceJugador = (IServiceJugador) appContext.getBean("serviceJugadorImp");
		Equipo equipo = null;
		try {
			equipo = serviceEquipo.getEquipo(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(equipo.getId()+"- "+equipo.getNombre());
		
		Camiseta camiseta = null;
		try {
			camiseta = serviceCamiseta.getCamiseta(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(camiseta.getId()+"- "+camiseta.getNumero()+"- "+camiseta.getMarca().getNombre());
		
		Jugador jugador = new Jugador();
		jugador.setId(2);
		jugador.setNombre("Fredy Mosquera");
		jugador.setCamiseta(camiseta);
		jugador.setEquipo(equipo);
		
		try {
			serviceJugador.registrarJugador(jugador);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/*Marca marca = new Marca();
		marca.setId(2);
		marca.setNombre("Puma");

		IServiceMarca serviceMarca = (IServiceMarca) appContext.getBean("serviceMarcaImpl");
		try {
			serviceMarca.registrarMarca(marca);
		} catch (Exception e) {
			e.printStackTrace();
		}*/

	}
}
