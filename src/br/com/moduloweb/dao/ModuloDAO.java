package br.com.moduloweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.moduloweb.model.Modulo;

public class ModuloDAO {

	Connection conn;

	private String SQL_LISTAR_MODULOS = "SELECT * FROM tb_modulo";
	private String SQL_LISTAR_POR_NOME = "SELECT * FROM tb_modulo WHERE ds_nome = ?";

	public ModuloDAO(Connection conn) {
		this.conn = conn;
	}

	// LISTAR TODOS
	public List<Modulo> listarTodas() {

		List<Modulo> listaModulos = new ArrayList<>();
		try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(SQL_LISTAR_MODULOS);) {
			while (rs.next()) {
				Modulo m = new Modulo();
				m.setDs_nome(rs.getString("ds_nome"));
				m.setDs_instrutor_titular(rs.getString("ds_instrutor_titular"));
				m.setDs_instrutor_auxiliar(rs.getString("ds_instrutor_auxiliar"));
				m.setDt_inicio(rs.getDate("dt_inicio"));

				listaModulos.add(m);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return listaModulos;
	}

	// BUSCAR POR NOME
	public List<Modulo> buscarPorId(String nome) {

		List<Modulo> listaModulos = new ArrayList<>();
		try (PreparedStatement stmt = conn.prepareStatement(SQL_LISTAR_POR_NOME);) {

			stmt.setString(1, nome);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Modulo m = new Modulo();
				m.setDs_nome(rs.getString("ds_nome"));
				m.setDs_instrutor_titular(rs.getString("ds_instrutor_titular"));
				m.setDs_instrutor_auxiliar(rs.getString("ds_instrutor_auxiliar"));
				m.setDt_inicio(rs.getDate("dt_inicio"));

				listaModulos.add(m);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return listaModulos;
	}

}
