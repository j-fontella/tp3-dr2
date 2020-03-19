package com.example.tp3_dr2.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController

import com.example.tp3_dr2.R
import com.example.tp3_dr2.viewmodels.QuestionarioViewModel
import kotlinx.android.synthetic.main.fragment_q2.*

/**
 * A simple [Fragment] subclass.
 */
class Q2Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_q2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lateinit var questionarioViewModel: QuestionarioViewModel
        activity?.let {
            questionarioViewModel = ViewModelProviders.of(it).get(QuestionarioViewModel::class.java)

        }





        if (questionarioViewModel.questionario!!.navegador == 4) {
            txtView_questao.text = "Questão 4"
            txtView_enunciado.text =
                "Considerando seus rendimentos regulares, qual a porcentagem você pretende reservar para aplicações financeiras?"
            rBtn_q1.text = "No máximo 25% "
            rBtn_q2.text = "Entre 25.01% e 50%"
            rBtn_q3.text = "Acima de 50%"
            btn_proximo.setOnClickListener {
                if (rBtn_q2.isChecked) {
                    questionarioViewModel.questionario!!.addPontuacao(2)
                } else if (rBtn_q3.isChecked) {
                    questionarioViewModel.questionario!!.addPontuacao(4)
                }

                questionarioViewModel.questionario!!.navegador = 5
                findNavController().navigate(R.id.q2Fragment)
            }
        } else if (questionarioViewModel.questionario!!.navegador == 5) {
            txtView_questao.text = "Questão 5"
            txtView_enunciado.text =
                "Caso as suas aplicações sofressem uma queda superior a 30%, o que você faria?"
            rBtn_q1.text = "Resgataria toda a aplicação e aplicaria na poupança "
            rBtn_q2.text = "Manteria aplicação aguardando uma melhora do mercado "
            rBtn_q3.text = "Aumentaria a aplicação para aproveitar as oportunidades do mercado"
            btn_proximo.setOnClickListener {
                if (rBtn_q2.isChecked) {
                    questionarioViewModel.questionario!!.addPontuacao(2)
                } else if (rBtn_q3.isChecked) {
                    questionarioViewModel.questionario!!.addPontuacao(4)
                }

                questionarioViewModel.questionario!!.navegador = 6
                findNavController().navigate(R.id.q1Fragment)
            }
        }
    }

}
