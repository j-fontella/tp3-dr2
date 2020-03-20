package com.example.tp3_dr2.fragments


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.tp3_dr2.PontuacaoActivity

import com.example.tp3_dr2.R
import com.example.tp3_dr2.viewmodels.QuestionarioViewModel
import kotlinx.android.synthetic.main.fragment_q3.*
import kotlinx.android.synthetic.main.fragment_q4.*
import kotlinx.android.synthetic.main.fragment_q4.btn_anterior
import kotlinx.android.synthetic.main.fragment_q4.btn_proximo
import kotlinx.android.synthetic.main.fragment_q4.rBtn_q2
import kotlinx.android.synthetic.main.fragment_q4.rBtn_q3
import java.util.ArrayList


class Q4Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_q4, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lateinit var questionarioViewModel : QuestionarioViewModel
        activity?.let {
            questionarioViewModel = ViewModelProviders.of(it).get(QuestionarioViewModel::class.java)

        }

        if(questionarioViewModel.questionario!!.navegador == 11){
            radioGroup.check(rBtn_q1.id)
            txtView_questao.text = "Questão 11"
            txtView_enunciado.text = "Qual valor aproximado do seu patrimonio"
            rBtn_q1.text = "Até R$10000"
            rBtn_q2.text = "De R$ 10.001 até R$ 100.000"
            rBtn_q3.text = "De R$ 100.001 até R$ 500.000"
            rBtn_q4.text = "De R$ 500.001 até R$ 1.000.000"
            rBtn_q5.text = "Acima de R$ 1.000.001"

            btn_proximo.setOnClickListener {
                if(rBtn_q2.isChecked){
                    questionarioViewModel.questionario!!.addPontuacao(1)

                }
                else if(rBtn_q3.isChecked){
                    questionarioViewModel.questionario!!.addPontuacao(2)

                }
                else if(rBtn_q4.isChecked){
                    questionarioViewModel.questionario!!.addPontuacao(4)

                }
                else if(rBtn_q5.isChecked){
                    questionarioViewModel.questionario!!.addPontuacao(5)

                }

                findNavController().navigate(R.id.q1Fragment)
                val intent = Intent(activity!!.baseContext, PontuacaoActivity::class.java)
                var respostas = questionarioViewModel.questionario!!.pontuacao
                var cliente = questionarioViewModel.questionario!!.perfil
                intent.putExtra("respostas", respostas)
                intent.putExtra("cliente", cliente)
                startActivity(intent)
            }
            btn_anterior.setOnClickListener {
                questionarioViewModel.questionario!!.navegador -= 1
                questionarioViewModel.questionario!!.removePontuacao()
                findNavController().navigate(R.id.q1Fragment)
            }
        }
    }


}
