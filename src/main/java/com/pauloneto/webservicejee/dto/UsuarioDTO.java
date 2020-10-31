package com.pauloneto.webservicejee.dto;

import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotEmpty;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class UsuarioDTO implements DTO<UsuarioDTO>{

	private static final long serialVersionUID = 1L;

	private Long id;
	
	@NotEmpty(message = "login: é obrigatório")
	private String login;
	
	@NotEmpty(message = "senha: é obrigatório")
	private String senha;
	
	@NotEmpty(message = "email: é obrigatório")
	private String email;
	
	private Set<PerfilDTO> perfis;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<PerfilDTO> getPerfis() {
		return perfis;
	}

	public void setPerfis(Set<PerfilDTO> perfis) {
		this.perfis = perfis;
	}
}
