package br.com.fiap.bean;

public class TipoCausa {
	int cd_causa;
	String ds_causa;

	public TipoCausa() {
		super();
	}

	public TipoCausa(int cd_causa, String ds_causa) {
		super();
		this.cd_causa = cd_causa;
		this.ds_causa = ds_causa;

	}

	public int getCd_causa() {
		return cd_causa;
	}

	public void setCd_causa(int cd_causa) {
		this.cd_causa = cd_causa;
	}

	public String getDs_causa() {
		return ds_causa;
	}

	public void setDs_causa(String ds_causa) {
		this.ds_causa = ds_causa;
	}
}
