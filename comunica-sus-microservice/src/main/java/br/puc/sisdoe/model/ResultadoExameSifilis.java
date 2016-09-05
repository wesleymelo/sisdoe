package br.puc.sisdoe.model;

import java.io.Serializable;

public class ResultadoExameSifilis implements Serializable {

	private static final long serialVersionUID = -2065309098666104165L;
	
	private Boolean VDRL;
	
	public ResultadoExameSifilis() {
		// TODO Auto-generated constructor stub
	}

	public ResultadoExameSifilis(Boolean vDRL) {
		super();
		VDRL = vDRL;
	}

	public Boolean getVDRL() {
		return VDRL;
	}

	public void setVDRL(Boolean vDRL) {
		VDRL = vDRL;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((VDRL == null) ? 0 : VDRL.hashCode());
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
		ResultadoExameSifilis other = (ResultadoExameSifilis) obj;
		if (VDRL == null) {
			if (other.VDRL != null)
				return false;
		} else if (!VDRL.equals(other.VDRL))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ResultadoExameSifilis [VDRL=" + VDRL + "]";
	}
	
}
