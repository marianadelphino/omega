package br.com.fiap.teste;

import java.sql.Connection;

import javax.swing.JOptionPane;

import br.com.fiap.bean.LancaDespesa;
import br.com.fiap.bean.Processo;
import br.com.fiap.bean.TipoDespesa;
import br.com.fiap.bo.DespesaBO;
import br.com.fiap.conexao.ConexaoFactory;
import br.com.fiap.excecao.Excecao;

public class DespesaTesteIncluir {
	
	public static void main(String[] args) throws Excecao{
		try{
			
			Connection con = ConexaoFactory.controlarInstancia().getConnection("", "");
			LancaDespesa l = new LancaDespesa(); 
			TipoDespesa t = new TipoDespesa(); 
			Processo p = new Processo(); 
			
			
			JOptionPane.showMessageDialog(null, "\n Teste incluir uma nova despesa");
			t.setCd_tipo_despesa(Integer.parseInt(JOptionPane.showInputDialog("\n Código '1' - XEROX \n Código '2' - DECLARAÇÃO \n Código '3' - AUTENTICAÇÃO \n Código '4' - PASSAGEM AÉRIA \n Código '5' - DIÁRIA DE VIAGEM \n Código '6' - OUTROS \n Informe código do tipo de despesa:")));		
			l.setTipoDespesa(t);
			
			p.setNr_processo(Integer.parseInt(JOptionPane.showInputDialog("Informe número do processo: ")));
			l.setProcesso(p);
			
			l.setDt_despesa((JOptionPane.showInputDialog("Data da despesa: ")));
			l.setVl_despesa(Double.parseDouble((JOptionPane.showInputDialog("Valor da despesa: "))));
			l.setDs_observacao((JOptionPane.showInputDialog("Observação: ")));
			
			DespesaBO.incluir(l, con);			
		
			 
	 } catch (Exception e ){
		e.printStackTrace();
	}

	}

}
