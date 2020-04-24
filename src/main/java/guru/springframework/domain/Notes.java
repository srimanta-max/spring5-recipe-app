package guru.springframework.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

@Entity
public class Notes {
	
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@Lob
	private String receipeNotes;
	
	@OneToOne
	private Receipe receipe;
	
	public String getReceipeNotes() {
		return receipeNotes;
	}
	public void setReceipeNotes(String receipeNotes) {
		this.receipeNotes = receipeNotes;
	}
	public Receipe getReceipe() {
		return receipe;
	}
	public void setReceipe(Receipe receipe) {
		this.receipe = receipe;
	}


	
	

}
