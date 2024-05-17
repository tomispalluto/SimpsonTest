package com.ifp.simpsonapp.views

import android.os.Bundle
import android.widget.GridLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.ifp.simpsonapp.R
import com.ifp.simpsonapp.databinding.ActivityMainBinding
import com.ifp.simpsonapp.viewmodels.MainViewModel
import com.ifp.simpsonapp.views.adapters.CharacterAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: ViewModel
    private lateinit var adapter: CharacterAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider (this)[MainViewModel::class.java]

        setupRecyclerView()

        (viewModel as MainViewModel).getCharacters()
        (viewModel as MainViewModel).characterList.observe(this){
            adapter.listCharacters = it
            adapter.notifyDataSetChanged()
        }
        binding.tilBuscar.setEndIconOnClickListener{
            if(binding.tietBuscar.text.toString()==""){
                (viewModel as MainViewModel).getCharacters()
            } else {
                (viewModel as MainViewModel).getCharacter(binding.tietBuscar.text.toString().trim())
            }
        }

    }
    fun setupRecyclerView(){
        binding.rvPersonajes.layoutManager = GridLayoutManager(this, 3)
        adapter = CharacterAdapter(this, arrayListOf())

        binding.rvPersonajes.adapter = adapter
    }
}