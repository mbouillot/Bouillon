package com.example.bouillon.view.menu

import android.R
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bouillon.databinding.CellRecipeBinding
import com.example.bouillon.model.recipes.Recipe


class RecipeAdapter: RecyclerView.Adapter<RecipeViewHolder> {

    private lateinit var _recipes: MutableList<Recipe>

    constructor(items: List<Recipe>) : super() {
        _recipes = mutableListOf<Recipe>()
        _recipes.addAll(items)
    }

    fun updateRecipes(items: List<Recipe>) {
        _recipes.clear()
        _recipes.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = CellRecipeBinding.inflate(layoutInflater, parent, false)
        return RecipeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val currentRecipe = _recipes.get(position)
        holder.setRecipe(currentRecipe)
    }

    override fun getItemCount(): Int {
        return _recipes.size
    }

}