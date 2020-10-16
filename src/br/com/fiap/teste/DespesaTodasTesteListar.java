package br.com.fiap.teste;

import java.sql.Connection;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.fiap.bean.LancaDespesa;
import br.com.fiap.bo.DespesaBO;
import br.com.fiap.conexao.ConexaoFactory;

public class DespesaTodasTesteListar {
public static void main(String[] args) throws Exception{
		
		try{
			Connection con = ConexaoFactory.controlarInstancia().getConnection("", "");
			
			JOptionPane.showMessageDialog(null, "\n Teste listar todas as despesas cadastradas");
			
			List<LancaDespesa> lista = DespesaBO.listarT(con);		
			
		for(LancaDespesa x : lista){
		System.out.println(x.getTudo());	
		}
		}catch (Exception e ){
			e.printStackTrace();
		}

	}

}
