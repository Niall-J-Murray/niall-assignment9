package me.niallmurray.niall_assignment9.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import me.niallmurray.niall_assignment9.domain.Recipe;

@Repository
public class RecipeRepo {

	private List<Recipe> recipesCollection;

	public List<Recipe> getRecipesCollection() {
		return new ArrayList<Recipe>(this.recipesCollection);
	}

	public void setRecipesCollection(List<Recipe> recipesCollection) {
		this.recipesCollection = new ArrayList<Recipe>(recipesCollection);
	}

}
