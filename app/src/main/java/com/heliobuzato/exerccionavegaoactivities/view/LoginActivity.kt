package com.heliobuzato.exerccionavegaoactivities.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.heliobuzato.exerccionavegaoactivities.view.MainActivity
import com.heliobuzato.exerccionavegaoactivities.R
import com.heliobuzato.exerccionavegaoactivities.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnEntrar.setOnClickListener {

            login()

        }


    }

    private fun login() {
        val email = binding.editTextEmail.text.toString()
        val senha = binding.editTextSenha.text.toString()

        if(email == "teste@teste.com.br" && senha=="12345678"){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Login realizado com sucesso", Toast.LENGTH_SHORT).show()
        }else{
            binding.editTextEmail.text.clear()
            binding.editTextSenha.text.clear()
            binding.editTextEmail.requestFocus()
            Toast.makeText(this, "Email, celular ou senha esta incorreto", Toast.LENGTH_LONG).show()
        }
    }
}