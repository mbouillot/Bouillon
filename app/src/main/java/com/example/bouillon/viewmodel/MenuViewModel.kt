package com.example.bouillon.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bouillon.model.recipes.Recipe
import com.example.bouillon.model.recipes.RecipeRepository
import com.example.bouillon.model.users.UserRepository

class MenuViewModel : ViewModel() {

    private val recipeRepository: RecipeRepository = RecipeRepository()

    private val _search = MutableLiveData<String>()
    val searchValue: MutableLiveData<String>
        get() = _search

    private val _navigation = MutableLiveData<Int>()
    val navigation: LiveData<Int>
        get() = _navigation

    private val _showToast = MutableLiveData<String>()
    val showToast: LiveData<String>
        get() = _showToast

    private val _recipes = MutableLiveData<List<Recipe>>()
    val recipes: LiveData<List<Recipe>>
        get() = _recipes

    init {

    }

    fun search() {
        if (searchValue.value.isNullOrEmpty())  {
            //  TODO: Erreur à gérer
            _showToast.postValue("errorVoid")

        }
        else
        {
            recipeRepository.search(searchValue.value!!, closure = { resultRecipes, exception -> Unit
                if (exception != null) {
                    //  TODO: Display error
                    _showToast.postValue("errorFailled")

                } else {
                    resultRecipes?.let {
                        _recipes.postValue(it)
                    }
                }
            })
        }
    }

    fun favorites() {
        _navigation.postValue(2);
    }
}