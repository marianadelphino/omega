package br.com.fiap.teste;

import java.sql.Connection;

import javax.swing.JOptionPane;

import br.com.fiap.bean.LancaDespesa;
import br.com.fiap.bean.Processo;
import br.com.fiap.bean.TipoDespesa;
import br.com.fiap.bo.DespesaBO;
import br.com.fiap.conexao.ConexaoFactory;
import br.com.fiap.excecao.Excecao;

public class DespesaTesteAtualizar {
	public static void main(String[] args) throws Excecao{
		try{
			Connection con = ConexaoFactory.controlarInstancia().getConnection("", "");
			DespesaBO bo = new DespesaBO();
			LancaDespesa l = new LancaDespesa();
			
			JOptionPane.showMessageDialog(null, "\n Teste atualizar uma despesa por n�mero do Processo e C�digo de Lan�amento de Despesa");
			String processo = JOptionPane.showInputDialog("Digite o n�mero do processo: ");	
			String cdLancamento = JOptionPane.showInputDialog("Digite o c�digo de lancamento: ");	
			
			l.setDt_despesa((JOptionPane.showInputDialog("Nova data da despesa: ")));
			l.setVl_despesa(Double.parseDouble((JOptionPane.showInputDialog("Novo valor da despesa: "))));
			l.setDs_observacao((JOptionPane.showInputDialog("Nova observa��o: ")));
			
			bo.atualizaDespesa(processo, cdLancamento, l,  con);
			
			
	 } catch (Exception e ){
		e.printStackTrace();
	}

	}

}
