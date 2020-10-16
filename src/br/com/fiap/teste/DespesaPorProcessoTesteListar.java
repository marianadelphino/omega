package br.com.fiap.teste;

import javax.swing.JOptionPane;

import java.sql.*;
import java.util.List;

import br.com.fiap.bean.LancaDespesa;
import br.com.fiap.bo.DespesaBO;
import br.com.fiap.conexao.ConexaoFactory;
import br.com.fiap.excecao.Excecao;

public class DespesaPorProcessoTesteListar {		
		public static void main(String[] args) throws Exception{
			
			try{
				Connection con = ConexaoFactory.controlarInstancia().getConnection("", "");
				
				JOptionPane.showMessageDialog(null, "\n Teste listar despesas por número do Processo");
				String pesquisa = JOptionPane.showInputDialog("Informe o número do processo: ");	
				List<LancaDespesa> lista = DespesaBO.listarPorProcessoT(pesquisa, con);		
				
			for(LancaDespesa x : lista){
			System.out.println(x.getTudo());	
			}
			}catch (Exception e ){
				e.printStackTrace();
			}
		}
		}
