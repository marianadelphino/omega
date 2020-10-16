package br.com.fiap.teste;

import java.sql.Connection;

import javax.swing.JOptionPane;

import br.com.fiap.bean.LancaHonorario;
import br.com.fiap.bean.Processo;
import br.com.fiap.bean.TipoTarefa;
import br.com.fiap.bo.HonorarioBO;
import br.com.fiap.conexao.ConexaoFactory;
import br.com.fiap.excecao.Excecao;

public class HonorarioTesteIncluir {

	public static void main(String[] args) throws Excecao{
		try{
			
			Connection con = ConexaoFactory.controlarInstancia().getConnection("", "");
			LancaHonorario l = new LancaHonorario(); 
			TipoTarefa t = new TipoTarefa(); 
			Processo p = new Processo(); 
			
			
			JOptionPane.showMessageDialog(null, "\n Teste incluir um novo honor�rio");
			t.setCd_tipo_tarefa(Integer.parseInt(JOptionPane.showInputDialog("\n C�digo '1' - REUNI�O \n C�digo '2' - AUDI�NCIA \n C�digo '3' - ESTUDO DE PROCESSO \n C�digo '4' - \n Informe c�digo do tipo de tarefa:")));		
			l.setTipoTarefa(t);
			
			p.setNr_processo(Integer.parseInt(JOptionPane.showInputDialog("Informe n�mero do processo: ")));
			l.setProcesso(p);
					
			
			l.setDt_honorario((JOptionPane.showInputDialog("Data do honor�rio: ")));
			l.setQt_hora(Double.parseDouble((JOptionPane.showInputDialog("Quantidade de hora: "))));
			
			l.setDs_observacao((JOptionPane.showInputDialog("Observa��o: ")));
			
			HonorarioBO.incluir(l, con);			
		
			 
	 } catch (Exception e ){
		e.printStackTrace();
	}

	}

}
