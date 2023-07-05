package com.ticketya.ticketsweb.models.entities.user;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ticketya.ticketsweb.models.entities.event.fks.Administration;
import com.ticketya.ticketsweb.models.entities.ticket.Ticket;
import com.ticketya.ticketsweb.models.entities.ticket.fk.QR;
import com.ticketya.ticketsweb.models.entities.user.fks.Assignment;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@Entity
@ToString(exclude = {"movements","users","tickets_user","qrs","administration","tokens"})
@Table(name = "usuario")
public class User implements UserDetails{	
	@Id
	@Column(name = "id_usuario")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id_user;
	
	@Column(name = "autenticacion")
	private Boolean authentication;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "correo")
	private String mail;

	@Column(name = "estado_activo")
	private Boolean active;
	
	//logic to connect fk in movements
	@OneToMany(mappedBy = "user_mov",fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Movements> movements;
	
	@OneToMany(mappedBy = "assiguser",fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Assignment> users;
	
	@OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Ticket> tickets_user;
	
	@OneToMany(mappedBy = "userqr",fetch = FetchType.LAZY)
	@JsonIgnore
	private List<QR> qrs;
	
	@OneToMany(mappedBy = "useradmi",fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Administration> administration;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Token> tokens;
	
	
	public User(Boolean authentication, String username, String password, String mail, Boolean active) {
		super();
		this.authentication = authentication;
		this.username = username;
		this.password = password;
		this.mail = mail;
		this.active = active;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}
	
	//getUsername is already overridden

	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}

	@Override
	public boolean isEnabled() {
		return this.active;
	}
	
	
}
