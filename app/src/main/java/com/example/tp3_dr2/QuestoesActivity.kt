package com.example.tp3_dr2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.example.tp3_dr2.fragments.Q1Fragment

import com.example.tp3_dr2.viewmodels.QuestionarioViewModel












class QuestoesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questoes)
        val nome:String = intent.getStringExtra("user")
        var questionarioViewModel = ViewModelProviders.of(this).get(QuestionarioViewModel::class.java)
        questionarioViewModel.questionario!!.perfil = nome
    }
    override fun onBackPressed() {
        var questionarioViewModel = ViewModelProviders.of(this).get(QuestionarioViewModel::class.java)
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        if(questionarioViewModel.questionario!!.navegador == 1){
            this.finish()
        }
        else{
            questionarioViewModel.questionario!!.navegador -= 1
            questionarioViewModel.questionario!!.removePontuacao()
            transaction.replace(R.id.q1Fragment, Q1Fragment())
            transaction.commit()
        }



    }
}
