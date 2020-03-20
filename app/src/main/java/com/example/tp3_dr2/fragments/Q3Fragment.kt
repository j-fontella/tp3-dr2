package com.example.tp3_dr2.fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController


import com.example.tp3_dr2.R
import com.example.tp3_dr2.viewmodels.QuestionarioViewModel
import kotlinx.android.synthetic.main.fragment_q3.*


class Q3Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_q3, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lateinit var questionarioViewModel: QuestionarioViewModel
        activity?.let {
            questionarioViewModel = ViewModelProviders.of(it).get(QuestionarioViewModel::class.java)

        }


        if (questionarioViewModel.questionario!!.navegador == 8) {
            if (rbtn_q1.isChecked) {
                questionarioViewModel.questionario!!.addPontuacao(1)
            } else if (rBtn_q2.isChecked) {
                questionarioViewModel.questionario!!.addPontuacao(2)
            } else if (rBtn_q3.isChecked) {
                questionarioViewModel.questionario!!.addPontuacao(4)
            }

            btn_proximo.setOnClickListener {
                questionarioViewModel.questionario!!.navegador = 9
                findNavController().navigate(R.id.q3Fragment2)
            }
            btn_anterior.setOnClickListener {
                questionarioViewModel.questionario!!.navegador -= 1
                questionarioViewModel.questionario!!.removePontuacao()
                findNavController().navigate(R.id.q1Fragment)
            }

        } else if (questionarioViewModel.questionario!!.navegador == 9) {
            img_questao.setImageResource(R.drawable.q9)
            rbtn_q1.text = "1 ponto"
            rBtn_q2.text = "Entre 2 e 6 pontos"
            rBtn_q3.text = "Acima de 7 pontos"
            if (rbtn_q1.isChecked) {
                questionarioViewModel.questionario!!.addPontuacao(1)
            } else if (rBtn_q2.isChecked) {
                questionarioViewModel.questionario!!.addPontuacao(2)
            } else if (rBtn_q3.isChecked) {
                questionarioViewModel.questionario!!.addPontuacao(4)
            }
            btn_proximo.setOnClickListener {
                questionarioViewModel.questionario!!.navegador = 10
                findNavController().navigate(R.id.q1Fragment)
            }
            btn_anterior.setOnClickListener {
                questionarioViewModel.questionario!!.navegador -= 1
                questionarioViewModel.questionario!!.removePontuacao()
                findNavController().navigate(R.id.q3Fragment2)
            }

        }
    }


}






