package br.com.fiap.bean;

public class TipoDespesa {

	int cd_tipo_despesa;
	String ds_tipo_despesa;

	public TipoDespesa() {
		super();
	}

	public TipoDespesa(int cd_tipo_despesa, String ds_tipo_despesa) {
		super();

		this.cd_tipo_despesa = cd_tipo_despesa;
		this.ds_tipo_despesa = ds_tipo_despesa;
	}

	public int getCd_tipo_despesa() {
		return cd_tipo_despesa;
	}

	public void setCd_tipo_despesa(int cd_tipo_despesa) {
		this.cd_tipo_despesa = cd_tipo_despesa;
	}

	public String getDs_tipo_despesa() {
		return ds_tipo_despesa;
	}

	public void setDs_tipo_despesa(String ds_tipo_despesa) {
		this.ds_tipo_despesa = ds_tipo_despesa;
	}
	
	
	
	public String getTudo() {
		return "\n Código Despesa: " +cd_tipo_despesa+ "\n Descrição tipo de despesa: "+ds_tipo_despesa;
	}
	

}
