package guru.springframework.bootstrap;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import guru.springframework.domain.Receipe;
import guru.springframework.domain.UnitOfMeasure;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.ReceipeRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;


@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {
	
	private final CategoryRepository categoryRepository;
	private final UnitOfMeasureRepository unitOfMeasureRepository;
	private final ReceipeRepository receipeRepository;
	
	public RecipeBootstrap(ReceipeRepository receipeRepository, CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
		this.receipeRepository = receipeRepository;
		this.categoryRepository = categoryRepository;
		this.unitOfMeasureRepository = unitOfMeasureRepository;
	}
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		receipeRepository.saveAll(getReceipes());		
	}
	
	private List<Receipe> getReceipes(){
		
		List<Receipe> receipes = new ArrayList<>(2);
		
		
		
		return receipes;
		
	}
	
	private void getCategories() {
		
	}
	
	private void getUnitOfMeasure() {
		
		Optional<UnitOfMeasure> TablespponUomOptional = unitOfMeasureRepository.findByDescription("Tablespoon");
		Optional<UnitOfMeasure> TeaspoonUomOptional = unitOfMeasureRepository.findByDescription("Teaspoon");
		Optional<UnitOfMeasure> CupUomOptional = unitOfMeasureRepository.findByDescription("cup");

		
	}

	
	
	


}
