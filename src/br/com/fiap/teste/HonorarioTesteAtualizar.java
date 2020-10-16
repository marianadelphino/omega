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
			
			JOptionPane.showMessageDialog(null, "\n Teste atualizar um honorario por número do Processo e Código de Lançamento do Honorário");
			String processo = JOptionPane.showInputDialog("Digite o número do processo: ");	
			String cdLancamento = JOptionPane.showInputDialog("Digite o código de lancamento: ");	
			
			l.setDt_honorario((JOptionPane.showInputDialog("Nova data do honorário: ")));
			l.setQt_hora(Double.parseDouble((JOptionPane.showInputDialog("Nova quantidade horas do honorário: "))));
			l.setDs_observacao((JOptionPane.showInputDialog("Nova observação: ")));
			
			bo.atualizaHonorario(processo, cdLancamento, l,  con);
			
			
	 } catch (Exception e ){
		e.printStackTrace();
	}

	}

}
