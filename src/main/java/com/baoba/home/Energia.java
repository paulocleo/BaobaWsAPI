package com.baoba.home;

public class Energia {
	
	private String medidaKwh;
	private String dataMedida;
	private boolean flagConta;
	private Long ordem;
	
	
	
	public Energia(String medidaKwh, String dataMedida, boolean flagConta, Long ordem) {
		super();
		this.medidaKwh = medidaKwh;
		this.dataMedida = dataMedida;
		this.flagConta = flagConta;
		this.ordem = ordem;
	}
	
	public String getMedidaKwh() {
		return medidaKwh;
	}
	public void setMedidaKwh(String medidaKwh) {
		this.medidaKwh = medidaKwh;
	}
	public String getDataMedida() {
		return dataMedida;
	}
	public void setDataMedida(String dataMedida) {
		this.dataMedida = dataMedida;
	}
	public boolean getFlagConta() {
		return flagConta;
	}
	public void setFlagConta(boolean flagConta) {
		this.flagConta = flagConta;
	}
	public Long getOrdem() {
		return ordem;
	}
	public void setOrdem(Long ordem) {
		this.ordem = ordem;
	}
	
	
	
}
