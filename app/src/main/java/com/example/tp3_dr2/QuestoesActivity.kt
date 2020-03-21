package com.example.tp3_dr2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders

import com.example.tp3_dr2.viewmodels.QuestionarioViewModel












class QuestoesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questoes)
//        val nome:String = intent.getStringExtra("user")
        var questionarioViewModel = ViewModelProviders.of(this).get(QuestionarioViewModel::class.java)
        questionarioViewModel.questionario!!.perfil = "joao"

    }
    override fun onBackPressed() {
    }

}
