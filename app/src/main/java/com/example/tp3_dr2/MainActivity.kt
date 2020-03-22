package com.example.tp3_dr2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.R.attr.fragment
import kotlinx.android.synthetic.main.activity_main.*
import android.R.attr.fragment
import androidx.core.app.ComponentActivity.ExtraData
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import com.example.tp3_dr2.fragments.Q1Fragment


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }




    fun redirecionarQuestoes(view: View){
        var intent = Intent(this, QuestoesActivity::class.java)
        var user : String = (edTxt_nome.text.toString())
        if(edTxt_nome.text.isNullOrBlank()){
            Toast.makeText(this, "Digite um nome", Toast.LENGTH_LONG).show()
        }
        else{
            intent.putExtra("user", user)
            startActivity(intent)
        }

    }
}

