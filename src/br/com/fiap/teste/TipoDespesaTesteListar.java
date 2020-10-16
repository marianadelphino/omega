package br.com.fiap.teste;

import java.sql.Connection;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.fiap.bean.TipoDespesa;
import br.com.fiap.bo.DespesaBO;
import br.com.fiap.conexao.ConexaoFactory;

public class TipoDespesaTesteListar {
	public static void main(String[] args) throws Exception{
		
		try{
			Connection con = ConexaoFactory.controlarInstancia().getConnection("", "");
			
			JOptionPane.showMessageDialog(null, "\n Teste listar todos os tipos de despesas cadastradas");
			List<TipoDespesa> lista = DespesaBO.listarTipoDespesa(con);		
			
		for(TipoDespesa x : lista){
		System.out.println(x.getTudo());	
		}
		}catch (Exception e ){
			e.printStackTrace();
		}

	}

}
