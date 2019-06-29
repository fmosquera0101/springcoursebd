package com.fredymosquera.springcoursebd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fredymosquera.springcoursebd.beans.Equipo;

@Repository
public class DaoEquipoImp implements IDaoEquipo {
	@Autowired
	DataSource dataSource;

	@Override
	public Equipo getEquipo(int idEquipo) throws Exception {
		Equipo equipo = null;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rst = null;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT id, nombre FROM springcourse.equipo ");
			sql.append("WHERE id = ?");
			conn = dataSource.getConnection();
			pst = conn.prepareStatement(sql.toString());
			pst.setInt(1, idEquipo);
			rst = pst.executeQuery();
			if(rst.next()) {
				equipo = new Equipo();
				equipo.setId(rst.getInt("id"));
				equipo.setNombre(rst.getString("nombre"));
			}
		} catch (Exception e) {
			throw e;
		}finally {
			if (pst != null) {
				pst.close();
			}
			if (rst != null) {
				rst.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		
		return equipo;
	}

}
