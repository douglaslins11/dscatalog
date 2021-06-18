package br.com.lins.dscatalog.model;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.*;

@Entity
@Table(name="tb_category")
public class Category implements Serializable{
	
	private static final long serialVersionUID = -4385522369609315607L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name = "name")
	private String name;

	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant createdAt;

	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant updatedAt;

	public Category () {
		
	}
	
	public Category(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}

	public Instant getUpdatedAt() {
		return updatedAt;
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@PrePersist
	public void prePresist (){
		this.createdAt = Instant.now();
	}

	@PreUpdate
	public void preUpdate (){
		this.updatedAt = Instant.now();
	}
}
