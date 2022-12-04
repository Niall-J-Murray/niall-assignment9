package me.niallmurray.niall_assignment9.web;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import me.niallmurray.niall_assignment9.domain.Recipe;
import me.niallmurray.niall_assignment9.repository.RecipeRepo;
import me.niallmurray.niall_assignment9.service.FileService;

@RestController
public class FileController {

	@Autowired
	private FileService fileService;

	@Autowired
	private RecipeRepo recipeRepo;

	@GetMapping("")
	public List<String> homePage() {
		fileService.readFile();
		List<String> endpoints = new ArrayList<String>();
		endpoints.add("Recipe Collection Home Page");
		endpoints.add("Please enter one of the links to filter recipes: ");
		endpoints.add("http://127.0.0.1:8080/all-recipes");
		endpoints.add("http://127.0.0.1:8080/gluten-free");
		endpoints.add("http://127.0.0.1:8080/vegetarian");
		endpoints.add("http://127.0.0.1:8080/vegan");
		endpoints.add("http://127.0.0.1:8080/vegan-and-gluten-free");

		return endpoints;
	}

	@GetMapping("/all-recipes")
	public List<Recipe> allRecipes() {
		fileService.readFile();
		return recipeRepo.getRecipesCollection();
	}

	@GetMapping("/gluten-free")
	public List<Recipe> glutenFree() {
		fileService.readFile();

		return recipeRepo.getRecipesCollection()
				.stream()
				.filter(recipes -> recipes.getGlutenFree())
				.collect(Collectors.toList());
	}

	@GetMapping("/vegetarian")
	public List<Recipe> vegetarian() {
		fileService.readFile();

		return recipeRepo.getRecipesCollection()
				.stream()
				.filter(recipes -> recipes.getVegetarian())
				.collect(Collectors.toList());
	}

	@GetMapping("/vegan")
	public List<Recipe> vegan() {
		fileService.readFile();

		return recipeRepo.getRecipesCollection()
				.stream()
				.filter(recipes -> recipes.getVegan())
				.collect(Collectors.toList());
	}

	@GetMapping("/vegan-and-gluten-free")
	public List<Recipe> veganAndGlutenFree() {
		fileService.readFile();

		for (Recipe recipe : recipeRepo.getRecipesCollection()) {
			System.out.println(recipe.toString());
		}

		return recipeRepo.getRecipesCollection()
				.stream()
				.filter(recipes -> recipes.getVegan())
				.filter(recipes -> recipes.getGlutenFree())
				.collect(Collectors.toList());
	}
}
