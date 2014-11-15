package org.netpod.domain;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "PERSON")
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PERSON_ID", length = 32, unique = true, nullable = false)
	private Integer id;
	@Column(name = "FIRTS_NAME")
	private String firstName;
	@Column(name = "LAST_NAME")
	private String lastName;
	@Column(name = "AGE")
	private int age;

	@Column(name = "CREATED_ON", insertable=false, updatable = false,
	        columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP()")
	@Temporal(TemporalType.TIMESTAMP)
	@Type(type = "org.jadira.usertype.dateandtime.threeten.PersistentZonedDateTime")
	private ZonedDateTime created;

	@Column(name = "UPDATED_ON")
	@Temporal(TemporalType.TIMESTAMP)
	@Type(type = "org.jadira.usertype.dateandtime.threeten.PersistentZonedDateTime")
	public ZonedDateTime updated;
	
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public int getAge() {
		return age;
	}

	public ZonedDateTime getCreated() {
		return created;
	}

	public ZonedDateTime getUpdated() {
		return updated;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setCreated(ZonedDateTime created) {
		this.created = created;
	}
	public void setUpdated(ZonedDateTime updated) {
		this.updated = updated;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName="
				+ lastName + ", age=" + age + ", created=" + created
				+ ", updated=" + updated + "]";
	}

	public static class Builder {
		private Person person;
		
		private Builder() {
			super();
			this.person = new Person();
		}

		public Builder withFirstName(String firstName) {
			this.person.firstName = firstName;
			return this;
		}
		public Builder withLastName(String lastName) {
			this.person.lastName = lastName;
			return this;
		}
		public Builder withAge(int age) {
			this.person.age = age;
			return this;
		}
		public Builder withCreated(ZonedDateTime created) {
			this.person.created = created;
			return this;
		}

		public Builder withUpdated(ZonedDateTime updated) {
			this.person.updated = updated;
			return this;
		}

		public Builder withId(Integer id) {
			this.person.id = id;
			return this;
		}

		public static Builder builder() {
			return new Builder();
		}
		
		public Person build() {
			return person;
		}
	}
}
