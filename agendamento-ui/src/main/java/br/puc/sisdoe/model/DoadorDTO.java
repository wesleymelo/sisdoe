package br.puc.sisdoe.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author wesley
 */
public class DoadorDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	private String nome;

	private String cpf;

	private int rg;

	private String rgUf;

	private Date dataNascimento;

	private Character sexo;

	private String email;

	private boolean jaDoou;

	private String uf;

	private String cidade;

	private String telefone;

	private String celular;

	public DoadorDTO() {

	}

	public DoadorDTO(Long id) {
		this.id = id;
	}

	public DoadorDTO(Long id, String nome, String cpf, int rg, String rgUf, Date dataNascimento, Character sexo,
			String email, boolean jaDoou, String uf, String cidade) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.rgUf = rgUf;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.email = email;
		this.jaDoou = jaDoou;
		this.uf = uf;
		this.cidade = cidade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getRg() {
		return rg;
	}

	public void setRg(int rg) {
		this.rg = rg;
	}

	public String getRgUf() {
		return rgUf;
	}

	public void setRgUf(String rgUf) {
		this.rgUf = rgUf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Character getSexo() {
		return sexo;
	}

	public void setSexo(Character sexo) {
		this.sexo = sexo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isJadoou() {
		return jaDoou;
	}

	public void setJadoou(boolean jaDoou) {
		this.jaDoou = jaDoou;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((celular == null) ? 0 : celular.hashCode());
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((dataNascimento == null) ? 0 : dataNascimento.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((uf == null) ? 0 : uf.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (jaDoou ? 1231 : 1237);
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((rgUf == null) ? 0 : rgUf.hashCode());
		result = prime * result + rg;
		result = prime * result + ((sexo == null) ? 0 : sexo.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
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
		DoadorDTO other = (DoadorDTO) obj;
		if (celular == null) {
			if (other.celular != null)
				return false;
		} else if (!celular.equals(other.celular))
			return false;
		if (cidade == null) {
			if (other.cidade != null)
				return false;
		} else if (!cidade.equals(other.cidade))
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (dataNascimento == null) {
			if (other.dataNascimento != null)
				return false;
		} else if (!dataNascimento.equals(other.dataNascimento))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (uf == null) {
			if (other.uf != null)
				return false;
		} else if (!uf.equals(other.uf))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (jaDoou != other.jaDoou)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (rgUf == null) {
			if (other.rgUf != null)
				return false;
		} else if (!rgUf.equals(other.rgUf))
			return false;
		if (rg != other.rg)
			return false;
		if (sexo == null) {
			if (other.sexo != null)
				return false;
		} else if (!sexo.equals(other.sexo))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Doador [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", rg=" + rg + ", rfUf=" + rgUf
				+ ", dataNascimento=" + dataNascimento + ", sexo=" + sexo + ", email=" + email + ", jadoou=" + jaDoou
				+ ", uf=" + uf + ", cidade=" + cidade + ", telefone=" + telefone + ", celular=" + celular + "]";
	}

}
