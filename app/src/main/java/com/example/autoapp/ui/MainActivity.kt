package com.example.autoapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.autoapp.R
import com.example.autoapp.databinding.ActivityMainBinding
import com.example.autoapp.ui.main.MainFragment
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity(), NavControllerBridge {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navController = Navigation.findNavController(this, R.id.navHostFragment)
    }

    override fun navController(): NavController {
        return navController
    }
}