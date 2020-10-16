package br.com.fiap.teste;

import java.sql.Connection;

import javax.swing.JOptionPane;

import br.com.fiap.bo.DespesaBO;
import br.com.fiap.conexao.ConexaoFactory;
import br.com.fiap.excecao.Excecao;

public class DespesaTesteExcluir {

	public static void main(String[] args) throws Exception{
		
		try{
			
			
			Connection con = ConexaoFactory.controlarInstancia().getConnection("", "");
			DespesaBO bo = new DespesaBO();

			JOptionPane.showMessageDialog(null, "\n Teste excluir despesa por n�mero do Processo e C�digo de Lan�amento de Despesa");
			int processo = Integer.parseInt(JOptionPane.showInputDialog("Digite o n�mero do processo: "));		
			int cdLancamento = Integer.parseInt(JOptionPane.showInputDialog("Digite o c�digo de lancamento: "));	
			bo.deletarLancamento(processo, cdLancamento, con);
			
		}catch (Exception e ){
			throw new Excecao (e); 
		}

	}

}
