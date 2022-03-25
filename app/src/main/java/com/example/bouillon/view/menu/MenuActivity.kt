package com.example.bouillon.view.menu

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bouillon.R
import com.example.bouillon.databinding.ActivityMenuBinding
import com.example.bouillon.viewmodel.MenuViewModel


class MenuActivity : AppCompatActivity() {

    private lateinit var viewModel: MenuViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        viewModel = ViewModelProviders.of(this).get(MenuViewModel::class.java)

        viewModel.showToast.observe(this) { showToast ->
            if ( showToast == "errorVoid" ) {
                Toast.makeText(
                    this,
                    "Aucune recherche n'a été saisie",
                    Toast.LENGTH_SHORT
                ).show()
            }

            if ( showToast == "errorFailled" ) {
                Toast.makeText(
                    this,
                    "Cette recherche n'existe pas",
                    Toast.LENGTH_SHORT
                ).show()
            }

        }


        val binding: ActivityMenuBinding = DataBindingUtil.setContentView(this, R.layout.activity_menu)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.recipes.observe(this, Observer { recipes ->
            val adapter = RecipeAdapter(recipes)
            val recyclerView = findViewById<RecyclerView>(R.id.recyclerRecipe)
            recyclerView.setHasFixedSize(true)
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.setAdapter(adapter)
        })

    }
}