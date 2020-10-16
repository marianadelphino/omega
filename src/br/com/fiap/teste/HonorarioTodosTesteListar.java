package br.com.fiap.teste;

import java.sql.Connection;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.fiap.bean.LancaDespesa;
import br.com.fiap.bean.LancaHonorario;
import br.com.fiap.bo.HonorarioBO;
import br.com.fiap.conexao.ConexaoFactory;

public class HonorarioTodosTesteListar {
public static void main(String[] args) throws Exception{
		
		try{
			Connection con = ConexaoFactory.controlarInstancia().getConnection("", "");
			
			JOptionPane.showMessageDialog(null, "\n Teste listar todos os honorários cadastrados");
			
			List<LancaHonorario> lista = HonorarioBO.listarT(con);		
			
		for(LancaHonorario x : lista){
		System.out.println(x.getTudo());	
		}
		}catch (Exception e ){
			e.printStackTrace();
		}

	}

}
