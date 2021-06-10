package com.example.autoapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.autoapp.R
import com.example.autoapp.databinding.ActivityMainBinding
import com.example.autoapp.ui.main.MainFragment
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    val mainF : MainFragment by inject()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction().replace(R.id.flMain, mainF).commit()
    }
}