package com.example.wordskill02application.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.wordskill02application.R
import com.example.wordskill02application.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {
    private lateinit var binding:ActivityAboutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNext.setOnClickListener {
            startActivity(Intent(this@AboutActivity,GenerationCodeActivity::class.java))
            finish()
        }
    }
}