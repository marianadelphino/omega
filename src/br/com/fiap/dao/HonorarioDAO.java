package br.com.fiap.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import br.com.fiap.bean.Cliente;
import br.com.fiap.bean.LancaDespesa;
import br.com.fiap.bean.LancaHonorario;
import br.com.fiap.bean.Processo;
import br.com.fiap.bean.TipoDespesa;
import br.com.fiap.bean.TipoTarefa;

public class HonorarioDAO {

	/**
	 * insert - M�todo respons�vel por lan�ar um novo honor�rio. O �ltimo n�mero da sequ�ncia � recuperado na query sql0 
	 * @param l indica objeto da classe LancaHonorario
	 * @param conexao indica objeto da Classe ConexaoFactory 
	 * @author Grupo Omega 
	 */
	public void insert(LancaHonorario l, Connection conexao) throws Exception {		
		BigDecimal lHcodigo = BigDecimal.ZERO;		
			String sql0 = "select SQ_AM_OME_LANCA_HONORARIO.NEXTVAL from DUAL";
			PreparedStatement estrutura = conexao.prepareStatement(sql0);
			ResultSet rsL = estrutura.executeQuery();

			while (rsL.next()) {
				lHcodigo = rsL.getBigDecimal(1);
			}
			estrutura.close();
									
			String sql1 = "INSERT INTO T_AM_OME_LANCA_HONORARIO"+ "(CD_LANCAMENTO, CD_TIPO_TAREFA, NR_PROCESSO, DT_HONORARIO, QT_HORA, DS_OBSERVACAO) VALUES (?, ?, ?, TO_DATE(?, 'dd/mm/yyyy hh24:mi:ss'), ?, ?)";
			PreparedStatement estrutura1 = conexao.prepareStatement(sql1);
			estrutura1.setBigDecimal(1, lHcodigo); 
			estrutura1.setInt(2, l.getTipoTarefa().getCd_tipo_tarefa());
			estrutura1.setInt(3, l.getProcesso().getNr_processo());
			estrutura1.setString(4, l.getDt_honorario()); 
			estrutura1.setDouble(5, l.getQt_hora());
			estrutura1.setString(6,  l.getDs_observacao());
			estrutura1.execute();		
			estrutura1.close();
			conexao.commit();			
	}
	
	
	/**
	 * listaTipoTarefa - M�todo respons�vel por listar todos tipos de tarefas cadastradas 
	 * @param conexao indica objeto da Classe ConexaoFactory 
	 * @return retorna lista com tipos de tarefas cadastradas 
	 * @throws Grupo Omega
	 */
	public List<TipoTarefa> listaTipoTarefa(Connection conexao) throws Exception {
		List<TipoTarefa> listaTipoTarefa = new ArrayList<TipoTarefa>();
		PreparedStatement estr = conexao.prepareStatement("SELECT CD_TIPO_TAREFA, DS_TIPO_TAREFA FROM T_AM_OME_TIPO_TAREFA ORDER BY CD_TIPO_TAREFA");
		ResultSet resultaDados = estr.executeQuery();
		while (resultaDados.next()) {
			TipoTarefa t = new TipoTarefa();
			
		t.setCd_tipo_tarefa(resultaDados.getInt("CD_TIPO_TAREFA"));
		t.setDs_tipo_tarefa(resultaDados.getString("DS_TIPO_TAREFA"));
		
		listaTipoTarefa .add(t);
		}
		resultaDados.close();
		estr.close();

		return listaTipoTarefa ;
	}
	
	
	
	
	
	/**
	 * listaHonorario - M�todo respons�vel por listar todos os honr�rios cadastrados no sistema 
	 * @param conexao indica objeto da Classe ConexaoFactory 
	 * @return lista com todas os honor�rios cadastradas 
	 * @author Grupo Omega 
	 */
	public List<LancaHonorario> listaHonorario(Connection conexao) throws Exception {
		List<LancaHonorario> listaHonorarios = new ArrayList<LancaHonorario>();
		PreparedStatement estr = conexao.prepareStatement("SELECT T_AM_OME_LANCA_HONORARIO.CD_LANCAMENTO AS A, T_AM_OME_PROCESSO.NR_PROCESSO AS B, T_AM_OME_PROCESSO.DS_PROCESSO AS C, T_AM_OME_TIPO_TAREFA.CD_TIPO_TAREFA AS D, T_AM_OME_TIPO_TAREFA.DS_TIPO_TAREFA AS E, T_AM_OME_LANCA_HONORARIO.QT_HORA AS F "
				+ "FROM T_AM_OME_LANCA_HONORARIO, T_AM_OME_TIPO_TAREFA, T_AM_OME_PROCESSO "
				+ "WHERE T_AM_OME_TIPO_TAREFA.CD_TIPO_TAREFA = T_AM_OME_LANCA_HONORARIO.CD_TIPO_TAREFA AND "
				+ "T_AM_OME_PROCESSO.NR_PROCESSO = T_AM_OME_LANCA_HONORARIO.NR_PROCESSO AND T_AM_OME_PROCESSO.DT_FECHAMENTO IS NULL ORDER BY A DESC");
		ResultSet resultaDados = estr.executeQuery();
		while (resultaDados.next()) {						
			Cliente c = new Cliente (); 
			Processo p = new Processo ();
			TipoTarefa t = new TipoTarefa();
			LancaHonorario l = new LancaHonorario(); 
			
			l.setCd_lancamento(resultaDados.getInt("A"));
			
			p.setNr_processo(resultaDados.getInt("B"));
			l.setProcesso(p);
			
			p.setDs_processo(resultaDados.getString("C"));
			l.setProcesso(p);
			
			t.setCd_tipo_tarefa(resultaDados.getInt("D"));
			l.setTipoTarefa(t);
			
			t.setDs_tipo_tarefa(resultaDados.getString("E"));
			l.setTipoTarefa(t);
			
			l.setQt_hora(resultaDados.getDouble("F"));
								
		listaHonorarios.add(l);
		}
		resultaDados.close();
		estr.close();

		return listaHonorarios;
	}
	
	
	
	
	
	
	
	/**
	 * listaHonorariosPorProcesso - Este m�todo recebe o n�mero do processo e realiza uma pesquisa para retornar uma lista de honor�rios por processo
	 * @param x indica filtro de pesquisa (n�mero do processo) 
	 * @param conexao indica objeto da Classe ConexaoFactory 
	 * @return lista de honor�rios cadastradas de acordo com o processo 
	 * @author Grupo Omega 
	 */
	public List<LancaHonorario> listaHonorariosPorProcesso(String x, Connection conexao) throws Exception {
		List<LancaHonorario> listaHonorario = new ArrayList<LancaHonorario>();
		PreparedStatement estr = conexao.prepareStatement("SELECT T_AM_OME_LANCA_HONORARIO.CD_LANCAMENTO AS A, T_AM_OME_PROCESSO.NR_PROCESSO AS B, T_AM_OME_PROCESSO.DS_PROCESSO AS C, T_AM_OME_TIPO_TAREFA.CD_TIPO_TAREFA AS D, T_AM_OME_TIPO_TAREFA.DS_TIPO_TAREFA AS E, T_AM_OME_LANCA_HONORARIO.QT_HORA AS F "
				+ "FROM T_AM_OME_LANCA_HONORARIO, T_AM_OME_TIPO_TAREFA, T_AM_OME_PROCESSO "
				+ "WHERE T_AM_OME_TIPO_TAREFA.CD_TIPO_TAREFA = T_AM_OME_LANCA_HONORARIO.CD_TIPO_TAREFA AND "
				+ "T_AM_OME_PROCESSO.NR_PROCESSO = T_AM_OME_LANCA_HONORARIO.NR_PROCESSO AND T_AM_OME_PROCESSO.DT_FECHAMENTO IS NULL AND T_AM_OME_PROCESSO.NR_PROCESSO =? ORDER BY A DESC");
		estr.setString(1, x);
		ResultSet resultaDados = estr.executeQuery();

		while (resultaDados.next()) {
			LancaHonorario l = new LancaHonorario();
			Processo p = new Processo();
			TipoTarefa t = new TipoTarefa();

l.setCd_lancamento(resultaDados.getInt("A"));
			
			p.setNr_processo(resultaDados.getInt("B"));
			l.setProcesso(p);
			
			p.setDs_processo(resultaDados.getString("C"));
			l.setProcesso(p);
			
			t.setCd_tipo_tarefa(resultaDados.getInt("D"));
			l.setTipoTarefa(t);
			
			t.setDs_tipo_tarefa(resultaDados.getString("E"));
			l.setTipoTarefa(t);
			
			l.setQt_hora(resultaDados.getDouble("F"));

			listaHonorario.add(l);
		}
		resultaDados.close();
		estr.close();

		return listaHonorario;
	}
	
	
	/**
	 * deleteByCdLancamento - Deleta honorario de acordo com n�mero do processo informado e c�digo de despesa informado 
	 * @param x indica n�mero do processo 
	 * @param y indica n�mero do c�digo de lan�amento do honorario 
	 * @param conexao indica objeto da Classe ConexaoFactory 
	 * @return n�mero de honorarios exclu�dos 
	 * @author Grupo Omega 
	 */
	public int deleteByCdLancamento(int x, int y, Connection conexao) throws Exception {
		PreparedStatement estr = conexao
				.prepareStatement("delete from T_AM_OME_LANCA_HONORARIO where NR_PROCESSO =? AND CD_LANCAMENTO =?");
		estr.setInt(1, x);
		estr.setInt(2, y);
		int saida = estr.executeUpdate();

		if (saida > 0) {
			System.out.println("Honor�rio exclu�do com sucesso!");
		}

		estr.close();

		return saida;
	}
	
	/**
	 * deleteByCdLancamentoF - Deleta honorario de acordo com c�digo de honorario informado 
	 * @param y indica c�digo do honorario
	 * @param conexao indica objeto da Classe ConexaoFactory 
	 * @return n�mero de honorarios exclu�dos 
	 * @author Grupo Omega 
	 */
	public int deleteByCdLancamentoF(int y, Connection conexao) throws Exception {
		PreparedStatement estr = conexao.prepareStatement("delete from T_AM_OME_LANCA_HONORARIO where CD_LANCAMENTO =?");
		estr.setInt(1, y);
		int saida = estr.executeUpdate();

		if (saida > 0) {
			System.out.println("Honor�rio exclu�do com sucesso!");
		}

		estr.close();

		return saida;
	}

	

	/**
	 * atualizarHonorario - M�todo respons�vel por atualizar uma nova honorario de acordo com n�mero do processo e c�digo de lan�amento da honorario 
	 * @param processo indica numero do processo 
	 * @param cdLancamento indica c�digo de lan�amento 
	 * @param l indica objeto classe LancaHonorario  
	 * @param conexao indica objeto da Classe ConexaoFactory 
	 * @return n�mero de honorarios atualizados 
	 * @author Grupo Omega
	 */
	public int atualizarHonorario(String processo, String cdLancamento, LancaHonorario l, Connection conexao)
			throws Exception {
		PreparedStatement estrutura = conexao.prepareStatement(
				"UPDATE T_AM_OME_LANCA_HONORARIO SET DT_HONORARIO =?, QT_HORA =?, DS_OBSERVACAO =? WHERE CD_LANCAMENTO =? AND NR_PROCESSO =?");

		estrutura.setString(1, l.getDt_honorario());
		estrutura.setDouble(2, l.getQt_hora());
		estrutura.setString(3, l.getDs_observacao());
		estrutura.setString(4, cdLancamento);
		estrutura.setString(5, processo);

		int saida = estrutura.executeUpdate();
		estrutura.close();
		conexao.commit();

		if (saida > 0) {
			System.out.println("Altera��o efetivada com sucesso, processo n�mero: " + processo);
		}

		return saida;

	}
	
	
}
