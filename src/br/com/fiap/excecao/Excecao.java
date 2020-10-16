package br.com.fiap.excecao;

public class Excecao extends Exception{
	public Excecao(){
		System.out.println("Houve algum erro! ");
	}
	public Excecao(String x){
		System.out.println(x);
	}
	public Excecao(Exception x){
		System.out.println(x);
	}
	public Excecao(String x, Exception y){
		System.out.println(x+"\n"+ y);
	}

}
