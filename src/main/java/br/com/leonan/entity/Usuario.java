package br.com.leonan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(schema = "sa_rest", name = "tb_usuario")
public class Usuario {
	
	@Id
	@Column(name = "id_usuario")
	@SequenceGenerator(name = "sq_usuario", sequenceName = "sq_usuario", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_usuario")
	private Long id;
	
	@NotBlank(message = "{usuario.cpf.obrigatorio}")
	@Column(name = "cpf_usuario", length = 11, nullable = false)
	private String cpf;
	
	@NotBlank(message = "{usuario.nome.obrigatorio}")
	@Column(name = "nome_usuario", length = 150, nullable = false)
	private String nome;
	
	@Column(name = "email", length = 100)
	private String email;
	
	@Column(name = "num_telefone", length = 15)
	private String numTelefone;
	
	@Column(name = "situacao", nullable = false)
	private Boolean situacao;
	
	public Usuario() { }
	
	public Usuario(String cpf, String nome, String email, String numTelefone) {
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.numTelefone = numTelefone;
		this.situacao = Boolean.TRUE;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumTelefone() {
		return numTelefone;
	}

	public void setNumTelefone(String numTelefone) {
		this.numTelefone = numTelefone;
	}

	public Boolean getSituacao() {
		return situacao;
	}
	
	public void setSituacao(Boolean situacao) {
		this.situacao = situacao;
	}
	
	
	
	
	
	

}
