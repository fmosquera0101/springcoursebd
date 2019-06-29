package com.fredymosquera.springcoursebd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fredymosquera.springcoursebd.beans.Jugador;

@Repository
public class DaoJugadorImp implements IDaoJugador {

	@Autowired
	DataSource datasource;

	@Override
	public void registrarJugador(Jugador jugador) throws Exception {
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			StringBuilder strbSql = new StringBuilder();
			strbSql.append("INSERT INTO springcourse.jugador");
			strbSql.append("(id, nombre, equipoid, camisetid) ");
			strbSql.append("VALUES(?, ?, ?, ?) ");

			conn = datasource.getConnection();
			pst = conn.prepareStatement(strbSql.toString());
			int index = 1;
			pst.setInt(index++, jugador.getId());
			pst.setString(index++, jugador.getNombre());
			pst.setInt(index++, jugador.getEquipo().getId());
			pst.setInt(index++, jugador.getCamiseta().getId());
			pst.executeUpdate();
		} catch (Exception e) {
			throw e;
		}finally {
			if (pst != null) {
				pst.close();
			}
			if (conn != null) {
				conn.close();
			}
		}




	}

}
