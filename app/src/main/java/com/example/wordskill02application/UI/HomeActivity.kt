package com.example.wordskill02application.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.wordskill02application.AppWs.Companion.prefs
import com.example.wordskill02application.R
import com.example.wordskill02application.databinding.ActivityHomeBinding
import java.text.NumberFormat
import java.util.Locale

class HomeActivity : AppCompatActivity() {
    private lateinit var binding:ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        prefs.setHome(true)

        binding.btnLogout.setOnClickListener {
            prefs.wipe()
            startActivity(Intent(this,AboutActivity::class.java))
        }
        binding.tvName.text = prefs.getName().split(" ")[0]


        val num = NumberFormat.getNumberInstance(Locale.getDefault())
        binding.tvAmount.text = num.format(prefs.getAmount())

    }
}