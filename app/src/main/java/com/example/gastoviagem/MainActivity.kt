package com.example.gastoviagem

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.gastoviagem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        observerButtons()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun observerButtons(){
        binding.buttonCalculate.setOnClickListener {
            calculate()
        }
        binding.buttonBruno.setOnClickListener {
            Toast.makeText(this, "Olá", Toast.LENGTH_SHORT).show()
            }
    }
    @SuppressLint("SetTextI18n")
    private fun calculate(){
        val distance = binding.editDistance.getText().toString().toInt()
        val price =  binding.editPrice.getText().toString().toInt()
        val autonomy = binding.editAutonomy.getText().toString().toInt()

        val soma = distance + price + autonomy
        binding.textTotalValue.text = "R$$soma"

    }
}