package com.example.tp3_dr2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_pontuacao.*
import java.util.ArrayList

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
}
