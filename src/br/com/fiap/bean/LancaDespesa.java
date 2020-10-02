package br.com.fiap.bean;

public class LancaDespesa {

	int cd_lancamento;
	TipoDespesa tipoDespesa;
	Processo processo;
	String dt_despesa;
	double vl_despesa;
	String ds_observacao;

	public LancaDespesa() {
		super();
	}

	public LancaDespesa(int cd_lancamento, TipoDespesa tipoDespesa, Processo processo, String dt_despesa, double vl_despesa,
			String ds_observacao) {
		super();
		this.cd_lancamento = cd_lancamento;
		this.tipoDespesa = tipoDespesa;
		this.processo = processo;
		this.dt_despesa = dt_despesa;
		this.vl_despesa = vl_despesa;
		this.ds_observacao = ds_observacao;
	}

	public int getCd_lancamento() {
		return cd_lancamento;
	}

	public void setCd_lancamento(int cd_lancamento) {
		this.cd_lancamento = cd_lancamento;
	}

	public TipoDespesa getTipoDespesa() {
		return tipoDespesa;
	}

	public void setTipoDespesa(TipoDespesa tipoDespesa) {
		this.tipoDespesa = tipoDespesa;
	}

	public Processo getProcesso() {
		return processo;
	}

	public void setProcesso(Processo processo) {
		this.processo = processo;
	}

	public String getDt_despesa() {
		return dt_despesa;
	}

	public void setDt_despesa(String dt_despesa) {
		this.dt_despesa = dt_despesa;
	}

	public double getVl_despesa() {
		return vl_despesa;
	}

	public void setVl_despesa(double vl_despesa) {
		this.vl_despesa = vl_despesa;
	}

	public String getDs_observacao() {
		return ds_observacao;
	}

	public void setDs_observacao(String ds_observacao) {
		this.ds_observacao = ds_observacao;
	}

	
	
	public String getTudo() {
			return "\n Código de Lançamento: " + cd_lancamento + "\n Número do Processo: " + getProcesso().getNr_processo() + "\n Descrição do Processo: " + getProcesso().getDs_processo()+ "\n Tipo de Despesa: " + getTipoDespesa().getDs_tipo_despesa() + "\n Valor da Despesa: " + vl_despesa+ "\n Data de Lançamento: " + dt_despesa + "\n";
		
	
	}
	
	
}
