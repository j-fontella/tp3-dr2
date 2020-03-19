package com.example.tp3_dr2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun redirecionarQuestoes(view: View){
        var intent = Intent(this, QuestoesActivity::class.java)
        var user : String = (edTxt_nome.text.toString())
        intent.putExtra("user", user)
        startActivity(intent)
    }
}

