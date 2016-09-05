package br.puc.sisdoe.model;

import java.io.Serializable;

public class ResultadoExameHepatiteC implements Serializable {

	private static final long serialVersionUID = -2850872602981053388L;
	
	private Boolean antiHCV;
	
	public ResultadoExameHepatiteC() {
		// TODO Auto-generated constructor stub
	}

	public ResultadoExameHepatiteC(Boolean antiHCV) {
		super();
		this.antiHCV = antiHCV;
	}

	public Boolean getAntiHCV() {
		return antiHCV;
	}

	public void setAntiHCV(Boolean antiHCV) {
		this.antiHCV = antiHCV;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((antiHCV == null) ? 0 : antiHCV.hashCode());
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
		ResultadoExameHepatiteC other = (ResultadoExameHepatiteC) obj;
		if (antiHCV == null) {
			if (other.antiHCV != null)
				return false;
		} else if (!antiHCV.equals(other.antiHCV))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ResultadoExameHepatiteC [antiHCV=" + antiHCV + "]";
	}
	
}
