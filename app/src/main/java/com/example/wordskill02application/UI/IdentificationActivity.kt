package com.example.wordskill02application.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.wordskill02application.AppWs.Companion.prefs
import com.example.wordskill02application.R
import com.example.wordskill02application.databinding.ActivityIdentificationBinding

class IdentificationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityIdentificationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIdentificationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
            startActivity(Intent(this,GenerationCodeActivity::class.java))
        }

        binding.btnNext.setOnClickListener {
            if (binding.etAmount.text.isNullOrEmpty() && binding.etFullName.text.isNullOrEmpty()){
                Toast.makeText(this, "incompleto", Toast.LENGTH_SHORT).show()
            }else{
                prefs.saveName(binding.etFullName.text.toString())
                prefs.setAmount(binding.etAmount.text.toString().toInt())
                startActivity(Intent(this,VerificationActivity::class.java))
            }
        }
    }
}