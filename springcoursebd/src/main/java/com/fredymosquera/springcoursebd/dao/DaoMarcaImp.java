package com.fredymosquera.springcoursebd.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fredymosquera.springcoursebd.beans.Marca;

@Repository
public class DaoMarcaImp implements IDaoMarca {

	@Autowired
	private DataSource datasource;

	@Override
	public void registrarMarca(Marca marca) throws Exception {
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			StringBuilder strbSql = new StringBuilder();
			strbSql.append("INSERT INTO springcourse.marca(id, nombre) ");
			strbSql.append("VALUES(?, ?) ");

			conn = datasource.getConnection();
			pst = conn.prepareStatement(strbSql.toString());
			int index = 0;
			pst.setInt(++index, marca.getId());
			pst.setString(++index, marca.getNombre());
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
