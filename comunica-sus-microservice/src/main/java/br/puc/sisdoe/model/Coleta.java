package br.puc.sisdoe.model;

import java.io.Serializable;
import java.util.Date;
import br.puc.sisdoe.util.DateUtil;

public class Coleta implements Serializable {
	private static final long serialVersionUID = -6419214993102830047L;
	
	private Boolean fatorRH;
	private String grupoSanguineo;
	private Date dataColeta;
	
	public Coleta() {
		// TODO Auto-generated constructor stub
	}
	
	public Coleta(Boolean fatorRH, String grupoSanguineo, Date dataColeta) {
	    super();
	    this.fatorRH = fatorRH;
	    this.grupoSanguineo = grupoSanguineo;
	    this.dataColeta = dataColeta;
	}

	public Boolean getFatorRH() {
		return fatorRH;
	}

	public void setFatorRH(Boolean fatorRH) {
		this.fatorRH = fatorRH;
	}

	public String getGrupoSanguineo() {
		return grupoSanguineo;
	}

	public void setGrupoSanguineo(String grupoSanguineo) {
		this.grupoSanguineo = grupoSanguineo;
	}
	
	public Date getDataColeta() {
	    return dataColeta;
	}
	
	public String getDataColetaStr() {
	    return DateUtil.formataDataStrPadraoBR(getDataColeta());
	}

	public void setDataColeta(Date dataColeta) {
	    this.dataColeta = dataColeta;
	}

	@Override
	public int hashCode() {
	    final int prime = 31;
	    int result = 1;
	    result = prime * result + ((dataColeta == null) ? 0 : dataColeta.hashCode());
	    result = prime * result + ((fatorRH == null) ? 0 : fatorRH.hashCode());
	    result = prime * result + ((grupoSanguineo == null) ? 0 : grupoSanguineo.hashCode());
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
	    Coleta other = (Coleta) obj;
	    if (dataColeta == null) {
		if (other.dataColeta != null)
		    return false;
	    } else if (!dataColeta.equals(other.dataColeta))
		return false;
	    if (fatorRH == null) {
		if (other.fatorRH != null)
		    return false;
	    } else if (!fatorRH.equals(other.fatorRH))
		return false;
	    if (grupoSanguineo == null) {
		if (other.grupoSanguineo != null)
		    return false;
	    } else if (!grupoSanguineo.equals(other.grupoSanguineo))
		return false;
	    return true;
	}

	@Override
	public String toString() {
	    return "Coleta [fatorRH=" + fatorRH + ", grupoSanguineo=" + grupoSanguineo + ", dataColeta=" + dataColeta + "]";
	}
	
}
