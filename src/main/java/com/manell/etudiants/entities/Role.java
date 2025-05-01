package com.manell.etudiants.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Role {
@Id
@GeneratedValue (strategy=GenerationType.IDENTITY)
private Long role_id;
private String role;
public Long getRole_id() {
	return role_id;
}
public void setRole_id(Long role_id) {
	this.role_id = role_id;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public Role(Long role_id, String role) {
	super();
	this.role_id = role_id;
	this.role = role;
}
public Role() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "Role [role_id=" + role_id + ", role=" + role + "]";
}

}

