package br.puc.sisdoe.model;

import java.io.Serializable;

public class ResultadoExame implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4885445089650198330L;
	
	private Long id;
	private Coleta coleta;
	private Doador doador;
	private ResultadoExameAIDS resultadoExameAIDS;
	private ResultadoExameDoencaChagas resultadoExameDoencaChagas;
	private ResultadoExameHepatiteB resultadoExameHepatiteB;
	private ResultadoExameHepatiteC resultadoExameHepatiteC;
	private ResultadoExameSifilis resultadoExameSifilis;
	
	public ResultadoExame() {
		// TODO Auto-generated constructor stub
	}

	public ResultadoExame(Coleta coleta, Doador doador, ResultadoExameAIDS resultadoExameAIDS,
			ResultadoExameDoencaChagas resultadoExameDoencaChagas, ResultadoExameHepatiteB resultadoExameHepatiteB,
			ResultadoExameHepatiteC resultadoExameHepatiteC, ResultadoExameSifilis resultadoExameSifilis) {
		super();
		this.coleta = coleta;
		this.doador = doador;
		this.resultadoExameAIDS = resultadoExameAIDS;
		this.resultadoExameDoencaChagas = resultadoExameDoencaChagas;
		this.resultadoExameHepatiteB = resultadoExameHepatiteB;
		this.resultadoExameHepatiteC = resultadoExameHepatiteC;
		this.resultadoExameSifilis = resultadoExameSifilis;
	}
	
	public ResultadoExame(Long id, Coleta coleta, Doador doador, ResultadoExameAIDS resultadoExameAIDS,
			ResultadoExameDoencaChagas resultadoExameDoencaChagas, ResultadoExameHepatiteB resultadoExameHepatiteB,
			ResultadoExameHepatiteC resultadoExameHepatiteC, ResultadoExameSifilis resultadoExameSifilis) {
		super();
		this.id = id;
		this.coleta = coleta;
		this.doador = doador;
		this.resultadoExameAIDS = resultadoExameAIDS;
		this.resultadoExameDoencaChagas = resultadoExameDoencaChagas;
		this.resultadoExameHepatiteB = resultadoExameHepatiteB;
		this.resultadoExameHepatiteC = resultadoExameHepatiteC;
		this.resultadoExameSifilis = resultadoExameSifilis;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Coleta getColeta() {
		return coleta;
	}

	public void setColeta(Coleta coleta) {
		this.coleta = coleta;
	}

	public Doador getDoador() {
		return doador;
	}

	public void setDoador(Doador doador) {
		this.doador = doador;
	}

	public ResultadoExameAIDS getResultadoExameAIDS() {
		return resultadoExameAIDS;
	}

	public void setResultadoExameAIDS(ResultadoExameAIDS resultadoExameAIDS) {
		this.resultadoExameAIDS = resultadoExameAIDS;
	}

	public ResultadoExameDoencaChagas getResultadoExameDoencaChagas() {
		return resultadoExameDoencaChagas;
	}

	public void setResultadoExameDoencaChagas(ResultadoExameDoencaChagas resultadoExameDoencaChagas) {
		this.resultadoExameDoencaChagas = resultadoExameDoencaChagas;
	}

	public ResultadoExameHepatiteB getResultadoExameHepatiteB() {
		return resultadoExameHepatiteB;
	}

	public void setResultadoExameHepatiteB(ResultadoExameHepatiteB resultadoExameHepatiteB) {
		this.resultadoExameHepatiteB = resultadoExameHepatiteB;
	}

	public ResultadoExameHepatiteC getResultadoExameHepatiteC() {
		return resultadoExameHepatiteC;
	}

	public void setResultadoExameHepatiteC(ResultadoExameHepatiteC resultadoExameHepatiteC) {
		this.resultadoExameHepatiteC = resultadoExameHepatiteC;
	}

	public ResultadoExameSifilis getResultadoExameSifilis() {
		return resultadoExameSifilis;
	}

	public void setResultadoExameSifilis(ResultadoExameSifilis resultadoExameSifilis) {
		this.resultadoExameSifilis = resultadoExameSifilis;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coleta == null) ? 0 : coleta.hashCode());
		result = prime * result + ((doador == null) ? 0 : doador.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((resultadoExameAIDS == null) ? 0 : resultadoExameAIDS.hashCode());
		result = prime * result + ((resultadoExameDoencaChagas == null) ? 0 : resultadoExameDoencaChagas.hashCode());
		result = prime * result + ((resultadoExameHepatiteB == null) ? 0 : resultadoExameHepatiteB.hashCode());
		result = prime * result + ((resultadoExameHepatiteC == null) ? 0 : resultadoExameHepatiteC.hashCode());
		result = prime * result + ((resultadoExameSifilis == null) ? 0 : resultadoExameSifilis.hashCode());
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
		ResultadoExame other = (ResultadoExame) obj;
		if (coleta == null) {
			if (other.coleta != null)
				return false;
		} else if (!coleta.equals(other.coleta))
			return false;
		if (doador == null) {
			if (other.doador != null)
				return false;
		} else if (!doador.equals(other.doador))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (resultadoExameAIDS == null) {
			if (other.resultadoExameAIDS != null)
				return false;
		} else if (!resultadoExameAIDS.equals(other.resultadoExameAIDS))
			return false;
		if (resultadoExameDoencaChagas == null) {
			if (other.resultadoExameDoencaChagas != null)
				return false;
		} else if (!resultadoExameDoencaChagas.equals(other.resultadoExameDoencaChagas))
			return false;
		if (resultadoExameHepatiteB == null) {
			if (other.resultadoExameHepatiteB != null)
				return false;
		} else if (!resultadoExameHepatiteB.equals(other.resultadoExameHepatiteB))
			return false;
		if (resultadoExameHepatiteC == null) {
			if (other.resultadoExameHepatiteC != null)
				return false;
		} else if (!resultadoExameHepatiteC.equals(other.resultadoExameHepatiteC))
			return false;
		if (resultadoExameSifilis == null) {
			if (other.resultadoExameSifilis != null)
				return false;
		} else if (!resultadoExameSifilis.equals(other.resultadoExameSifilis))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ResultadoExame [id=" + id + ", coleta=" + coleta + ", doador=" + doador + ", resultadoExameAIDS="
				+ resultadoExameAIDS + ", resultadoExameDoencaChagas=" + resultadoExameDoencaChagas
				+ ", resultadoExameHepatiteB=" + resultadoExameHepatiteB + ", resultadoExameHepatiteC="
				+ resultadoExameHepatiteC + ", resultadoExameSifilis=" + resultadoExameSifilis + "]";
	}
	
}
