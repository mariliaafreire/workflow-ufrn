package org.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.domain.utils.BasicPasswordEncryptor;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

@Name("user")
@Scope(ScopeType.SESSION)
@Entity
public class User {

	@Id
	@GeneratedValue
	private Long id;

	private String email;
	private String encryptedPassword;
	private String name;

	public User() {
	}
	public User(String email, String encryptedPassword, String name) {
		this.setEmail(email);
		this.setEncryptedPassword(encryptedPassword);
		this.setName(name);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getEncryptedPassword() {
		return encryptedPassword;
	}
	public void setPassword(String password) {
		this.encryptedPassword = new BasicPasswordEncryptor().encryptPassword(password);
	}
	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	 
}
