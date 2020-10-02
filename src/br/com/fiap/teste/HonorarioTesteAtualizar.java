package br.com.fiap.teste;

import java.sql.Connection;

import javax.swing.JOptionPane;

import br.com.fiap.bean.LancaHonorario;
import br.com.fiap.bo.HonorarioBO;
import br.com.fiap.conexao.ConexaoFactory;
import br.com.fiap.excecao.Excecao;

public class HonorarioTesteAtualizar {
	public static void main(String[] args) throws Excecao{
		try{
			Connection con = ConexaoFactory.controlarInstancia().getConnection("", "");
			HonorarioBO bo = new HonorarioBO();
			LancaHonorario l = new LancaHonorario();
			
			JOptionPane.showMessageDialog(null, "\n Teste atualizar um honorario por n�mero do Processo e C�digo de Lan�amento do Honor�rio");
			String processo = JOptionPane.showInputDialog("Digite o n�mero do processo: ");	
			String cdLancamento = JOptionPane.showInputDialog("Digite o c�digo de lancamento: ");	
			
			l.setDt_honorario((JOptionPane.showInputDialog("Nova data do honor�rio: ")));
			l.setQt_hora(Double.parseDouble((JOptionPane.showInputDialog("Nova quantidade horas do honor�rio: "))));
			l.setDs_observacao((JOptionPane.showInputDialog("Nova observa��o: ")));
			
			bo.atualizaHonorario(processo, cdLancamento, l,  con);
			
			
	 } catch (Exception e ){
		e.printStackTrace();
	}

	}

}
