package me.niallmurray.niall_assignment9.domain;

import java.math.BigDecimal;

public class Recipe {

	private String title;
	private Integer servings;
	private BigDecimal pricePerServing;
	private Double spoonacularScore;
	private Double readyInMins;
	private Double prepInMins;
	private Double cookInMins;
	private Boolean dairyFree;
	private Boolean glutenFree;
	private Boolean vegetarian;
	private Boolean vegan;
	private String instructions;

	public Recipe(String title, Integer servings, BigDecimal pricePerServing, Double spoonacularScore, Double readyInMins, Double prepInMins,
			Double cookInMins, Boolean dairyFree, Boolean glutenFree, Boolean vegetarian, Boolean vegan, String instructions) {
		this.title = title;
		this.servings = servings;
		this.pricePerServing = pricePerServing;
		this.spoonacularScore = spoonacularScore;
		this.readyInMins = readyInMins;
		this.prepInMins = prepInMins;
		this.cookInMins = cookInMins;
		this.dairyFree = dairyFree;
		this.glutenFree = glutenFree;
		this.vegetarian = vegetarian;
		this.vegan = vegan;
		this.instructions = instructions;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getServings() {
		return servings;
	}

	public void setServings(Integer servings) {
		this.servings = servings;
	}

	public BigDecimal getPricePerServing() {
		return pricePerServing;
	}

	public void setPricePerServing(BigDecimal pricePerServing) {
		this.pricePerServing = pricePerServing;
	}

	public Double getSpoonacularScore() {
		return spoonacularScore;
	}

	public void setSpoonacularScore(Double spoonacularScore) {
		this.spoonacularScore = spoonacularScore;
	}

	public Double getReadyInMins() {
		return readyInMins;
	}

	public void setReadyInMins(Double readyInMins) {
		this.readyInMins = readyInMins;
	}

	public Double getPrepInMins() {
		return prepInMins;
	}

	public void setPrepInMins(Double prepInMins) {
		this.prepInMins = prepInMins;
	}

	public Double getCookInMins() {
		return cookInMins;
	}

	public void setCookInMins(Double cookInMins) {
		this.cookInMins = cookInMins;
	}

	public Boolean getDairyFree() {
		return dairyFree;
	}

	public void setDairyFree(Boolean dairyFree) {
		this.dairyFree = dairyFree;
	}

	public Boolean getGlutenFree() {
		return glutenFree;
	}

	public void setGlutenFree(Boolean glutenFree) {
		this.glutenFree = glutenFree;
	}

	public Boolean getVegetarian() {
		return vegetarian;
	}

	public void setVegetarian(Boolean vegetarian) {
		this.vegetarian = vegetarian;
	}

	public Boolean getVegan() {
		return vegan;
	}

	public void setVegan(Boolean vegan) {
		this.vegan = vegan;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	// Not needed for endpoint output, but could be useful to customise formatting
	// of output.
	@Override
	public String toString() {
		return String.format(
				"\nRecipe- "
						+ "\nTitle: %s, Servings: %s, Price Per Serving: %s, Spoonacular Score: %s, "
						+ "\nReady In: %smins, Prep Time: %smins, Cook For: %smins, "
						+ "\nDairy Free: %s, Gluten Free: %s, Vegetarian: %s, Vegan: %s, "
						+ "\nInstructions: %s \n",
				title, servings, pricePerServing, spoonacularScore,
				readyInMins, prepInMins, cookInMins,
				dairyFree, glutenFree, vegetarian, vegan,
				instructions);
	}

}