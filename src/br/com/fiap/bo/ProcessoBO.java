package br.com.fiap.bo;

import java.sql.Connection;
import java.util.List;
import br.com.fiap.bean.Processo;
import br.com.fiap.dao.ProcessoDAO;

public class ProcessoBO {

	/**
	 * listarProcesso - lista todos os processo cadastrados 
	 * @param conn indica objeto da Classe ConexaoFactory
	 * @return lista com todos os processos cadastrados 
	 * @author Grupo Omega 
	 */
	public static List<Processo> listarProcesso(Connection conn) throws Exception {
		return new ProcessoDAO().listaProcesso(conn);
	}

	
	/**
	 * listarProcessoF - lista todos os processo cadastrados de acordo com o filtro 
	 * @param x indica o filtro número do processo 
	 * @param y indica o filtro razão social do cliente 
	 * @param w indica o filtro data inicial para pesquisa
	 * @param z indica o filtro data final para pesquisa 
	 * @param conn indica objeto da Classe ConexaoFactory
	 * @return lista de processos ativos cadastrados de acordo com filtro informado 
	 * @author Grupo Omega 
	 */
	public static List<Processo> listarProcessoF(int x, String y, String z, String w, Connection conn)
			throws Exception {
		return new ProcessoDAO().listaProcessoFiltro(x, y, z, w, conn);
	}

}
