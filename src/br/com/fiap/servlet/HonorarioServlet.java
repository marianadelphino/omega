package br.com.fiap.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.bean.LancaHonorario;
import br.com.fiap.bean.Processo;
import br.com.fiap.bean.TipoTarefa;
import br.com.fiap.bo.HonorarioBO;
import br.com.fiap.conexao.ConexaoFactory;


@WebServlet("/HonorarioServlet")
public class HonorarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public HonorarioServlet() {
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
		switch (acao){		
		
		
		case "listar": listar(request);
		retorno = "HonorarioLista.jsp";
		break;
		

		case "cadastrar":
			try {
				cadastrar(request);	listar(request);
				retorno = "HonorarioLista.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}
				
		  break; 
		  		  
			
		case "remover": remover(request); listar(request);
		retorno = "HonorarioLista.jsp";
		break;
		  
		case "carregar": carregaCombo(request);
		retorno = "HonorarioCadastra.jsp";
		break;
		  
		
		case "listarPorProcesso": listarDespesaPorProcesso(request);
		retorno = "HonorarioLista.jsp";
		break;
		  
		/*
		  
			
		case "exibir": try {
			editar(request);listar(request);
				retorno = "DespesaLista.jsp";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		break;*/
					
		
		}

		
		
		
		request.getRequestDispatcher(retorno).forward(request, response);
	}
	
		
	private void listar(HttpServletRequest request){		
		try{	Connection con1 = ConexaoFactory.controlarInstancia().getConnection("", "");

					List<LancaHonorario> honorario = HonorarioBO.listarT(con1);
					request.setAttribute("lista", honorario);
				} catch  (Exception e ){
					e.printStackTrace();
					
				}
		
		}
	
	
	
	private void cadastrar(HttpServletRequest request) throws Exception{
		
		Connection con1 = ConexaoFactory.controlarInstancia().getConnection("", "");	
		int numeroProcesso = Integer.parseInt(request.getParameter("Nnrprocesso")); 
		int codTarefa = Integer.parseInt(request.getParameter("tipotarefa"));
		String dataHonorario = request.getParameter("Ndata"); 
	    Double horaTarefa = Double.parseDouble(request.getParameter("Nhora")); 
	    String observacoes = request.getParameter("Nobservacao"); 
						
		LancaHonorario l = new LancaHonorario(); 
		TipoTarefa t = new TipoTarefa();
		Processo p = new Processo();
				
		t.setCd_tipo_tarefa(codTarefa);
		l.setTipoTarefa(t); 
		
		p.setNr_processo(numeroProcesso); 
		l.setProcesso(p); 
		
		l.setDt_honorario(dataHonorario);
				
		l.setQt_hora(horaTarefa);
		
		l.setDs_observacao(observacoes);
		
		HonorarioBO.incluir(l, con1);	
		request.setAttribute("msg", "Honorário cadastrado com sucesso!");
		} 
	
	
	
	private void carregaCombo(HttpServletRequest request){
		try{	Connection con1 = ConexaoFactory.controlarInstancia().getConnection("", "");
		request.setAttribute("tipotarefa", HonorarioBO.listarTipoTarefa(con1));
		} catch  (Exception e ){
			e.printStackTrace();
			
		}

	}
	
	
	
	private void remover(HttpServletRequest request){
		int cdLancamento = Integer.parseInt(request.getParameter("cdLancamento"));
		
		try{	Connection con1 = ConexaoFactory.controlarInstancia().getConnection("", "");
		
		HonorarioBO.deletarLancamentoF(cdLancamento, con1);
		request.setAttribute("msg2", "Honorário removido com sucesso!");
	} catch  (Exception e ){
		e.printStackTrace();
		
	}

}
	
	
	private void listarDespesaPorProcesso(HttpServletRequest request){
		String processo = request.getParameter("Nprocesso");
		try{	Connection con1 = ConexaoFactory.controlarInstancia().getConnection("", "");

		List<LancaHonorario> honorario = HonorarioBO.listarPorProcessoT(processo, con1);
		request.setAttribute("lista", honorario);
	} catch  (Exception e ){
		e.printStackTrace();
		
	}

}
	
	
	/*	
private void editar(HttpServletRequest request) throws Exception{
		
		Connection con1 = ConexaoFactory.controlarInstancia().getConnection("", "");
		int cdLancamentoE = Integer.parseInt(request.getParameter("cdLancamentoE"));
		if(request.getParameter("cdLancamentoE") != null){
		
		String dataDespesa = request.getParameter("Ndata"); 
	    Double valorDespesa = Double.parseDouble(request.getParameter("Nvalor")); 
	    String observacoes = request.getParameter("Nobservacao"); 
						
		LancaDespesa l = new LancaDespesa(); 
	
		l.setDt_despesa(dataDespesa);		
		l.setVl_despesa(valorDespesa);		
		l.setDs_observacao(observacoes);
		
		DespesaBO.atualizaDespesaById(cdLancamentoE, l, con1);	
		request.setAttribute("msg", "Despesa atualizada com sucesso!");
		} 
}*/
	
		
	
/*	private void editar(HttpServletRequest request){
		int cdLancamentoE = Integer.parseInt(request.getParameter("cdLancamentoE"));
		try{	Connection con1 = ConexaoFactory.controlarInstancia().getConnection("", "");

		List<LancaDespesa> despesa = DespesaBO.listarPorId(cdLancamentoE, con1);	
		request.setAttribute("lista", despesa);
	} catch  (Exception e ){
		e.printStackTrace();
		
	}

*/
	

		
		}
	
	

	
	

		


