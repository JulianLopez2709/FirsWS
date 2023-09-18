package com.example.wordskill02application.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.example.wordskill02application.Cache
import com.example.wordskill02application.R
import com.example.wordskill02application.databinding.ActivityGenerationCodeBinding

class GenerationCodeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGenerationCodeBinding
    lateinit var count:CountDownTimer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityGenerationCodeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        generationCode()

        count=object:CountDownTimer(10000,1000){
            override fun onTick(millisUntilFinished: Long) {
                binding.tvCound.text = "${millisUntilFinished/1000}s"
            }

            override fun onFinish() {
                generationCode()
                count.start()
            }

        }.start()

        binding.btnNext.setOnClickListener {
            saveCode()
            startActivity(Intent(this,IdentificationActivity::class.java))
        }
    }

    private fun saveCode() {
        Cache.num1 = binding.tvNum1.text.toString().toInt()
        Cache.num2 = binding.tvNum2.text.toString().toInt()
        Cache.num3 = binding.tvNum3.text.toString().toInt()
        Cache.num4 = binding.tvNum4.text.toString().toInt()
        Cache.num5 = binding.tvNum5.text.toString().toInt()

    }

    private fun generationCode() {
        binding.tvNum1.text = (0..9).random().toString()
        binding.tvNum2.text = (0..9).random().toString()
        binding.tvNum3.text = (0..9).random().toString()
        binding.tvNum4.text = (0..9).random().toString()
        binding.tvNum5.text = (0..9).random().toString()

    }
}