package br.puc.sisdoe.model;

import java.io.Serializable;

public class ResultadoExameDoencaChagas implements Serializable {

	private static final long serialVersionUID = -4344741659648625069L;
	
	
	/**
	 * hemaglutinação indireta (HAI);
	 */
	private Double hAI;
	
	/**
	 * imunofluorescência indireta (IFI); 
	 */
	private Double iFI;

	/**
	 * teste imunoenzimático (ELISA, por Enzyme Linked Immuno Sorbent Assay) 
	 */
	private Double eLISA;
	
	/**
	 * aglutinação direta com 2 mercapto-etanol (AD2ME)
	 */
	private Double aD2ME; 
	
	public ResultadoExameDoencaChagas() {
		// TODO Auto-generated constructor stub
	}

	public ResultadoExameDoencaChagas(Double hAI, Double iFI, Double eLISA, Double aD2ME) {
		super();
		this.hAI = hAI;
		this.iFI = iFI;
		this.eLISA = eLISA;
		this.aD2ME = aD2ME;
	}
	
	public Double gethAI() {
		return hAI;
	}

	public void sethAI(Double hAI) {
		this.hAI = hAI;
	}

	public Double getiFI() {
		return iFI;
	}

	public void setiFI(Double iFI) {
		this.iFI = iFI;
	}

	public Double geteLISA() {
		return eLISA;
	}

	public void seteLISA(Double eLISA) {
		this.eLISA = eLISA;
	}

	public Double getaD2ME() {
		return aD2ME;
	}

	public void setaD2ME(Double aD2ME) {
		this.aD2ME = aD2ME;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aD2ME == null) ? 0 : aD2ME.hashCode());
		result = prime * result + ((eLISA == null) ? 0 : eLISA.hashCode());
		result = prime * result + ((hAI == null) ? 0 : hAI.hashCode());
		result = prime * result + ((iFI == null) ? 0 : iFI.hashCode());
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
		ResultadoExameDoencaChagas other = (ResultadoExameDoencaChagas) obj;
		if (aD2ME == null) {
			if (other.aD2ME != null)
				return false;
		} else if (!aD2ME.equals(other.aD2ME))
			return false;
		if (eLISA == null) {
			if (other.eLISA != null)
				return false;
		} else if (!eLISA.equals(other.eLISA))
			return false;
		if (hAI == null) {
			if (other.hAI != null)
				return false;
		} else if (!hAI.equals(other.hAI))
			return false;
		if (iFI == null) {
			if (other.iFI != null)
				return false;
		} else if (!iFI.equals(other.iFI))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ResultadoExameDoencaChagas [hAI=" + hAI + ", iFI=" + iFI + ", eLISA=" + eLISA + ", aD2ME=" + aD2ME
				+ "]";
	}
	
}
