package br.com.fiap.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.text.ParseException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import br.com.fiap.bean.LancaDespesa;
import br.com.fiap.bean.Processo;
import br.com.fiap.bean.TipoDespesa;
import br.com.fiap.bo.DespesaBO;
import br.com.fiap.conexao.ConexaoFactory;


@WebServlet("/DespesaServlet")
public class DespesaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public DespesaServlet() {
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

		case "cadastrar":
			try {
				cadastrar(request);	listar(request);
				retorno = "DespesaLista.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}
				
		  break; 
		  
		  		  
			
		case "exibir": try {
			editar(request); listar(request);
				retorno = "DespesaLista.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		break;
			
		  
					
			case "listar": listar(request);
				retorno = "DespesaLista.jsp";
				break;
		  
		case "listarPorProcesso": listarDespesaPorProcesso(request);
			retorno = "DespesaLista.jsp";
			break;
			

		
			
		case "carregar": carregaCombo(request);
			retorno = "DespesaCadastra.jsp";
			break;
			
			
			
			
		case "remover": remover(request); listar(request);
		retorno = "DespesaLista.jsp";
		break;
		
		}

		
		
		
		request.getRequestDispatcher(retorno).forward(request, response);
	}
	
		
	
	private void cadastrar(HttpServletRequest request) throws Exception{
		
		Connection con1 = ConexaoFactory.controlarInstancia().getConnection("", "");
		
		int numeroProcesso = Integer.parseInt(request.getParameter("Nnrprocesso")); 
		int codDespesa = Integer.parseInt(request.getParameter("tipodespesa"));
		String dataDespesa = request.getParameter("Ndata"); 
	    Double valorDespesa = Double.parseDouble(request.getParameter("Nvalor")); 
	    String observacoes = request.getParameter("Nobservacao"); 
						
		LancaDespesa l = new LancaDespesa(); 
		TipoDespesa t = new TipoDespesa();
		Processo p = new Processo();
				
		t.setCd_tipo_despesa(codDespesa);
		l.setTipoDespesa(t); 
		
		p.setNr_processo(numeroProcesso); 
		l.setProcesso(p); 
		
		l.setDt_despesa(dataDespesa);
		
		l.setVl_despesa(valorDespesa);
		
		l.setDs_observacao(observacoes);
		
		DespesaBO.incluir(l, con1);	
		request.setAttribute("msg", "Despesa cadastrada com sucesso!");
		} 
	
		
	
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
}
		
	
/*private void editar(HttpServletRequest request){
		int cdLancamentoE = Integer.parseInt(request.getParameter("cdLancamentoE"));
		try{	Connection con1 = ConexaoFactory.controlarInstancia().getConnection("", "");

		List<LancaDespesa> despesa = DespesaBO.listarPorId(cdLancamentoE, con1);	
		request.setAttribute("lista", despesa);
	} catch  (Exception e ){
		e.printStackTrace();
		
	}

} */
	
		
	private void listar(HttpServletRequest request){		
		try{	Connection con1 = ConexaoFactory.controlarInstancia().getConnection("", "");

					List<LancaDespesa> despesa = DespesaBO.listarT(con1);
					request.setAttribute("lista", despesa);
				} catch  (Exception e ){
					e.printStackTrace();
					
				}
		
		}
	

	private void listarDespesaPorProcesso(HttpServletRequest request){
		String processo = request.getParameter("Nprocesso");
		try{	Connection con1 = ConexaoFactory.controlarInstancia().getConnection("", "");

		List<LancaDespesa> despesa = DespesaBO.listarPorProcessoT(processo, con1);
		request.setAttribute("lista", despesa);
	} catch  (Exception e ){
		e.printStackTrace();
		
	}

}
	
		
	private void carregaCombo(HttpServletRequest request){
		try{	Connection con1 = ConexaoFactory.controlarInstancia().getConnection("", "");
		request.setAttribute("tipodespesa", DespesaBO.listarTipoDespesa(con1));
		} catch  (Exception e ){
			e.printStackTrace();
			
		}

	}
			
	
	private void remover(HttpServletRequest request){
		int cdLancamento = Integer.parseInt(request.getParameter("cdLancamento"));
		
		try{	Connection con1 = ConexaoFactory.controlarInstancia().getConnection("", "");
		
		DespesaBO.deletarLancamentoF(cdLancamento, con1);
		request.setAttribute("msg2", "Despesa removida com sucesso!");
	} catch  (Exception e ){
		e.printStackTrace();
		
	}

}
	
		
		}