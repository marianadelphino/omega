package br.com.fiap.bean;

public class Pessoa {
	int cd_pessoa;
	String nm_pessoa;

	
	public Pessoa() {
		super();
	}

	public Pessoa(int cd_pessoa, String nm_pessoa) {
		super();
		this.cd_pessoa = cd_pessoa;
		this.nm_pessoa = nm_pessoa;
	}

	public int getCd_pessoa() {
		return cd_pessoa;
	}

	public void setCd_pessoa(int cd_pessoa) {
		this.cd_pessoa = cd_pessoa;
	}

	public String getNm_pessoa() {
		return nm_pessoa;
	}

	public void setNm_pessoa(String nm_pessoa) {
		this.nm_pessoa = nm_pessoa;
	}
	
	
	
	

}
