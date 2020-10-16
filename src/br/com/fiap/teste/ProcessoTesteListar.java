package br.com.fiap.teste;

import java.sql.Connection;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.fiap.bean.Processo;
import br.com.fiap.bo.ProcessoBO;
import br.com.fiap.conexao.ConexaoFactory;

public class ProcessoTesteListar {
	public static void main(String[] args) throws Exception{
	try{
		Connection con = ConexaoFactory.controlarInstancia().getConnection("", "");
		
		JOptionPane.showMessageDialog(null, "\n Teste listar todos os processos ativos cadastrados");
		List<Processo> lista = ProcessoBO.listarProcesso(con);		
		
	for(Processo x : lista){
	System.out.println(x.getTudo());	
	}
	}catch (Exception e ){
		e.printStackTrace();
	}

}

}


