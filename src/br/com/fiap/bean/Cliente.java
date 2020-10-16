package br.com.fiap.bean;

public class Cliente extends Pessoa {

	int cd_cliente;
	String ds_razao_social;
	int nr_cnpj;
	int nr_insc_estadual;
	String ds_email;
	String ds_password;

	public Cliente() {
		super();
	}

	public Cliente(int cd_cliente, String ds_razao_social, int nr_cnpj, int nr_insc_estadual, String ds_email,
			String ds_password) {
		super();
		this.cd_cliente = cd_cliente;
		this.ds_razao_social = ds_razao_social;
		this.nr_cnpj = nr_cnpj;
		this.nr_insc_estadual = nr_insc_estadual;
		this.ds_email = ds_email;
		this.ds_password = ds_password;

	}

	public int getCd_cliente() {
		return cd_cliente;
	}

	public void setCd_cliente(int cd_cliente) {
		this.cd_cliente = cd_cliente;
	}

	public String getDs_razao_social() {
		return ds_razao_social;
	}

	public void setDs_razao_social(String ds_razao_social) {
		this.ds_razao_social = ds_razao_social;
	}

	public int getNr_cnpj() {
		return nr_cnpj;
	}

	public void setNr_cnpj(int nr_cnpj) {
		this.nr_cnpj = nr_cnpj;
	}

	public int getNr_insc_estadual() {
		return nr_insc_estadual;
	}

	public void setNr_insc_estadual(int nr_insc_estadual) {
		this.nr_insc_estadual = nr_insc_estadual;
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

}
