package fr.formation.inti.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import fr.formation.inti.entities.Employee;


@Entity
@Table(name = "User")
public class User {

	private String pseudo;
	private String mdp;
	private Employee emp;
	private String session_id;
	

	
	@OneToOne
	public Employee getEmp() {
		return emp;
	}
	
	@Id
	@Column(name = "Session_ID")
	public String getSession_id() {
		return session_id;
	}
	public void setSession_id(String session_id) {
		this.session_id = session_id;
	}
	public void setEmp(Employee emp) {
		this.emp = emp;
	}
	
	@Column(name = "Pseudo", length = 20, nullable = false)
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	@Column(name = "MDP", length = 20, nullable = false)
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	
	
}
