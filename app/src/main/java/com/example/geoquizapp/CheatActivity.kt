package com.example.geoquizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.geoquizapp.databinding.ActivityCheatBinding

class CheatActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityCheatBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_cheat)
        binding = ActivityCheatBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}