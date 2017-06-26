package br.com.rcm.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.rcm.model.Equipamento;
import br.com.rcm.service.EquipamentoService;

public class Apagar implements Command{
	
	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		int id = Integer.parseInt(request.getParameter("id"));
		EquipamentoService service = new EquipamentoService ();
		service.apagar(new Equipamento (id));
		request.setAttribute("Equipamentos", service.listar());
		request.getRequestDispatcher("ListarEquipamento.jsp").forward(request, response);
	}

}
