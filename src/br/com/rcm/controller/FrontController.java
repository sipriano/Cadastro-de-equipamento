package br.com.rcm.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.rcm.command.Command;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("/PortaDeEntrada")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		try{	
				Command command = (Command)Class.forName("br.com.rcm.command." + acao).newInstance();
				command.executar(request, response);
		}
		catch (ClassNotFoundException | IllegalAccessException | InstantiationException e){
			PrintWriter pw = response.getWriter();
			pw.println ("<html> <head> <title> Um problema ocorreu </title > </head> <body> <a href=\"index.html\">Home</a> <br/>Tente novamente mais tarde.");
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		//request.getRequestDispatcher("");
	}

}
