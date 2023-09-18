package com.example.wordskill02application.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.example.wordskill02application.AppWs.Companion.prefs
import com.example.wordskill02application.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        object :CountDownTimer(3000,1000){
            override fun onTick(millisUntilFinished: Long) {
               binding.tvCound.text = "${millisUntilFinished/1000}s"
            }

            override fun onFinish() {
                if(prefs.getHome()){
                    startActivity(Intent(this@MainActivity,HomeActivity::class.java))

                }else{
                    startActivity(Intent(this@MainActivity,AboutActivity::class.java))
                }
                finish()
            }

        }.start()
    }
}