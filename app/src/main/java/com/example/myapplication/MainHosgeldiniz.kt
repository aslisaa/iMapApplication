package com.example.myapplication

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.myapplication.databinding.ActivityMainHosgeldinizBinding

class MainHosgeldiniz : AppCompatActivity() {
    lateinit var preferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainHosgeldinizBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //xmlden verilerimizi çekiyoruz
        preferences = getSharedPreferences("bilgiler", MODE_PRIVATE)
        var kayitliKullanici = preferences.getString("kullanici","")
        var kayitliParola = preferences.getString("parola","")

        //textviewlere kullanıcı bilgilerini akarıyoruz
        binding.kullaniciBilgisi.text = "Username: "+kayitliKullanici.toString()
        binding.kullaniciParola.text = "Password: "+kayitliParola.toString()

        //cıkış yap
        binding.btnCikisYap.setOnClickListener {
            intent = Intent(applicationContext,MainActivity::class.java)
            startActivity(intent)


        }

        binding.btnMapDeneme.setOnClickListener {
            intent = Intent(applicationContext,MapsActivity::class.java )
            startActivity(intent)
        }

    }
}