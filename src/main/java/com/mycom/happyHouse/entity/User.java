package com.mycom.happyHouse.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.DynamicUpdate;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@DynamicUpdate
@Table(
	name="user",
	uniqueConstraints = {
		@UniqueConstraint(name="UK_USER_ID", columnNames="userId")
	}
)
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int userNo;
	
	@Column(name = "userId", columnDefinition = "varchar(45)")
	@NotNull
	private String userId;
	
	@Column(name = "password", columnDefinition = "varchar(45)")
	@NotNull
	private String password;
	
	@Column(name = "name", columnDefinition = "varchar(45)")
	@NotNull
	private String name;
	
	@Column(name = "authority", columnDefinition = "INT default 0")
	private int authority;
}
