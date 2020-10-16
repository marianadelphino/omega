package br.com.fiap.bean;

public class Advogado extends Pessoa {
	int cd_advogado;
	int nr_oab;
	int nr_cpf;
	String nr_rg;
	String ds_email;
	String ds_password;

	public Advogado() {
		super();
	}

	public Advogado(int cd_advogado, int nr_oab, int nr_cpf, String nr_rg, String ds_email, String ds_password) {
		super();
		this.cd_advogado = cd_advogado;
		this.nr_oab = nr_oab;
		this.nr_cpf = nr_cpf;
		this.nr_rg = nr_rg;
		this.ds_email = ds_email;
		this.ds_password = ds_password;
	}

	public int getCd_advogado() {
		return cd_advogado;
	}

	public void setCd_advogado(int cd_advogado) {
		this.cd_advogado = cd_advogado;
	}

	public int getNr_oab() {
		return nr_oab;
	}

	public void setNr_oab(int nr_oab) {
		this.nr_oab = nr_oab;
	}

	public int getNr_cpf() {
		return nr_cpf;
	}

	public void setNr_cpf(int nr_cpf) {
		this.nr_cpf = nr_cpf;
	}

	public String getNr_rg() {
		return nr_rg;
	}

	public void setNr_rg(String nr_rg) {
		this.nr_rg = nr_rg;
	}

	public String getDs_email() {
		return ds_email;
	}

	public void setDs_email(String ds_email) {
		this.ds_email = ds_email;
	}

	public String getDs_password() {
		return ds_password;
	}

	public void setDs_password(String ds_password) {
		this.ds_password = ds_password;
	}
	
	
	public String getTudo() {
		return "Código: " + cd_advogado + " \n Nome: " + nm_pessoa;
	}
	
	

}
