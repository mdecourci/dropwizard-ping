package org.netpod.domain;

import java.time.ZonedDateTime;

public class PersonEntity {
	private Integer id;
	private String firstName;
	private String lastName;
	private int age;
	private ZonedDateTime created;
	public ZonedDateTime updated;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public ZonedDateTime getCreated() {
		return created;
	}
	public void setCreated(ZonedDateTime created) {
		this.created = created;
	}
	public ZonedDateTime getUpdated() {
		return updated;
	}
	public void setUpdated(ZonedDateTime updated) {
		this.updated = updated;
	}
}
