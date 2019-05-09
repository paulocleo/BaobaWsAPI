package com.baoba.home;

public class Feira {
	
	private String codigoBarras;
	private String nomeProduto;
	private String preco;
	private int quantidade;
	private String dataVencimento;
	private Long fastTimeData;
	
	public Feira(String codigoBarras, String nomeProduto, String preco, int quantidade, String dataVencimento, Long fastTimeData) {
		super();
		this.codigoBarras = codigoBarras;
		this.nomeProduto = nomeProduto;
		this.preco = preco;
		this.quantidade = quantidade;
		this.dataVencimento = dataVencimento;
		this.fastTimeData = fastTimeData;
	}
		
	public String getCodigoBarras() {
		return codigoBarras;
	}
	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public String getPreco() {
		return preco;
	}
	public void setPreco(String preco) {
		this.preco = preco;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public String getDataVencimento() {
		return dataVencimento;
	}
	public void setDataVencimento(String dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Long getFastTimeData() {
		return fastTimeData;
	}

	public void setFastTimeData(Long fastTimeData) {
		this.fastTimeData = fastTimeData;
	}
	
	

}
