package br.com.fiap.teste;

import java.sql.Connection;

import javax.swing.JOptionPane;

import br.com.fiap.conexao.ConexaoFactory;
import br.com.fiap.excecao.Excecao;

public class _01_TesteConexao {

	public static void main(String[] args) throws Excecao {

		Connection c = null;

		try {
			String u=JOptionPane.showInputDialog("Digite o usuário");
			String s= JOptionPane.showInputDialog("Digite a senha");
			c=ConexaoFactory.controlarInstancia().getConnection(u, s);
			
			//c = new ConexaoFactory().getConnection();
			System.out.println("Conexao aberta");
		} catch (Exception e) {
		e.printStackTrace();
			System.out.println("Erro de conexao");
		} finally {
			try {
				c.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}

}
