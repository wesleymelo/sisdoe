package br.puc.sisdoe.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author wesley
 */
public class AgendamentoDTO implements Serializable {
	private static final long serialVersionUID = 7148877319947989014L;

    private Long id;
    
    private Long idDoador;
    
    private Long idLocalDoacao;

    private Date dataHora;
	
    private Date data;
	
    private Date hora;
    
	public AgendamentoDTO() {}

	public AgendamentoDTO(Long id, Long idDoador, Long idLocalDoacao, Date dataHora, Date data, Date hora) {
		super();
		this.id = id;
		this.idDoador = idDoador;
		this.idLocalDoacao = idLocalDoacao;
		this.dataHora = dataHora;
		this.data = data;
		this.hora = hora;
	}


	/*
    public Date getDataHora(){
    	Calendar calendarData = Calendar.getInstance();
    	calendarData.setTime(this.data);
    	Calendar calendarHora = Calendar.getInstance();
    	calendarHora.setTime(this.hora);
    	Calendar calendaDataHora = Calendar.getInstance();
    	calendaDataHora.set(calendarData.get(Calendar.YEAR), calendarData.get(Calendar.MONTH), calendarData.get(Calendar.DAY_OF_MONTH), calendarHora.get(Calendar.HOUR), calendarHora.get(Calendar.MINUTE));
    	return calendaDataHora.getTime();
    }
    */

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdDoador() {
		return idDoador;
	}

	public void setIdDoador(Long idDoador) {
		this.idDoador = idDoador;
	}

	public Long getIdLocalDoacao() {
		return idLocalDoacao;
	}

	public void setIdLocalDoacao(Long idLocalDoacao) {
		this.idLocalDoacao = idLocalDoacao;
	}


	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((dataHora == null) ? 0 : dataHora.hashCode());
		result = prime * result + ((hora == null) ? 0 : hora.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idDoador == null) ? 0 : idDoador.hashCode());
		result = prime * result + ((idLocalDoacao == null) ? 0 : idLocalDoacao.hashCode());
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
		AgendamentoDTO other = (AgendamentoDTO) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (dataHora == null) {
			if (other.dataHora != null)
				return false;
		} else if (!dataHora.equals(other.dataHora))
			return false;
		if (hora == null) {
			if (other.hora != null)
				return false;
		} else if (!hora.equals(other.hora))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idDoador == null) {
			if (other.idDoador != null)
				return false;
		} else if (!idDoador.equals(other.idDoador))
			return false;
		if (idLocalDoacao == null) {
			if (other.idLocalDoacao != null)
				return false;
		} else if (!idLocalDoacao.equals(other.idLocalDoacao))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Agendamento [id=" + id + ", idDoador=" + idDoador + ", idLocalDoacao=" + idLocalDoacao + ", dataHora="
				+ dataHora + ", data=" + data + ", hora=" + hora + "]";
	}
	
}
