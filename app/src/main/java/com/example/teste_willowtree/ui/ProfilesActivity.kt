package com.example.teste_willowtree.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.teste_willowtree.R
import com.example.teste_willowtree.adapter.GridLayoutadapter
import com.example.teste_willowtree.controller.ProfilesViewModel
import com.example.teste_willowtree.databinding.ActivityProfilesBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProfilesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfilesBinding
    private lateinit var gridAdapter: GridLayoutadapter
    private val viewmodel: ProfilesViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityProfilesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setupGridProfiles()
        setupViewmodel()
    }

    private fun setupGridProfiles(){
        val grid = binding.gridProfiles
        gridAdapter = GridLayoutadapter()
        grid.adapter = gridAdapter
    }

    private fun setupViewmodel(){
        viewmodel.loadProfiles()
        viewmodel.profiles.observe(this) {
            gridAdapter.setList(it)
            println(it)
            binding.workerName.text = it.first().firstName
        }
    }
}