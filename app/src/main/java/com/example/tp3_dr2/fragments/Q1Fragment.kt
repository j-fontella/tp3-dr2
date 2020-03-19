package com.example.tp3_dr2.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders

import com.example.tp3_dr2.R
import com.example.tp3_dr2.viewmodels.QuestionarioViewModel
import kotlinx.android.synthetic.main.fragment_q1.*

/**
 * A simple [Fragment] subclass.
 */
class Q1Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_q1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lateinit var questionarioViewModel : QuestionarioViewModel
        activity?.let {
            questionarioViewModel = ViewModelProviders.of(it).get(QuestionarioViewModel::class.java)

        }
        fun add2Pontos(){
            questionarioViewModel.questionario!!.addPontuacao(2)
        }
        fun add3Pontos(){
            questionarioViewModel.questionario!!.addPontuacao(4)
        }
        fun add4Pontos(){
            questionarioViewModel.questionario!!.addPontuacao(3)
        }


        if(questionarioViewModel.questionario!!.navegador == 1){
            txtView_questao.text = "Questão 1"
            txtView_enunciado.text = "Por quanto tempo você pretende deixar seu dinheiro investido?"
            rBtn_q1.text = "Menos de 6 meses"
            rBtn_q2.text = "Entre 6 meses e 1 ano"
            rBtn_q3.text = "Entre 1 ano e 6 anos"
            rBtn_q4.text = "Acima de 3 anos"
            btn_proximo.setOnClickListener {
                if(rBtn_q2.isChecked){
                    add2Pontos()
                }
                else if(rBtn_q3.isChecked){
                    add3Pontos()
                }
                else if(rBtn_q4.isChecked){
                    add4Pontos()
                }
            }


        }
    }



}
