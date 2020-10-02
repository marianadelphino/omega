package br.com.fiap.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import br.com.fiap.bean.LancaDespesa;
import br.com.fiap.bean.Processo;
import br.com.fiap.bean.TipoDespesa;
import br.com.fiap.excecao.Excecao;

public class DespesaDAO {
	/**
	 * insert - Método responsável por lançar uma nova despesa. O último número da sequência é recuperado na query sql0 
	 * @param l indica objeto da classe LancaDespesa
	 * @param conexao indica objeto da Classe ConexaoFactory 
	 * @author Grupo Omega
	 */
	public void insert(LancaDespesa l, Connection conexao) throws Exception {
		BigDecimal lDcodigo = BigDecimal.ZERO;
		String sql0 = "select SQ_AM_OME_LANCA_DESPESA.NEXTVAL from DUAL";
		PreparedStatement estrutura = conexao.prepareStatement(sql0);
		ResultSet rsL = estrutura.executeQuery();

		while (rsL.next()) {
			lDcodigo = rsL.getBigDecimal(1);
		}
		
		estrutura.close();

		String sql1 = "insert into T_AM_OME_LANCA_DESPESA"
				+ "(CD_LANCAMENTO, CD_TIPO_DESPESA, NR_PROCESSO, DT_DESPESA, VL_DESPESA, DS_OBSERVACAO) VALUES (?,?,?,TO_DATE(?, 'dd/mm/yyyy hh24:mi:ss'),?,?)";
		PreparedStatement estrutura1 = conexao.prepareStatement(sql1);
		estrutura1.setBigDecimal(1, lDcodigo);
		estrutura1.setInt(2, l.getTipoDespesa().getCd_tipo_despesa());
		estrutura1.setInt(3, l.getProcesso().getNr_processo());
		estrutura1.setString(4, l.getDt_despesa());
		estrutura1.setDouble(5, l.getVl_despesa());
		estrutura1.setString(6, l.getDs_observacao());
		estrutura1.execute();
		estrutura1.close();
		conexao.commit();
		
	}

	
	/**
	 * listaTipoDespesa - Método responsável por listar todos tipos de despesa cadastradas 
	 * @param conexao indica objeto da Classe ConexaoFactory 
	 * @return retorna lista com tipos de despesas cadastradas 
	 * @author Grupo Omega 
	 */
	public List<TipoDespesa> listaTipoDespesa(Connection conexao) throws Exception {
		List<TipoDespesa> listaTipoDespesa = new ArrayList<TipoDespesa>();
		PreparedStatement estr = conexao.prepareStatement(
				"SELECT CD_TIPO_DESPESA, DS_TIPO_DESPESA FROM T_AM_OME_TIPO_DESPESA ORDER BY CD_TIPO_DESPESA");
		ResultSet resultaDados = estr.executeQuery();
		while (resultaDados.next()) {
			TipoDespesa t = new TipoDespesa();

			t.setCd_tipo_despesa(resultaDados.getInt("CD_TIPO_DESPESA"));
			t.setDs_tipo_despesa(resultaDados.getString("DS_TIPO_DESPESA"));

			listaTipoDespesa.add(t);
		}
		resultaDados.close();
		estr.close();

		return listaTipoDespesa;
	}

	
	
	/**
	 * listaDespesas - Método responsável por listar todas as despesas cadastradas no sistema 
	 * @param conexao indica objeto da Classe ConexaoFactory 
	 * @return lista com todas as despesas cadastradas 
	 * @author Grupo Omega 
	 */
	public List<LancaDespesa> listaDespesas(Connection conexao) throws Exception {
		List<LancaDespesa> listaDespesas = new ArrayList<LancaDespesa>();
		PreparedStatement estr = conexao.prepareStatement(
				"SELECT T_AM_OME_LANCA_DESPESA.CD_LANCAMENTO AS A, T_AM_OME_PROCESSO.NR_PROCESSO AS B, T_AM_OME_PROCESSO.DS_PROCESSO AS C, T_AM_OME_TIPO_DESPESA.DS_TIPO_DESPESA AS D, T_AM_OME_LANCA_DESPESA.DT_DESPESA AS E, T_AM_OME_LANCA_DESPESA.VL_DESPESA AS F "
						+ "FROM T_AM_OME_PROCESSO, T_AM_OME_LANCA_DESPESA, T_AM_OME_TIPO_DESPESA "
						+ "WHERE T_AM_OME_TIPO_DESPESA.CD_TIPO_DESPESA = T_AM_OME_LANCA_DESPESA.CD_TIPO_DESPESA AND "
						+ "T_AM_OME_PROCESSO.NR_PROCESSO = T_AM_OME_LANCA_DESPESA.NR_PROCESSO AND "
						+ "T_AM_OME_PROCESSO.DT_FECHAMENTO IS NULL " + "ORDER BY A DESC");
		ResultSet resultaDados = estr.executeQuery();
		while (resultaDados.next()) {
			LancaDespesa l = new LancaDespesa();
			Processo p = new Processo();
			TipoDespesa t = new TipoDespesa();

			l.setCd_lancamento(resultaDados.getInt("A"));

			p.setNr_processo(resultaDados.getInt("B"));
			l.setProcesso(p);

			p.setDs_processo(resultaDados.getString("C"));
			l.setProcesso(p);

			t.setDs_tipo_despesa(resultaDados.getString("D"));
			l.setTipoDespesa(t);

			l.setDt_despesa(resultaDados.getString("E"));
			l.setVl_despesa(resultaDados.getDouble("F"));

			listaDespesas.add(l);
		}
		resultaDados.close();
		estr.close();

		return listaDespesas;
	}

	
	
	/**
	 * listaDespesasPorProcesso - Este método recebe o número do processo e realiza uma pesquisa para retornar uma lista de despesas por processo
	 * @param x indica filtro de pesquisa (número do processo) 
	 * @param conexao indica objeto da Classe ConexaoFactory 
	 * @return lista de despesas cadastradas de acordo com o processo 
	 * @author Grupo Omega 
	 */
	public List<LancaDespesa> listaDespesasPorProcesso(String x, Connection conexao) throws Exception {
		List<LancaDespesa> listaDespesas = new ArrayList<LancaDespesa>();
		PreparedStatement estr = conexao.prepareStatement(
				"SELECT T_AM_OME_LANCA_DESPESA.CD_LANCAMENTO AS A, T_AM_OME_PROCESSO.NR_PROCESSO AS B, T_AM_OME_PROCESSO.DS_PROCESSO AS C, T_AM_OME_TIPO_DESPESA.DS_TIPO_DESPESA AS D, T_AM_OME_LANCA_DESPESA.DT_DESPESA AS E, T_AM_OME_LANCA_DESPESA.VL_DESPESA AS F "
						+ "FROM T_AM_OME_PROCESSO, T_AM_OME_LANCA_DESPESA, T_AM_OME_TIPO_DESPESA "
						+ "WHERE T_AM_OME_TIPO_DESPESA.CD_TIPO_DESPESA = T_AM_OME_LANCA_DESPESA.CD_TIPO_DESPESA AND "
						+ "T_AM_OME_PROCESSO.NR_PROCESSO = T_AM_OME_LANCA_DESPESA.NR_PROCESSO AND "
						+ "T_AM_OME_PROCESSO.DT_FECHAMENTO IS NULL AND " + "T_AM_OME_PROCESSO.NR_PROCESSO =? "
						+ "ORDER BY A, B");
		estr.setString(1, x);
		ResultSet resultaDados = estr.executeQuery();

		while (resultaDados.next()) {
			LancaDespesa l = new LancaDespesa();
			Processo p = new Processo();
			TipoDespesa t = new TipoDespesa();

			l.setCd_lancamento(resultaDados.getInt("A"));

			p.setNr_processo(resultaDados.getInt("B"));
			l.setProcesso(p);

			p.setDs_processo(resultaDados.getString("C"));
			l.setProcesso(p);

			t.setDs_tipo_despesa(resultaDados.getString("D"));
			l.setTipoDespesa(t);

			l.setDt_despesa(resultaDados.getString("E"));
			l.setVl_despesa(resultaDados.getDouble("F"));

			listaDespesas.add(l);
		}
		resultaDados.close();
		estr.close();

		return listaDespesas;
	}

	
	
	/**
	 * listaDespesasPorId - Método responsável por retornar lista de despesa de acordo com o código de lançamento informado 
	 * @param x indica filtro para pesquisa (código de lançamento da despesa)
	 * @param conexao indica objeto da Classe ConexaoFactory 
	 * @return resultado único para despesa código de lancamento informado 
	 * @author Grupo Omega
	 */
	public List<LancaDespesa> listaDespesasPorId(int x, Connection conexao) throws Exception {
		List<LancaDespesa> listaDespesas = new ArrayList<LancaDespesa>();
		PreparedStatement estr = conexao.prepareStatement(
				"SELECT T_AM_OME_LANCA_DESPESA.CD_LANCAMENTO AS A, T_AM_OME_PROCESSO.NR_PROCESSO AS B, T_AM_OME_PROCESSO.DS_PROCESSO AS C, T_AM_OME_TIPO_DESPESA.DS_TIPO_DESPESA AS D, T_AM_OME_LANCA_DESPESA.DT_DESPESA AS E, T_AM_OME_LANCA_DESPESA.VL_DESPESA AS F "
						+ "FROM T_AM_OME_PROCESSO, T_AM_OME_LANCA_DESPESA, T_AM_OME_TIPO_DESPESA "
						+ "WHERE T_AM_OME_TIPO_DESPESA.CD_TIPO_DESPESA = T_AM_OME_LANCA_DESPESA.CD_TIPO_DESPESA AND "
						+ "T_AM_OME_PROCESSO.NR_PROCESSO = T_AM_OME_LANCA_DESPESA.NR_PROCESSO AND "
						+ "T_AM_OME_PROCESSO.DT_FECHAMENTO IS NULL AND " + "CD_LANCAMENTO =? " + "ORDER BY A, B");
		estr.setInt(1, x);
		ResultSet resultaDados = estr.executeQuery();

		while (resultaDados.next()) {
			LancaDespesa l = new LancaDespesa();
			Processo p = new Processo();
			TipoDespesa t = new TipoDespesa();

			l.setCd_lancamento(resultaDados.getInt("A"));

			p.setNr_processo(resultaDados.getInt("B"));
			l.setProcesso(p);

			p.setDs_processo(resultaDados.getString("C"));
			l.setProcesso(p);

			t.setDs_tipo_despesa(resultaDados.getString("D"));
			l.setTipoDespesa(t);

			l.setDt_despesa(resultaDados.getString("E"));
			l.setVl_despesa(resultaDados.getDouble("F"));

			listaDespesas.add(l);
		}
		resultaDados.close();
		estr.close();

		return listaDespesas;
	}

	
	/**
	 * deleteByCdLancamento - Deleta despesa de acordo com número do processo informado e código de despesa informado 
	 * @param x indica número do processo 
	 * @param y indica número do código de lançamento da despesa 
	 * @param conexao indica objeto da Classe ConexaoFactory 
	 * @return número de despesas excluídas 
	 * @author Grupo Omega 
	 */
	public int deleteByCdLancamento(int x, int y, Connection conexao) throws Exception {
		PreparedStatement estr = conexao
				.prepareStatement("delete from T_AM_OME_LANCA_DESPESA where NR_PROCESSO =? AND CD_LANCAMENTO =?");
		estr.setInt(1, x);
		estr.setInt(2, y);
		int saida = estr.executeUpdate();

		if (saida > 0) {
			System.out.println("Despesa excluída com sucesso!");
		}

		estr.close();

		return saida;
	}

	
	
	/**
	 * deleteByCdLancamentoF - Deleta despesa de acordo com código de despesa informado 
	 * @param y indica código da despesa 
	 * @param conexao indica objeto da Classe ConexaoFactory 
	 * @return número de despesas excluídas 
	 * @author Grupo Omega 
	 */
	public int deleteByCdLancamentoF(int y, Connection conexao) throws Exception {
		PreparedStatement estr = conexao.prepareStatement("delete from T_AM_OME_LANCA_DESPESA where CD_LANCAMENTO =?");
		estr.setInt(1, y);
		int saida = estr.executeUpdate();

		if (saida > 0) {
			System.out.println("Despesa excluída com sucesso!");
		}

		estr.close();

		return saida;
	}

	
	
	/**
	 * atualizarDespesa - Método responsável por atualizar uma nova despesa de acordo com número do processo e código de lançamento da despesa 
	 * @param processo indica numero do processo 
	 * @param cdLancamento indica código de lançamento 
	 * @param l indica objeto classe LancaDespesa  
	 * @param conexao indica objeto da Classe ConexaoFactory 
	 * @return número de despesas atualizadas 
	 * @author Grupo Omega
	 */
	public int atualizarDespesa(String processo, String cdLancamento, LancaDespesa l, Connection conexao)
			throws Exception {
		PreparedStatement estrutura = conexao.prepareStatement(
				"UPDATE T_AM_OME_LANCA_DESPESA SET DT_DESPESA =?, VL_DESPESA =?, DS_OBSERVACAO =? WHERE CD_LANCAMENTO =? AND NR_PROCESSO =?");

		estrutura.setString(1, l.getDt_despesa());
		estrutura.setDouble(2, l.getVl_despesa());
		estrutura.setString(3, l.getDs_observacao());
		estrutura.setString(4, cdLancamento);
		estrutura.setString(5, processo);

		int saida = estrutura.executeUpdate();
		estrutura.close();
		conexao.commit();

		if (saida > 0) {
			System.out.println("Alteração efetivada com sucesso, processo número: " + processo);
		}

		return saida;

	}

	
	/**
	 * atualizarDespesaByCdLancamento - Método responsável por atualizar uma nova despesa de acordo com código de lançamento da despesa 
	 * @param cdLancamento indica código de lançamento da despesa 
	 * @param l indica objeto da classe LancaDespesa 
	 * @param conexao indica objeto da Classe ConexaoFactory 
	 * @return número de despesas atualizadas
	 * @author Grupo Omega 
	 */
	public int atualizarDespesaByCdLancamento(int cdLancamento, LancaDespesa l, Connection conexao) throws Exception {
		PreparedStatement estrutura = conexao.prepareStatement(
				"UPDATE T_AM_OME_LANCA_DESPESA SET DT_DESPESA =?, VL_DESPESA =?, DS_OBSERVACAO =? WHERE CD_LANCAMENTO =?");

		estrutura.setString(1, l.getDt_despesa());
		estrutura.setDouble(2, l.getVl_despesa());
		estrutura.setString(3, l.getDs_observacao());
		estrutura.setInt(4, cdLancamento);

		int saida = estrutura.executeUpdate();
		estrutura.close();
		conexao.commit();

		if (saida > 0) {
			System.out.println("Alteração efetivada com sucesso, processo número!");
		}

		return saida;

	}

}
