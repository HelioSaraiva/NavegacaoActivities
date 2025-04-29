package com.heliobuzato.exerccionavegaoactivities.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.heliobuzato.exerccionavegaoactivities.R
import com.heliobuzato.exerccionavegaoactivities.databinding.ActivityLoginBinding
import com.heliobuzato.exerccionavegaoactivities.databinding.ActivityMainBinding
import com.heliobuzato.exerccionavegaoactivities.model.Filme

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
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

        val filmeBreakin =  Filme(
            nome ="Breaking Bad - A Química do Mal",
            descricao = "Breaking Bad é uma série dramática que acompanha Walter White, um professor de química do ensino médio que, após ser diagnosticado com câncer, começa a fabricar metanfetamina para sustentar sua família. À medida que mergulha no mundo do crime, ele se transforma de homem comum em um impiedoso chefão do tráfico.",
            imagemId  = R.drawable.bkbad)
        val filmeBrooklin = Filme("Brooklyn Nine-Nine","Brooklyn Nine-Nine é uma série de comédia policial que segue os detetives e equipe do 99º Distrito de Polícia de Nova York. Com personagens excêntricos e situações hilárias, a série mistura mistério com humor de forma única.", R.drawable.brok99)
        val filmeHouse = Filme("House, M.D.","House, M.D. é uma série médica que acompanha o Dr. Gregory House, um brilhante, porém antiético, diagnóstico de doenças complexas. Sua abordagem arrogante e método impessoal de tratar os pacientes desafiam constantemente as normas do hospital e suas relações pessoais.",R.drawable.drhouse)
        val filmeOffice = Filme("The Office (US)","The Office (US) é uma série de comédia que retrata o cotidiano de uma equipe de vendas em uma empresa de papel em Scranton, Pensilvânia, filmada no estilo de documentário. Com personagens peculiares e um humor irreverente, a série explora os desafios e absurdos do ambiente de trabalho.",R.drawable.theoffice)
        val filmeOne = Filme("One Piece ","One Piece é um anime e manga que segue as aventuras de Monkey D. Luffy e sua tripulação de piratas em busca do lendário tesouro \"One Piece\". Com um mundo vasto e repleto de personagens cativantes, a série mistura ação, humor e emoção em uma jornada épica.",R.drawable.imgfundoonepierce)



        binding.imgBreaking.setOnClickListener {
            enviarDetalhes(filmeBreakin)
        }
        binding.imgHouse.setOnClickListener {
            enviarDetalhes(filmeHouse)
        }
        binding.imgBrooklin.setOnClickListener {
            enviarDetalhes(filmeBrooklin)
        }
        binding.imgOffice.setOnClickListener {
            enviarDetalhes(filmeOffice)
        }
        binding.btnDetalhes.setOnClickListener {
            enviarDetalhes(filmeOne)
        }





    }

    private fun enviarDetalhes(filme: Filme) {
        val intent = Intent(this, DetalhesActivity::class.java)
        intent.putExtra("filme", filme)
        startActivity(intent)
    }
}