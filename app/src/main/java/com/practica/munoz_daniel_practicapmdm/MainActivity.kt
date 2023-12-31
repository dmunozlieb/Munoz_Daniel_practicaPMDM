package com.practica.munoz_daniel_practicapmdm


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.practica.munoz_daniel_practicapmdm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        cargarGif()
        binding.cardCalendar.setOnClickListener{
            ejecutarActivityCalendar()
        }

        binding.cardDulces.setOnClickListener{
            ejecutarAtivityReceta()
        }

    }
    fun cargarGif(){
        Glide.with(this)
            .load(R.drawable.happy_bear)
            .into(binding.gifHappybear)
    }

    fun ejecutarActivityCalendar(){
        if (validarettext()){
            val intent = Intent(this, ActivityCalendar::class.java)
            val user_name = binding.etNombre.text.toString()
            intent.putExtra("name", user_name)
            startActivity(intent)
        }else{
            Toast.makeText(applicationContext,
                "Por favor introduzca un nombre primero!",
                Toast.LENGTH_SHORT).show()

        }
    }

    fun ejecutarAtivityReceta(){
        val intent = Intent(this, ActivityReceta::class.java)
        startActivity(intent)
    }
    private fun validarettext(): Boolean{
        return binding.etNombre.text.toString() != null &&
                binding.etNombre.text.toString() != ""
    }
}