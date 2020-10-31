package com.pauloneto.webservicejee.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotEmpty;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class PerfilDTO implements DTO<PerfilDTO>{

	private static final long serialVersionUID = 1L;

	private Long id;
	
	@NotEmpty(message = "perfil é obrigatório")
	private String perfil;
	
	public PerfilDTO() {}
	
	public PerfilDTO(Long id, String perfil) {
		super();
		this.id = id;
		this.perfil = perfil;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	
	
	
}
