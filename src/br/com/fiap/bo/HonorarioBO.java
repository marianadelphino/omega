package br.com.fiap.bo;

import java.sql.Connection;
import java.util.List;

import br.com.fiap.bean.LancaHonorario;
import br.com.fiap.bean.TipoTarefa;
import br.com.fiap.dao.HonorarioDAO;
import br.com.fiap.excecao.Excecao;

public class HonorarioBO {
	
	/**
	 * 
	 * @param l indica objeto classe LancaHonorario  
	 * @param conn indica objeto da Classe ConexaoFactory
	 * @author Grupo Omega 
	 */
	public static void incluir(LancaHonorario l, Connection conn)throws Exception {	
		if (l.getQt_hora() < 0){
			throw new Excecao("Quantidade de horas é sempre maior que zero!");
		}
			
			l.setCd_lancamento(l.getCd_lancamento());
			new HonorarioDAO().insert(l, conn);
			
			 System.out.println("Lançamento de honorário realizado com sucesso para o processo número: " + l.getProcesso().getNr_processo());
			
		}
	
	/**
	 * 
	 * @param conn indica objeto da Classe ConexaoFactory
	 * @return lista de tipos de tarefas cadastradas 
	 * @author Grupo Omega 
	 */
	public static List<TipoTarefa> listarTipoTarefa(Connection conn) throws Exception{
		return new HonorarioDAO().listaTipoTarefa(conn);
	}

	
	/**
	 * 
	 * @param processo indica numero do processo 
	 * @param conn indica objeto da Classe ConexaoFactory
	 * @return lista de honorarios cadastrados por processo 
	 * @author Grupo Omega 
	 */
	public static List<LancaHonorario> listarPorProcessoT(String processo, Connection conn) throws Exception{
		return new HonorarioDAO().listaHonorariosPorProcesso(processo, conn);
	}

	
	/**
	 * 
	 * @param conn indica objeto da Classe ConexaoFactory
	 * @return lista com todos honorarios cadastrados 
	 * @author Grupo Omega 
	 */
	public static List<LancaHonorario> listarT(Connection conn) throws Exception{
		return new HonorarioDAO().listaHonorario(conn);
	}
	
	
	
/**
 * 
 * @param processo indica o numero do processo 
 * @param cdlancamento indica o codigo de lancamento 
 * @param conn indica objeto da Classe ConexaoFactory
 * @return honorario excluido 
	 * @author Grupo Omega 
 */
public int deletarLancamento (int processo, int cdlancamento, Connection conn) throws Exception {
	return new HonorarioDAO().deleteByCdLancamento(processo, cdlancamento, conn);
	
}

/**
 * 
 * @param cdlancamento indica o codigo de lancamento 
 * @param conn indica objeto da Classe ConexaoFactory
 * @return honorario excluido 
	 * @author Grupo Omega 
 */
static public int deletarLancamentoF (int cdlancamento, Connection conn) throws Exception {
	return new HonorarioDAO().deleteByCdLancamentoF(cdlancamento, conn);
	
}
	

/**
 * 
 * @param processo indica numero do processo 
 * @param cdLancamento indica o codigo de lancamento 
 * @param l indica objeto classe LancaHonorario  
 * @param conn indica objeto da Classe ConexaoFactory
 * @return honorario atualizado 
	 * @author Grupo Omega 
 */
public int  atualizaHonorario(String processo, String cdLancamento, LancaHonorario l, Connection conn)throws Exception {
	return new HonorarioDAO().atualizarHonorario(processo, cdLancamento, l, conn);
	
}
	

}
