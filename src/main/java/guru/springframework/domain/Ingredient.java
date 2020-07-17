package guru.springframework.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity(name = "ingredient")
public class Ingredient {
	
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	private String description;
	private BigDecimal amount;
	
	@OneToOne(fetch = FetchType.EAGER)
	private  UnitOfMeasure unitOfMeasure; 
	
	@ManyToOne
	@JoinColumn
	private Receipe receipe;
	
	
	
	
	public Ingredient( String description, BigDecimal amount, UnitOfMeasure unitOfMeasure, Receipe receipe) {
		this.description = description;
		this.amount = amount;
		this.unitOfMeasure = unitOfMeasure;
		this.receipe = receipe;
	}
	
	public UnitOfMeasure getUnitOfMeasure() {
		return unitOfMeasure;
	}
	public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
	}
	public Receipe getReceipe() {
		return receipe;
	}
	public void setReceipe(Receipe receipe) {
		this.receipe = receipe;
	}
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
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	} 
	

}
