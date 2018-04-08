package br.com.project.model.classes;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.envers.Audited;

@Audited
@Entity
public class Entidade implements Serializable {

	private static final long serialVersionUID = 1L;

	// Campo de primaryKey no banco
	@Id
	private Long ent_cod;

	private String ent_login = null;
	private String ent_senha;

	public String getEnt_login() {
		return ent_login;
	}

	public void setEnt_login(String ent_login) {
		this.ent_login = ent_login;
	}

	public String getEnt_senha() {
		return ent_senha;
	}

	public void setEnt_senha(String ent_senha) {
		this.ent_senha = ent_senha;
	}

	public Long getEnt_cod() {
		return ent_cod;
	}

	public void setEnt_cod(Long ent_cod) {
		this.ent_cod = ent_cod;
	}
	
	

}
