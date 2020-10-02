package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.bean.Cliente;
import br.com.fiap.bean.Processo;

public class ProcessoDAO {
	
	/**
	 * listaProcesso - Método é responsável por listar todos os processos ativos cadastrados 
	 * @param conexao indica objeto da Classe ConexaoFactory 
	 * @return lista de processos ativos cadastrados 
	 * @author Grupo Omega 
	 */
		public List<Processo> listaProcesso(Connection conexao) throws Exception {
			List<Processo> listaProcesso = new ArrayList<Processo>();
			PreparedStatement estr = conexao.prepareStatement("SELECT NR_PROCESSO, DS_PROCESSO, DS_RAZAO_SOCIAL "
					+ "FROM T_AM_OME_PROCESSO P, T_AM_OME_CLIENTE C "
					+ "WHERE P.CD_CLIENTE = C.CD_CLIENTE AND "
					+ "DT_FECHAMENTO IS NULL "
					+ "ORDER BY NR_PROCESSO");
			ResultSet resultaDados = estr.executeQuery();
			while (resultaDados.next()) {
			Processo p = new Processo();
			Cliente c = new Cliente(); 
			p.setNr_processo(resultaDados.getInt("NR_PROCESSO"));
			p.setDs_processo(resultaDados.getString("DS_PROCESSO"));			
			c.setDs_razao_social(resultaDados.getString("DS_RAZAO_SOCIAL"));
			p.setCliente(c); 	
			
			listaProcesso.add(p);
			}
			resultaDados.close();
			estr.close();

			return listaProcesso;		
	}

	
		
	/**
	 * listaProcessoFiltro - Método responsável por listar processos ativos cadastrados de acordo com um filtro informado 
	 * @param x indica o filtro número do processo 
	 * @param y indica o filtro razão social do cliente 
	 * @param w indica o filtro data inicial para pesquisa
	 * @param z indica o filtro data final para pesquisa 
	 * @param conexao indica objeto da Classe ConexaoFactory 
	 * @return lista de processos ativos cadastrados de acordo com filtro informado 
	 * @author Grupo Omega 
	 */
		public List<Processo> listaProcessoFiltro(int x, String y, String w, String z, Connection conexao) throws Exception {
			List<Processo> listaProcesso = new ArrayList<Processo>();
					
			PreparedStatement estr = conexao.prepareStatement("SELECT DISTINCT NR_PROCESSO, DS_PROCESSO, DS_RAZAO_SOCIAL "
					+ "FROM T_AM_OME_PROCESSO, T_AM_OME_CLIENTE "
					+ "WHERE (T_AM_OME_PROCESSO.CD_CLIENTE = T_AM_OME_CLIENTE.CD_CLIENTE) AND "
					+ "(DT_FECHAMENTO IS NULL) AND (NR_PROCESSO =? OR DS_RAZAO_SOCIAL =? OR DT_ABERTURA BETWEEN TO_DATE(?, 'dd/mm/yyyy hh24:mi:ss') AND TO_DATE(?, 'dd/mm/yyyy hh24:mi:ss')) "
					+ "ORDER BY NR_PROCESSO");
					
			estr.setInt(1, x);
			estr.setString(2, y);
			estr.setString(3, w);
			estr.setString(4, z);
			ResultSet resultaDados = estr.executeQuery();
			while (resultaDados.next()) {
			Processo p = new Processo();
			Cliente c = new Cliente(); 
			p.setNr_processo(resultaDados.getInt("NR_PROCESSO"));
			p.setDs_processo(resultaDados.getString("DS_PROCESSO"));			
			c.setDs_razao_social(resultaDados.getString("DS_RAZAO_SOCIAL"));
			p.setCliente(c); 	
			
			listaProcesso.add(p);
			}
			resultaDados.close();
			estr.close();

			return listaProcesso;		
	}
}
