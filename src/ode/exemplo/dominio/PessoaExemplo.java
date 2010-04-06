package ode.exemplo.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;

import nucleo.comuns.persistencia.NucleoObjetoPersistenteImpl;


@Entity
public class PessoaExemplo extends NucleoObjetoPersistenteImpl<Long, Long> {

	private static final long serialVersionUID = 7215443991537131684L;

	private String nome;

	private String sobrenome;

	private String email;

	private long idade;

	private String telefone;

	@Column(nullable = false, length = 60)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(nullable = false, length = 60)
	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	@Column(length = 100)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getIdade() {
		return idade;
	}

	public void setIdade(long idade) {
		this.idade = idade;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}
