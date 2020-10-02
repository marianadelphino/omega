package br.com.fiap.teste;

import java.sql.Connection;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.fiap.bean.Processo;
import br.com.fiap.bo.ProcessoBO;
import br.com.fiap.conexao.ConexaoFactory;

public class ProcessoFiltroTesteListar {
public static void main(String[] args) throws Exception{
		
		try{
			Connection con = ConexaoFactory.controlarInstancia().getConnection("", "");
			
			JOptionPane.showMessageDialog(null, "\n Teste listar processos por filtros \n Se não souber o número do processo, digite zero");
			int x = Integer.parseInt(JOptionPane.showInputDialog("Informe o número do processo: "));		
			String y = (JOptionPane.showInputDialog("Informe o nome do cliente: "));
			String z = (JOptionPane.showInputDialog("Informe data inicial: "));
			String w = (JOptionPane.showInputDialog("Informe data final: "));
			
			List<Processo> lista = ProcessoBO.listarProcessoF(x, y, z, w, con);		
			
		for(Processo p : lista){
		System.out.println(p.getTudo());	
		}
		}catch (Exception e ){
			e.printStackTrace();
		}
	}
	}
