package br.com.fiap.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.bean.Cliente;
import br.com.fiap.bean.LancaDespesa;
import br.com.fiap.bean.Processo;
import br.com.fiap.bo.DespesaBO;
import br.com.fiap.bo.ProcessoBO;
import br.com.fiap.conexao.ConexaoFactory;


@WebServlet("/ProcessoServlet")
public class ProcessoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public ProcessoServlet() {
		super();
	
	}
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String acao = request.getParameter("acao");
		String retorno = "";
		switch (acao) {		
			
		case "listarFiltro": listarFiltro(request);
		retorno = "ProcessoLista.jsp";
		break;	
		
		case "listar":
			listar(request);
			retorno = "ProcessoLista.jsp";
			break;
		
		
		}

		
		
		
		request.getRequestDispatcher(retorno).forward(request, response);
	}
	
		
	private void listarFiltro(HttpServletRequest request){
		int processo = Integer.parseInt(request.getParameter("Nprocesso"));
		String cliente = request.getParameter("Ncliente");
		String dtinicial = request.getParameter("Ninicial");
		String dtfinal = request.getParameter("Nfinal");
				
		
		try{	Connection con1 = ConexaoFactory.controlarInstancia().getConnection("", "");

		List<Processo> p = ProcessoBO.listarProcessoF(processo, cliente, dtinicial, dtfinal, con1);
		request.setAttribute("lista", p);
	} catch  (Exception e ){
		e.printStackTrace();
		
	}

}
		
		
	
		private void listar(HttpServletRequest request){
			
			try{	Connection con3 = ConexaoFactory.controlarInstancia().getConnection("", "");

						
						List<Processo> processo = ProcessoBO.listarProcesso(con3);
						
						
						
						request.setAttribute("lista", processo);
					} catch  (Exception e ){
						e.printStackTrace();
						
					}
			
			}
			

}
