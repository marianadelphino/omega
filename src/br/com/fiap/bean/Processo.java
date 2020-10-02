package br.com.fiap.bean;

public class Processo {

	int nr_processo;
	Forum forum;
	Cliente cliente;
	TipoCausa tipoCausa;
	Advogado advogado;
	String ds_processo;
	String dt_abertura;
	String dt_fechamento;
    String dt_dia_vencimento;
	int nr_resultado;
	int nr_situacao;
	String ds_observacao;

	public Processo() {
		super();
	}

	public Processo(int nr_processo, Forum forum, Cliente cliente, TipoCausa tipoCausa, Advogado advogado, String ds_processo,
			String dt_abertura, String dt_fechamento, String dt_dia_vencimento, int nr_resultado, int nr_situacao,
			String ds_observacao) {
		super();

		this.nr_processo = nr_processo;
		this.forum = forum;
		this.cliente = cliente;
		this.tipoCausa = tipoCausa;
		this.advogado = advogado;
		this.ds_processo = ds_processo;
		this.dt_abertura = dt_abertura;
		this.dt_fechamento = dt_fechamento;
		this.dt_dia_vencimento = dt_dia_vencimento;
		this.nr_resultado = nr_resultado;
		this.nr_situacao = nr_situacao;
		this.ds_observacao = ds_observacao;

	}

	public int getNr_processo() {
		return nr_processo;
	}

	public void setNr_processo(int nr_processo) {
		this.nr_processo = nr_processo;
	}

	public Forum getForum() {
		return forum;
	}

	public void setForum(Forum forum) {
		this.forum = forum;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public TipoCausa getTipoCausa() {
		return tipoCausa;
	}

	public void setCd_causa(TipoCausa tipoCausa) {
		this.tipoCausa = tipoCausa;
	}

	public Advogado getAdvogado() {
		return advogado;
	}

	public void setAdvogado(Advogado advogado) {
		this.advogado = advogado;
	}

	public String getDs_processo() {
		return ds_processo;
	}

	public void setDs_processo(String ds_processo) {
		this.ds_processo = ds_processo;
	}

	public String getDt_abertura() {
		return dt_abertura;
	}

	public void setDt_abertura(String dt_abertura) {
		this.dt_abertura = dt_abertura;
	}

	public String getDt_fechamento() {
		return dt_fechamento;
	}

	public void setDt_fechamento(String dt_fechamento) {
		this.dt_fechamento = dt_fechamento;
	}

	public String getDt_dia_vencimento() {
		return dt_dia_vencimento;
	}

	public void setDt_dia_vencimento(String dt_dia_vencimento) {
		this.dt_dia_vencimento = dt_dia_vencimento;
	}

	public int getNr_resultado() {
		return nr_resultado;
	}

	public void setNr_resultado(int nr_resultado) {
		this.nr_resultado = nr_resultado;
	}

	public int getNr_situacao() {
		return nr_situacao;
	}

	public void setNr_situacao(int nr_situacao) {
		this.nr_situacao = nr_situacao;
	}

	public String getDs_observacao() {
		return ds_observacao;
	}

	public void setDs_observacao(String ds_observacao) {
		this.ds_observacao = ds_observacao;
	}

	public String getTudo() {
		return "\n Número do processo: " +nr_processo+ "\n Descrição: " +ds_processo+ "\n Razão Social: " +getCliente().ds_razao_social+"\n";
	}
	
	
}
