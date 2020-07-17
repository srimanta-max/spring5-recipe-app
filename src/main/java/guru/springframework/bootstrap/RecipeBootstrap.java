package guru.springframework.bootstrap;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import guru.springframework.domain.Category;
import guru.springframework.domain.Difficulty;
import guru.springframework.domain.Ingredient;
import guru.springframework.domain.Notes;
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
		
		
		//Get all categories
		
		Optional<Category> americanCategoryOptional = categoryRepository.findByDescription("American");
		
		if(!americanCategoryOptional.isPresent()) {
			throw new RuntimeException();
		}
		Category american = americanCategoryOptional.get();
		
		Optional<Category> mexicanCategoryOptional = categoryRepository.findByDescription("Mexican");
		
		if(!mexicanCategoryOptional.isPresent()) {
			throw new RuntimeException();
		}
		Category mexican = mexicanCategoryOptional.get();
		
		Optional<Category> italianCategoryOptional = categoryRepository.findByDescription("Italian");
		
		if(!italianCategoryOptional.isPresent()) {
			throw new RuntimeException();
		}
		Category italian = italianCategoryOptional.get();
		
		Optional<Category> FastfoodCategoryOptional = categoryRepository.findByDescription("Fast_Food");
		
		if(!FastfoodCategoryOptional.isPresent()) {
			throw new RuntimeException();
		}
		Category fastFood = FastfoodCategoryOptional.get();
		
		
		
		
		//Get all unit of measure
		
		Optional<UnitOfMeasure> tablespponUomOptional = unitOfMeasureRepository.findByDescription("Tablespoon");
		
		if(!tablespponUomOptional.isPresent()) {
			throw new RuntimeException();
		}
		UnitOfMeasure tableSpoon = tablespponUomOptional.get();
		
		Optional<UnitOfMeasure> teaspoonUomOptional = unitOfMeasureRepository.findByDescription("Teaspoon");
		
		if(!teaspoonUomOptional.isPresent()) {
			 throw new RuntimeException();
		}
		UnitOfMeasure teaSpoon = teaspoonUomOptional.get();
		

		
		Optional<UnitOfMeasure> cupUomOptional = unitOfMeasureRepository.findByDescription("Cup");
		
		if(!cupUomOptional.isPresent()) {
			throw new RuntimeException();
		}
		UnitOfMeasure cup = cupUomOptional.get();
		
		
		
		Optional<UnitOfMeasure> eachUomOptional = unitOfMeasureRepository.findByDescription("Each");
		
		if(!eachUomOptional.isPresent()) {
			throw new RuntimeException();
		}
		UnitOfMeasure each = eachUomOptional.get();
		
		Optional<UnitOfMeasure> dashUomOptional = unitOfMeasureRepository.findByDescription("Dash");
		
		if(!eachUomOptional.isPresent()) {
			throw new RuntimeException();
		}
		UnitOfMeasure dash = eachUomOptional.get();
		
		
		Optional<UnitOfMeasure> pinchUomOptional = unitOfMeasureRepository.findByDescription("Pinch");
		
		if(!pinchUomOptional.isPresent()) {
			throw new RuntimeException();
		}
		UnitOfMeasure pinch = pinchUomOptional.get();
		
		Optional<UnitOfMeasure> ounceUomOptional = unitOfMeasureRepository.findByDescription("Ounce");
		
		if(!ounceUomOptional.isPresent()) {
			throw new RuntimeException();
		}
		UnitOfMeasure ounce = ounceUomOptional.get();
		
		//Perfect Guacomole Recipe 
		
		Receipe guacReceipe = new Receipe();
		
		guacReceipe.setPrepTime(10);;
		guacReceipe.setServings(2);
		guacReceipe.setDescription("Be careful handling chiles if using. Wash your hands thoroughly after handling and do not touch your eyes or the area near your eyes with your hands for several hours.");
		guacReceipe.setDifficulty(Difficulty.EASY);
		guacReceipe.setUrl("https://www.simplyrecipes.com/recipes/perfect_guacamole/");
		guacReceipe.setDescription("1 Cut avocado, remove flesh: Cut the avocados in half. Remove seed. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon\" +\n" + 
				"                \"\\n\" +\n" + 
				"                \"2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)\" +\n" + 
				"                \"\\n\" +\n" + 
				"                \"3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\\n\" +\n" + 
				"                \"Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\\n\" +\n" + 
				"                \"Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.\\n\" +\n" + 
				"                \"4 Cover with plastic and chill to store: Place plastic wrap on the surface of the guacamole cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.\\n\" +\n" + 
				"                \"Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.\\n\" +\n" + 
				"                \"\\n\" +\n" + 
				"                \"\\n\" +\n" + 
				"                \"Read more: http://www.simplyrecipes.com/recipes/perfect_guacamole/#ixzz4jvpiV9Sd");
		
		
		//Guacomole Notes
		Notes guacNotes = new Notes();
		guacNotes.setReceipeNotes("For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados.\\n\" +\n" + 
				"                \"Feel free to experiment! One classic Mexican guacamole has pomegranate seeds and chunks of peaches in it (a Diana Kennedy favorite). Try guacamole with added pineapple, mango, or strawberries.\\n\" +\n" + 
				"                \"The simplest version of guacamole is just mashed avocados with salt. Don't let the lack of availability of other ingredients stop you from making guacamole.\\n\" +\n" + 
				"                \"To extend a limited supply of avocados, add either sour cream or cottage cheese to your guacamole dip. Purists may be horrified, but so what? It tastes great.\\n\" +\n" + 
				"                \"\\n\" +\n" + 
				"                \"\\n\" +\n" + 
				"                \"Read more: http://www.simplyrecipes.com/recipes/perfect_guacamole/#ixzz4jvoun5ws");
		
		guacNotes.setReceipe(guacReceipe);
		guacReceipe.setNotes(guacNotes);
		
		
		
		//specify category
		HashSet<Category> categories = new  HashSet<Category>();

		categories.add(mexican);
		categories.add(american);
		
		guacReceipe.setCategory(categories);
		
		//Ingredients
		HashSet<Ingredient> ingredients = new  HashSet<Ingredient>();
		
		guacReceipe.getIngredients().add(new Ingredient("ripe avocados", new BigDecimal(2), each, guacReceipe));
		guacReceipe.getIngredients().add(new Ingredient("Kosher salt", new BigDecimal(".5"), teaSpoon, guacReceipe));
		guacReceipe.getIngredients().add(new Ingredient("fresh lime juice or lemon juice", new BigDecimal(2), tableSpoon, guacReceipe));
		guacReceipe.getIngredients().add(new Ingredient("minced red onion or thinly sliced green onion", new BigDecimal(2), tableSpoon, guacReceipe));
		guacReceipe.getIngredients().add(new Ingredient("serrano chiles, stems and seeds removed, minced", new BigDecimal(2), each, guacReceipe));
		guacReceipe.getIngredients().add(new Ingredient("Cilantro", new BigDecimal(2), tableSpoon, guacReceipe));
		guacReceipe.getIngredients().add(new Ingredient("freshly grated black pepper", new BigDecimal(2), dash, guacReceipe));
		guacReceipe.getIngredients().add(new Ingredient("ripe tomato, seeds and pulp removed, chopped", new BigDecimal(".5"), each, guacReceipe));

		receipes.add(guacReceipe);
		

		
		return receipes;
		
	}
	

	


	
	
	


}
