package br.puc.sisdoe.model;

import java.io.Serializable;

import br.puc.sisdoe.model.LocalDoacaoDTO;

public class LocalizacaoDTO implements Serializable  {
	
	private static final long serialVersionUID = -6540964917603025332L;
	
	private LocalDoacaoDTO localDoacao;
	private Double distancia;
	
	public LocalizacaoDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public LocalizacaoDTO(LocalDoacaoDTO localDoacao, Double distancia) {
		super();
		this.localDoacao = localDoacao;
		this.distancia = distancia;
	}
	public LocalDoacaoDTO getLocalDoacao() {
		return localDoacao;
	}
	public void setLocalDoacao(LocalDoacaoDTO localDoacao) {
		this.localDoacao = localDoacao;
	}
	public Double getDistancia() {
		return distancia;
	}
	public void setDistancia(Double distancia) {
		this.distancia = distancia;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((distancia == null) ? 0 : distancia.hashCode());
		result = prime * result + ((localDoacao == null) ? 0 : localDoacao.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LocalizacaoDTO other = (LocalizacaoDTO) obj;
		if (distancia == null) {
			if (other.distancia != null)
				return false;
		} else if (!distancia.equals(other.distancia))
			return false;
		if (localDoacao == null) {
			if (other.localDoacao != null)
				return false;
		} else if (!localDoacao.equals(other.localDoacao))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Localizacao [localDoacao=" + localDoacao + ", distancia=" + distancia + "]";
	}
}
