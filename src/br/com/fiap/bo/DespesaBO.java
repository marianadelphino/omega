package br.com.fiap.bo;



import java.sql.Connection;
import java.util.List;
import br.com.fiap.bean.LancaDespesa;
import br.com.fiap.bean.TipoDespesa;
import br.com.fiap.dao.DespesaDAO;
import br.com.fiap.excecao.Excecao;

public class DespesaBO {
	
	/**
	 * 
	 * @param l indica objeto da classe LancaDespesa
	 * @param conn indica objeto da Classe ConexaoFactory 
 * @author Grupo Omega 
	 */
public static void incluir(LancaDespesa l, Connection conn)throws Exception {		
	if (l.getVl_despesa() < 0){
		throw new Excecao("O valor da despesa é sempre maior que zero!");
	}
		
		l.setCd_lancamento(l.getCd_lancamento());
		new DespesaDAO().insert(l, conn);	
		 System.out.println("Lançamento de despesa realizado com sucesso para o processo número: " + l.getProcesso().getNr_processo());		
	}

/**
 * 
 * @param conn indica objeto da Classe ConexaoFactory 
 * @return lista com todos os tipos de despesas cadastradas 
 * @author Grupo Omega 
 */
public static List<TipoDespesa> listarTipoDespesa(Connection conn) throws Exception{
	return new DespesaDAO().listaTipoDespesa(conn);
}


/**
 * 
 * @param conn indica objeto da Classe ConexaoFactory 
 * @return lista de despesas cadastradas 
 * @author Grupo Omega 
 */
public static List<LancaDespesa> listarT(Connection conn) throws Exception{
	return new DespesaDAO().listaDespesas(conn);
}


/**
 * 
 * @param processo
 * @param conn indica objeto da Classe ConexaoFactory 
 * @return lista de despesas por processo 
 * @author Grupo Omega 
 */
public static List<LancaDespesa> listarPorProcessoT(String processo, Connection conn) throws Exception{
	return new DespesaDAO().listaDespesasPorProcesso(processo, conn);
}

/**
 * 
 * @param idLancamento
 * @param conn indica objeto da Classe ConexaoFactory 
 * @return lista de despesas de acordo com o codigo de lancamento 
 * @author Grupo Omega 
 */
public static List<LancaDespesa> listarPorId(int idLancamento, Connection conn) throws Exception{
	return new DespesaDAO().listaDespesasPorId(idLancamento, conn);
}

/**
 * 
 * @param processo
 * @param cdlancamento
 * @param conn indica objeto da Classe ConexaoFactory 
 * @return despesas excluídas
 * @author Grupo Omega 
 */
public int deletarLancamento (int processo, int cdlancamento, Connection conn) throws Exception {
	return new DespesaDAO().deleteByCdLancamento(processo, cdlancamento, conn);
	
}

/**
 * 
 * @param cdlancamento indica código de lancamento da despesa 
 * @param conn indica objeto da Classe ConexaoFactory 
 * @return despesa excluida por cdLancamento 
 * @author Grupo Omega 
 */
static public int deletarLancamentoF (int cdlancamento, Connection conn) throws Exception {
	return new DespesaDAO().deleteByCdLancamentoF(cdlancamento, conn);
	
}

/**
 * 
 * @param processo indica numero do processo 
 * @param cdLancamento indica código de lancamento da despesa 
 * @param l indica objeto da classe LancaDespesa
 * @param conn indica objeto da Classe ConexaoFactory 
 * @return despesa atualizada por numero do processo e cdLancamento 
 * @author Grupo Omega 
 */
public int  atualizaDespesa(String processo, String cdLancamento, LancaDespesa l, Connection conn)throws Exception {
	return new DespesaDAO().atualizarDespesa(processo, cdLancamento, l, conn);
	
}


/**
 * 
 * @param cdLancamento indica código de lancamento da despesa 
 * @param l indica objeto da classe LancaDespesa
 * @param conn indica objeto da Classe ConexaoFactory 
 * @return despesa atualizada por cdLancamento 
 * @author Grupo Omega 
 */
static public int  atualizaDespesaById(int cdLancamento, LancaDespesa l, Connection conn)throws Exception {
	return new DespesaDAO().atualizarDespesaByCdLancamento(cdLancamento, l, conn);
	
}

}



