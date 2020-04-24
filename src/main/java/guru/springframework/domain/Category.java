package guru.springframework.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToMany;

@Entity
public class Category {
	
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	private String description;
	
	@ManyToMany(mappedBy="category")
	private List<Receipe> receipe;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Receipe> getReceipe() {
		return receipe;
	}

	public void setReceipe(List<Receipe> receipe) {
		this.receipe = receipe;
	}
	
	

}
