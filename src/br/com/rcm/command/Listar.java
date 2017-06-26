package br.com.rcm.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.rcm.model.Equipamento;
import br.com.rcm.service.EquipamentoService;

public class Listar implements Command {
	
	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EquipamentoService service = new EquipamentoService ();
		List <Equipamento> equipamentos = service.listar();
		request.setAttribute("Equipamentos", equipamentos);
		RequestDispatcher rd = request.getRequestDispatcher("ListarEquipamento.jsp");
		rd.forward(request, response);
	}

}
