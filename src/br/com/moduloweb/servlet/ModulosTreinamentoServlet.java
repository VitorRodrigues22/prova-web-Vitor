package br.com.moduloweb.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.moduloweb.dao.ConexaoMySqlDAO;
import br.com.moduloweb.dao.ModuloDAO;
import br.com.moduloweb.model.Modulo;

@WebServlet("/modulos")
public class ModulosTreinamentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ConexaoMySqlDAO conexao = new ConexaoMySqlDAO();
		Connection conn = conexao.obterConexao();

		ModuloDAO moduloDAO = new ModuloDAO(conn);
		List<Modulo> listaModulo = moduloDAO.listarTodas();

		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute("modulos", listaModulo);

		RequestDispatcher rd = request.getRequestDispatcher("/consultar-modulos.jsp");
		rd.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ConexaoMySqlDAO conexao = new ConexaoMySqlDAO();
		Connection conn = conexao.obterConexao();

		String nome = request.getParameter("NOME");
		System.out.println("Código inserido: " + nome);

		ModuloDAO moduloDAO = new ModuloDAO(conn);
		List<Modulo> listaModulo = moduloDAO.buscarPorNome(nome);

		try {
			conn.close();
		} catch (SQLException e) {
			System.out.println(e + " erro ao buscar Modulo");
		}

		request.setAttribute("modulos", listaModulo);

		RequestDispatcher rd = request.getRequestDispatcher("/consultar-modulos.jsp");
		rd.forward(request, response);

	}

}

//		Modulo m1 = new Modulo("Nivelamento", "Ivo", "Leonardo");
//		Modulo m2 = new Modulo("HTML/CSS", "Jonas", "Leonardo");
//		Modulo m3 = new Modulo("JAVASCRIPT", "Jonas", "Leonardo");
//		
//		List<Modulo> listaModulo = new ArrayList<>();
//		
//		listaModulo.add(m1);
//		listaModulo.add(m2);
//		listaModulo.add(m3);