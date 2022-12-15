package com.example.myapplication

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
lateinit var binding: ActivityMainBinding
lateinit var preferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        preferences = getSharedPreferences("bilgiler", MODE_PRIVATE)

        binding.btnGirisYap.setOnClickListener {
            var kayitliKullanici = preferences.getString("kullanici","")
            var kayitliparola = preferences.getString("parola","")

            var girisKullanici = binding.girisKullaniciAdi.text.toString()
            var girisParola= binding.girisParola.text.toString()

            if ((kayitliKullanici == girisKullanici) && (kayitliparola == girisParola)){

                intent = Intent(applicationContext,MainHosgeldiniz::class.java)
                startActivity(intent)
            } else{
                Toast.makeText(applicationContext,"Login information is incorrect", Toast.LENGTH_LONG).show()
            }
        }

        binding.btnKayitOl.setOnClickListener {

            intent = Intent(applicationContext,MainKayitOl::class.java)
            startActivity(intent)
        }
    }



    }
