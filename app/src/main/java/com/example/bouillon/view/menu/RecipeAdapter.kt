package com.example.bouillon.view.menu

import android.R
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bouillon.databinding.CellRecipeBinding
import com.example.bouillon.model.recipes.Recipe


   class RecipeAdapter(private var Context: Context): RecyclerView.Adapter<RecipeAdapter.ViewHolder>() {

    private lateinit var _recipes: MutableList<Recipe>





       class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
           val title: TextView
           val img: ImageView

           init {
               title = itemView.findViewById(com.example.bouillon.R.id.textRecipe)
               img = itemView.findViewById(com.example.bouillon.R.id.imageRecipe)
           }
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


       override fun onBindViewHolder(holder: ViewHolder, position: Int) {
           val currentRecipe = _recipes[position]
           holder.title.text = currentRecipe.title
           Glide.with(Context)
               .load(currentRecipe.imageRecipe)
               .into(holder.img)
       }

    override fun getItemCount(): Int {
        return _recipes.size
    }



   }