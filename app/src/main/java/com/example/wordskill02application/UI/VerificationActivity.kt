package com.example.wordskill02application.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.wordskill02application.AppWs.Companion.prefs
import com.example.wordskill02application.Cache
import com.example.wordskill02application.R
import com.example.wordskill02application.databinding.ActivityVerificationBinding

class VerificationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityVerificationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVerificationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvName.text = prefs.getName().split(" ")[0]

        binding.btnBack.setOnClickListener {
            startActivity(Intent(this, IdentificationActivity::class.java))
        }

        binding.btnGetNewCode.setOnClickListener {
            startActivity(Intent(this, GenerationCodeActivity::class.java))
        }


        binding.btnNext.setOnClickListener {
            if (binding.etNum1.text.toString() == Cache.num1.toString() && 
                binding.etNum2.text.toString() == Cache.num2.toString() && 
                binding.etNum3.text.toString() == Cache.num3.toString() &&
                binding.etNum4.text.toString() == Cache.num4.toString() &&
                binding.etNum5.text.toString() == Cache.num5.toString()) {
                startActivity(Intent(this,HomeActivity::class.java))
            }else{
                Toast.makeText(this, "It's not correct", Toast.LENGTH_SHORT).show()
            }
        }


    }
}