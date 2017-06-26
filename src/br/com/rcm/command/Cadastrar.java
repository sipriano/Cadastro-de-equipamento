package br.com.rcm.command;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.rcm.model.Equipamento;
import br.com.rcm.service.EquipamentoService;

public class Cadastrar implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EquipamentoService service = new EquipamentoService();
		
			//int id = Integer.parseInt(request.getParameter("id"));
			String nome = request.getParameter("nome");
			String tipo = request.getParameter("tipo");
			float peso = Float.parseFloat(request.getParameter("peso"));
			Equipamento equi = new Equipamento(nome, tipo, peso);
			service.criar(equi);
			request.setAttribute("l", equi);
			RequestDispatcher rd = request.getRequestDispatcher("ExibeEquipamentoCadastrado.jsp");
			rd.forward(request, response);


	}

}
