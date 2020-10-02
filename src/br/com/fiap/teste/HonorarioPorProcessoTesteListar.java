package br.com.fiap.teste;

import java.sql.Connection;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.fiap.bean.LancaHonorario;
import br.com.fiap.bo.HonorarioBO;
import br.com.fiap.conexao.ConexaoFactory;

public class HonorarioPorProcessoTesteListar {
	public static void main(String[] args) throws Exception{
		
		try{
			Connection con = ConexaoFactory.controlarInstancia().getConnection("", "");
			
			JOptionPane.showMessageDialog(null, "\n Teste listar honorários por número do Processo");
			String pesquisa = JOptionPane.showInputDialog("Informe o número do processo: ");	
			List<LancaHonorario> lista = HonorarioBO.listarPorProcessoT(pesquisa, con);		
			
		for(LancaHonorario x : lista){
		System.out.println(x.getTudo());	
		}
		}catch (Exception e ){
			e.printStackTrace();
		}
	}
	}
