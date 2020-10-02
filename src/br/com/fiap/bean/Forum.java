package br.com.fiap.bean;

public class Forum extends Pessoa {
	int cd_forum;
	String ds_forum;

	public Forum() {
		super();

	}

	public Forum(int cd_forum, String ds_forum) {
		super();
		this.cd_forum = cd_forum;
		this.ds_forum = ds_forum;
	}

	public int getCd_forum() {
		return cd_forum;
	}

	public void setCd_forum(int cd_forum) {
		this.cd_forum = cd_forum;
	}

	public String getDs_forum() {
		return ds_forum;
	}

	public void setDs_forum(String ds_forum) {
		this.ds_forum = ds_forum;
	}
	
	public String getTudo() {
		return "Nome: "+nm_pessoa+"\nDescricao: "+ds_forum;
	}
	

}
