package com.heliobuzato.exerccionavegaoactivities.view

import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.heliobuzato.exerccionavegaoactivities.R
import com.heliobuzato.exerccionavegaoactivities.databinding.ActivityDetalhesBinding
import com.heliobuzato.exerccionavegaoactivities.model.Filme
import com.squareup.picasso.Picasso

class DetalhesActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityDetalhesBinding.inflate(layoutInflater)
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

        binding.fabVoltar.setOnClickListener {
            finish()
        }

        val bundle = intent.extras//todos os parametros passado
       if(bundle != null){
           val filme = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
               bundle?.getParcelable("filme", Filme::class.java)
           } else {
               bundle?.getParcelable("filme")
           }

           if (filme != null){
               binding.textDetalhesNome.text = filme?.nome
               binding.textDetalheDescricao.text = filme?.descricao
               //Log.i("info_app", "${filme?.imagemUrl}")
               Picasso.get()
                   .load(filme.imagemId)
                   .placeholder(R.drawable.ic_launcher_background)
                   .into(binding.imgDetalhes)
           }


       }else{
           Toast.makeText(this, "Falha ao recuperar dados", Toast.LENGTH_SHORT).show()
       }


    }
}