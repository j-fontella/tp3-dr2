package com.example.tp3_dr2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.tp3_dr2.viewmodels.QuestionarioViewModel
import kotlinx.android.synthetic.main.activity_questoes.*

class QuestoesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questoes)
        val nome:String = intent.getStringExtra("user")
        var questionarioViewModel = ViewModelProviders.of(this).get(QuestionarioViewModel::class.java)
        questionarioViewModel.questionario!!.perfil = nome

    }

    fun iniciarQuestionario(view: View){

    }
}
