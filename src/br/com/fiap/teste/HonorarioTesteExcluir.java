package br.com.fiap.teste;

import java.sql.Connection;

import javax.swing.JOptionPane;

import br.com.fiap.bo.HonorarioBO;
import br.com.fiap.conexao.ConexaoFactory;
import br.com.fiap.excecao.Excecao;

public class HonorarioTesteExcluir {

	public static void main(String[] args) throws Exception{
		
		try{
			
			
			Connection con = ConexaoFactory.controlarInstancia().getConnection("", "");
			HonorarioBO bo = new HonorarioBO();

			JOptionPane.showMessageDialog(null, "\n Teste excluir honorário por número do Processo e Código de Lançamento de Honorário");
			int processo = Integer.parseInt(JOptionPane.showInputDialog("Digite o número do processo: "));		
			int cdLancamento = Integer.parseInt(JOptionPane.showInputDialog("Digite o código de lancamento: "));	
			bo.deletarLancamento(processo, cdLancamento, con);
			
		}catch (Exception e ){
			throw new Excecao (e); 
		}

	}

}
