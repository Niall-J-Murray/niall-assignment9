package me.niallmurray.niall_assignment9.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.niallmurray.niall_assignment9.domain.Recipe;
import me.niallmurray.niall_assignment9.repository.RecipeRepo;

@Service
public class FileService {

	@Autowired
	private RecipeRepo recipeRepo;

	public void readFile() {

		List<Recipe> allRecipes = new ArrayList<Recipe>();
		CSVFormat csvFormat = CSVFormat.Builder.create()
				.setIgnoreSurroundingSpaces(true)
				.setEscape('\\')
				.setHeader()
				.setSkipHeaderRecord(false)
				.build();

		BufferedReader fileReader = null;
		try {
			fileReader = new BufferedReader(new FileReader("recipes.txt"));
			Iterable<CSVRecord> records = csvFormat.parse(fileReader);

			for (CSVRecord record : records) {

				String title = record.get("Title");
				Integer servings = Integer.parseInt(record.get("Servings"));
				BigDecimal pricePerServing = BigDecimal.valueOf(Double.parseDouble(record.get("Price Per Serving")));
				Double spoonacularScore = Double.parseDouble(record.get("Spoonacular Score"));
				Double readyInMins = Double.parseDouble(record.get("Ready In Minutes"));
				Double prepInMins = Double.parseDouble(record.get("Preparation Minutes"));
				Double cookInMins = Double.parseDouble(record.get("Cooking Minutes"));
				Boolean dairyFree = Boolean.parseBoolean(record.get("Dairy Free"));
				Boolean glutenFree = Boolean.parseBoolean(record.get("Gluten Free"));
				Boolean vegetarian = Boolean.parseBoolean(record.get("Vegetarian"));
				Boolean vegan = Boolean.parseBoolean(record.get("Vegan"));
				String instructions = record.get("Instructions");

				Recipe recipe = new Recipe(title, servings, pricePerServing, spoonacularScore,
						readyInMins, prepInMins, cookInMins,
						dairyFree, glutenFree, vegetarian, vegan,
						instructions);

				allRecipes.add(recipe);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fileReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// Sort recipes by Spoonacular score, then title for easier searching.
		List<Recipe> sortedByScore = allRecipes.stream()
				.sorted((t1, t2) -> t1.getTitle()
						.compareTo(t2.getTitle()))
				.sorted((s1, s2) -> s2.getSpoonacularScore()
						.compareTo(s1.getSpoonacularScore()))
				.collect(Collectors.toList());

		recipeRepo.setRecipesCollection(sortedByScore);
	}
}
