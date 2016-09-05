package br.puc.sisdoe.model.enumerate;

public enum Sexo {

	FEMININO('F', "Feminino"),
	MASCULINO('M', "Masculino");
	
	private char sigla;
	private String descricao;
	
	private Sexo(char sigla, String descricao) {
		this.sigla = sigla;
		this.descricao = descricao;
	}

	public char getSigla() {
		return sigla;
	}

	public void setSigla(char sigla) {
		this.sigla = sigla;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public static Sexo getSexoPorSigla(char sigla){
		for (Sexo sexo : values()) {
			if(sexo.getSigla() == sigla){
				return sexo;
			}
		}
		return null;
	}
	
	public static Sexo getSexoPorDescricao(String descricao){
		for (Sexo sexo : values()) {
			if(sexo.getDescricao().equals(descricao)){
				return sexo;
			}
		}
		return null;
	}
	
	
}
