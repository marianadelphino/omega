package br.com.fiap.bean;

public class TipoTarefa {

	int cd_tipo_tarefa;
	String ds_tipo_tarefa;

	public TipoTarefa() {
		super();
	}

	public TipoTarefa(int cd_tipo_tarefa, String ds_tipo_tarefa) {
		super();
		this.cd_tipo_tarefa = cd_tipo_tarefa;
		this.ds_tipo_tarefa = ds_tipo_tarefa;
	}

	public int getCd_tipo_tarefa() {
		return cd_tipo_tarefa;
	}

	public void setCd_tipo_tarefa(int cd_tipo_tarefa) {
		this.cd_tipo_tarefa = cd_tipo_tarefa;
	}

	public String getDs_tipo_tarefa() {
		return ds_tipo_tarefa;
	}

	public void setDs_tipo_tarefa(String ds_tipo_tarefa) {
		this.ds_tipo_tarefa = ds_tipo_tarefa;
	}
	
	public String getTudo() {
		return "\n Código Tarefa: " +cd_tipo_tarefa+ "\n Descrição tipo de tarefa: "+ds_tipo_tarefa;
	}
	
	

}
