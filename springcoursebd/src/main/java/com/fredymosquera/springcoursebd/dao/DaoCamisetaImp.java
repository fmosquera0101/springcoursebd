package com.fredymosquera.springcoursebd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fredymosquera.springcoursebd.beans.Camiseta;
import com.fredymosquera.springcoursebd.beans.Marca;

@Repository
public class DaoCamisetaImp implements IDaoCamiseta {
	

	@Autowired
	DataSource dataSource;

	@Override
	public Camiseta getCamiseta(int idCamiseta) throws Exception {
		Camiseta camiseta = null;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rst = null;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT c.id, c.numero, c.marcaid, m.nombre ");
			sql.append("FROM springcourse.camiseta c, springcourse.marca m ");
			sql.append("WHERE c.marcaid = m.id and c.id = ?");
			conn = dataSource.getConnection();
			pst = conn.prepareStatement(sql.toString());
			pst.setInt(1, idCamiseta);
			rst = pst.executeQuery();
			if(rst.next()) {
				camiseta = new Camiseta();
				camiseta.setId(rst.getInt("c.id"));
				camiseta.setNumero(rst.getInt("c.numero"));
				Marca marca = new Marca();
				marca.setId(rst.getInt("c.marcaid"));
				marca.setNombre(rst.getString("m.nombre"));
				camiseta.setMarca(marca);
		
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
		
		return camiseta;
	}

}
