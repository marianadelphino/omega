package br.com.fiap.bean;

public class LancaHonorario {
	int cd_lancamento;
	TipoTarefa tipoTarefa;
	Processo processo;
	String dt_honorario;
	double qt_hora;
	String ds_observacao;

	public LancaHonorario() {
		super();
	}

	public LancaHonorario(int cd_lancamento, TipoTarefa tipoTarefa, Processo processo, String dt_honorario, double qt_hora,
			String ds_observacao) {
		super();
		this.cd_lancamento = cd_lancamento;
		this.tipoTarefa = tipoTarefa;
		this.processo = processo;
		this.dt_honorario = dt_honorario;
		this.qt_hora = qt_hora;
		this.ds_observacao = ds_observacao;

	}

	public int getCd_lancamento() {
		return cd_lancamento;
	}

	public void setCd_lancamento(int cd_lancamento) {
		this.cd_lancamento = cd_lancamento;
	}

	public TipoTarefa getTipoTarefa() {
		return tipoTarefa;
	}

	public void setTipoTarefa (TipoTarefa tipoTarefa) {
		this.tipoTarefa = tipoTarefa;
	}

	public Processo getProcesso() {
		return processo;
	}

	public void setProcesso(Processo processo) {
		this.processo = processo;
	}

	public String getDt_honorario() {
		return dt_honorario;
	}

	public void setDt_honorario(String dt_honorario) {
		this.dt_honorario = dt_honorario;
	}

	public Double getQt_hora() {
		return qt_hora;
	}

	public void setQt_hora(Double qt_hora) {
		this.qt_hora = qt_hora;
	}

	public String getDs_observacao() {
		return ds_observacao;
	}

	public void setDs_observacao(String ds_observacao) {
		this.ds_observacao = ds_observacao;
	}
	
	
	
	public String getTudo() {
		return "\n Código de Lançamento: " + cd_lancamento + "\n Número do Processo: " + getProcesso().getNr_processo() + "\n Descrição do Processo: " + getProcesso().getDs_processo()+ "\n Tipo de Tarefa: " + getTipoTarefa().getDs_tipo_tarefa() + "\n Quantidade de Hora: " + qt_hora;
	

}
	
	

}
