package com.ifp.simpsonapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ifp.simpsonapp.core.RetrofitClient
import com.ifp.simpsonapp.models.Characters
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher

class MainViewModel: ViewModel(){

    private var _characterList = MutableLiveData<List<Characters>>()
    val characterList: LiveData<List<Characters>> get() = _characterList

    fun getCharacters(){
        viewModelScope.launch(Dispatchers.IO){

            val response = RetrofitClient.webService.getCharacters()
            withContext(Dispatchers.Main){
                _characterList.value = response.body()
            }
        }
    }
    fun getCharacter(character: String){
        viewModelScope.launch(Dispatchers.IO){

            val response = RetrofitClient.webService.getCharacter(character)
            withContext(Dispatchers.Main){
                _characterList.value = response.body()
            }
        }
    }
}