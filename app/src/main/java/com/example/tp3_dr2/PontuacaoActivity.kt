package com.example.tp3_dr2

import android.os.Bundle
import android.view.KeyEvent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_pontuacao.*
import java.util.*
import kotlin.concurrent.schedule

class PontuacaoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pontuacao)
        var respostas = intent.getSerializableExtra("respostas") as ArrayList<Int>
        var cliente = intent.getStringExtra("cliente")

        txtVw_nome.text = cliente
        var finalscore = 0
        respostas.forEach {
            finalscore += it
        }
        Toast.makeText(this, "Você fez: " + finalscore + " pontos", Toast.LENGTH_SHORT).show()
        if(finalscore <= 14){
            txtVw_perfil.text = "Conservador"
        }
        else if(finalscore >= 15 && finalscore <= 35){
            txtVw_perfil.text = "Moderado"
        }
        else{
            txtVw_perfil.text = "Arrojado"
        }
    }

    override fun onBackPressed() {
        Toast.makeText(this, "Renicie o APP para fazer o teste novamente", Toast.LENGTH_SHORT).show()

    }



}
