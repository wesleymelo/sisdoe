package br.puc.sisdoe.model;

import java.io.Serializable;

public class ResultadoExameAIDS implements Serializable {

	private static final long serialVersionUID = 6038005965797827792L;
	
	private Boolean antiHIV;
	
	public ResultadoExameAIDS() {
		// TODO Auto-generated constructor stub
	}

	public ResultadoExameAIDS(Boolean antiHIV) {
		super();
		this.antiHIV = antiHIV;
	}
	
	public Boolean getAntiHIV() {
		return antiHIV;
	}

	public void setAntiHIV(Boolean antiHIV) {
		this.antiHIV = antiHIV;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((antiHIV == null) ? 0 : antiHIV.hashCode());
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
		ResultadoExameAIDS other = (ResultadoExameAIDS) obj;
		if (antiHIV == null) {
			if (other.antiHIV != null)
				return false;
		} else if (!antiHIV.equals(other.antiHIV))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ResultadoExameAIDS [antiHIV=" + antiHIV + "]";
	}
	
}
