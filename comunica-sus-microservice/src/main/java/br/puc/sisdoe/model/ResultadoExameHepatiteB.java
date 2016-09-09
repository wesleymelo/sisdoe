package br.puc.sisdoe.model;

import java.io.Serializable;

public class ResultadoExameHepatiteB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1269959450787265179L;

	/**
	 * Antígeno de superfície do vírus B - HBsAg
	 */
	private Boolean hBsAg;
	
	/**
	 * Anticorpo IgM contra o antígeno core do vírus B - Anti-HBc IgM
	 */
	private Boolean antiHBcIgM;
	
	/**
	 * Anticorpos totais contra o antígeno core do vírus B - Anti-HBc total
	 */
	private Boolean antiHBcTotal; 

	/**
	 * Antígeno “e” do vírus B) - HBeAg
	 */
	private Boolean hBeAg;
	
	/**
	 * Anticorpo contra o antígeno “e” do vírus B - Anti-HBe
	 */
	private Boolean antiHBe;
	
	/**
	 * Anticorpo contra o antígeno de superfície do vírus B - Anti-HBs
	 */
	private Boolean antiHBs ;
	
	public ResultadoExameHepatiteB() {
		// TODO Auto-generated constructor stub
	}

	public ResultadoExameHepatiteB(Boolean hBsAg, Boolean antiHBcIgM, Boolean antiHBcTotal, Boolean hBeAg,
			Boolean antiHBe, Boolean antiHBs) {
		super();
		this.hBsAg = hBsAg;
		this.antiHBcIgM = antiHBcIgM;
		this.antiHBcTotal = antiHBcTotal;
		this.hBeAg = hBeAg;
		this.antiHBe = antiHBe;
		this.antiHBs = antiHBs;
	}

	public Boolean gethBsAg() {
		return hBsAg;
	}

	public void sethBsAg(Boolean hBsAg) {
		this.hBsAg = hBsAg;
	}

	public Boolean getAntiHBcIgM() {
		return antiHBcIgM;
	}

	public void setAntiHBcIgM(Boolean antiHBcIgM) {
		this.antiHBcIgM = antiHBcIgM;
	}

	public Boolean getAntiHBcTotal() {
		return antiHBcTotal;
	}

	public void setAntiHBcTotal(Boolean antiHBcTotal) {
		this.antiHBcTotal = antiHBcTotal;
	}

	public Boolean gethBeAg() {
		return hBeAg;
	}

	public void sethBeAg(Boolean hBeAg) {
		this.hBeAg = hBeAg;
	}

	public Boolean getAntiHBe() {
		return antiHBe;
	}

	public void setAntiHBe(Boolean antiHBe) {
		this.antiHBe = antiHBe;
	}

	public Boolean getAntiHBs() {
		return antiHBs;
	}

	public void setAntiHBs(Boolean antiHBs) {
		this.antiHBs = antiHBs;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((antiHBcIgM == null) ? 0 : antiHBcIgM.hashCode());
		result = prime * result + ((antiHBcTotal == null) ? 0 : antiHBcTotal.hashCode());
		result = prime * result + ((antiHBe == null) ? 0 : antiHBe.hashCode());
		result = prime * result + ((antiHBs == null) ? 0 : antiHBs.hashCode());
		result = prime * result + ((hBeAg == null) ? 0 : hBeAg.hashCode());
		result = prime * result + ((hBsAg == null) ? 0 : hBsAg.hashCode());
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
		ResultadoExameHepatiteB other = (ResultadoExameHepatiteB) obj;
		if (antiHBcIgM == null) {
			if (other.antiHBcIgM != null)
				return false;
		} else if (!antiHBcIgM.equals(other.antiHBcIgM))
			return false;
		if (antiHBcTotal == null) {
			if (other.antiHBcTotal != null)
				return false;
		} else if (!antiHBcTotal.equals(other.antiHBcTotal))
			return false;
		if (antiHBe == null) {
			if (other.antiHBe != null)
				return false;
		} else if (!antiHBe.equals(other.antiHBe))
			return false;
		if (antiHBs == null) {
			if (other.antiHBs != null)
				return false;
		} else if (!antiHBs.equals(other.antiHBs))
			return false;
		if (hBeAg == null) {
			if (other.hBeAg != null)
				return false;
		} else if (!hBeAg.equals(other.hBeAg))
			return false;
		if (hBsAg == null) {
			if (other.hBsAg != null)
				return false;
		} else if (!hBsAg.equals(other.hBsAg))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ResultadoExameHepatiteB [hBsAg=" + hBsAg + ", antiHBcIgM=" + antiHBcIgM + ", antiHBcTotal="
				+ antiHBcTotal + ", hBeAg=" + hBeAg + ", antiHBe=" + antiHBe + ", antiHBs=" + antiHBs + "]";
	}

}
