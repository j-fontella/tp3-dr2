package com.example.tp3_dr2.fragments


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.tp3_dr2.PontuacaoActivity

import com.example.tp3_dr2.R
import com.example.tp3_dr2.viewmodels.QuestionarioViewModel
import kotlinx.android.synthetic.main.fragment_q1.*

import kotlinx.android.synthetic.main.fragment_q1.btn_proximo
import kotlinx.android.synthetic.main.fragment_q1.rBtn_q1
import kotlinx.android.synthetic.main.fragment_q1.rBtn_q2
import kotlinx.android.synthetic.main.fragment_q1.rBtn_q3
import kotlinx.android.synthetic.main.fragment_q1.txtView_enunciado
import kotlinx.android.synthetic.main.fragment_q1.txtView_questao

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
        lateinit var questionarioViewModel: QuestionarioViewModel
        activity?.let {
            questionarioViewModel = ViewModelProviders.of(it).get(QuestionarioViewModel::class.java)

        }
        questionarioViewModel.questionario!!.addQuestao("Questao 1",
            "Por quanto tempo você pretende deixar seu dinheiro investido",
            "Menos de 6 meses",
            "Menos de 6 meses",
            "Entre 1 ano e 6 Anos",
            "Acima de 3 anos")
        questionarioViewModel.questionario!!.addQuestao("Questao 2",
            "Qual o objetivo desse investimento? ",
            "Preservação do capital para não perder valor ao longo do tempo, assumindo baixos riscos de perdas",
            "Aumento gradual do capital ao longo do tempo, assumindo riscos moderados",
            "Aumento do capital acima da taxa de retorno média do mercado, mesmo que isso implique assumir riscos de perdas elevadas",
            "Obter no curto prazo retornos elevados e significativamente acima da taxa de retorno média do mercado, assumindo riscos elevados")
        questionarioViewModel.questionario!!.addQuestao("Questao 3",
            "Qual das alternativas melhor classifica sua formação e experiência com o mercado financeiro?",
            "Não possuo formação acadêmica ou conhecimento do mercado financeiro",
            "Possuo formação acadêmica na área financeira, mas não tenho experiência com o mercado financeiro",
            "Possuo formação acadêmica em outra área, mas possuo conhecimento do mercado financeiro",
            "Possuo formação acadêmica na área financeira ou pleno conhecimento do mercado financeiro")
        questionarioViewModel.questionario!!.addQuestao("Questao 4",
            "Considerando seus rendimentos regulares, qual a porcentagem você pretende reservar para aplicações financeiras?",
            "No máximo 25%",
            "Entre 25,01 e 50%",
            "Mais de 50%")

        questionarioViewModel.questionario!!.addQuestao("Questao 5",
            "Caso as suas aplicações sofressem uma queda superior a 30%, o que você faria?",
            "Resgataria toda a aplicação e aplicaria na poupança",
            "Manteria aplicação aguardando uma melhora do mercado",
            "Aumentaria a aplicação para aproveitar as oportunidades do mercado")
        questionarioViewModel.questionario!!.addQuestao("Questao 6",
            "Como está distribuído o seu patrimônio?",
            "Meu patrimônio não está aplicado ou está todo aplicado em renda fixa e/ou imóveis",
            "Menos de 25% em renda variável e o restante em renda fixa e/ou imóveis",
            "Entre 25,01 e 50% aplicado em renda variável e o restante em renda fixa e/ou imóveis",
            "Acima de 50% em renda variável")
        questionarioViewModel.questionario!!.addQuestao("Questao 7",
            "Em relação as aplicações e rendimentos, em qual dessas situações você se enquadra?",
            "Conto com o rendimento dessas aplicações para complementar minha renda mensal",
            "Eventualmente posso resgatar parte das aplicações para fazer frente aos meus gastos. " +
                    "Contudo, não tenho intenção de resgatar no curto prazo e pretendo fazer aplicações regulares",
            "Não tenho intenção de resgatar no curto prazo, mas não pretendo realizar novas aplicações",
            "Não tenho intenção de resgatar no curto prazo e ainda pretendo fazer aplicações regulares")
        questionarioViewModel.questionario!!.addQuestao("Questao 8",
            "Qual sua faixa de renda mensal média?",
            "Até R$1000",
            "R$ 10001 até R$5000",
            "R$5001 até R$10000",
            "Acima de R$10000")
        questionarioViewModel.questionario!!.addQuestao("Questao 9",
            "11. Qual o valor aproximado do seu patrimônio?",
            "Até R$10000",
            "De R$ 10.001 até R$ 100.000",
            "De R$ 100.001 até R$ 500.000",
            "De R$ 500.001 até R$ 1.000.000",
            "Acima de R$ 1.000.001 ")
        if (questionarioViewModel.questionario!!.navegador == 1) {
            txtView_questao.text = questionarioViewModel.questionario!!.questoes.get(0).enunciado
            txtView_enunciado.text = questionarioViewModel.questionario!!.questoes.get(0).getqNumero()
            rBtn_q1.text = questionarioViewModel.questionario!!.questoes.get(0).respostas.get(0)
            rBtn_q2.text = questionarioViewModel.questionario!!.questoes.get(0).respostas.get(1)
            rBtn_q3.text = questionarioViewModel.questionario!!.questoes.get(0).respostas.get(2)
            rBtn_q4.text = questionarioViewModel.questionario!!.questoes.get(0).respostas.get(3)
            rBtn_q5.visibility = View.INVISIBLE
            btn_proximo.setOnClickListener {
                if (!rBtn_q1.isChecked && !rBtn_q2.isChecked && !rBtn_q3.isChecked && !rBtn_q4.isChecked) {
                    Toast.makeText(
                        activity!!.baseContext!!,
                        "Marque pelo menos uma opção",
                        Toast.LENGTH_LONG
                    ).show()
                } else {
                    if (rBtn_q1.isChecked) {
                        questionarioViewModel.questionario!!.addPontuacao(0)
                    } else if (rBtn_q2.isChecked) {
                        questionarioViewModel.questionario!!.addPontuacao(2)

                    } else if (rBtn_q3.isChecked) {
                        questionarioViewModel.questionario!!.addPontuacao(3)

                    } else if (rBtn_q4.isChecked) {
                        questionarioViewModel.questionario!!.addPontuacao(4)
                    }
                    questionarioViewModel.questionario!!.navegador = 2
                    findNavController().navigate(R.id.q1Fragment)
                }
            }

        }
        else if (questionarioViewModel.questionario!!.navegador == 2) {
            txtView_questao.text = questionarioViewModel.questionario!!.questoes.get(1).enunciado
            txtView_enunciado.text = questionarioViewModel.questionario!!.questoes.get(1).getqNumero()
            rBtn_q1.text = questionarioViewModel.questionario!!.questoes.get(1).respostas.get(0)
            rBtn_q2.text = questionarioViewModel.questionario!!.questoes.get(1).respostas.get(1)
            rBtn_q3.text = questionarioViewModel.questionario!!.questoes.get(1).respostas.get(2)
            rBtn_q4.text = questionarioViewModel.questionario!!.questoes.get(1).respostas.get(3)
            rBtn_q5.visibility = View.INVISIBLE
            btn_proximo.setOnClickListener {
                if (!rBtn_q1.isChecked && !rBtn_q2.isChecked && !rBtn_q3.isChecked && !rBtn_q4.isChecked) {
                    Toast.makeText(
                        activity!!.baseContext!!,
                        "Marque pelo menos uma opção",
                        Toast.LENGTH_LONG
                    ).show()
                } else {
                    if (rBtn_q1.isChecked) {
                        questionarioViewModel.questionario!!.addPontuacao(0)
                    } else if (rBtn_q2.isChecked) {
                        questionarioViewModel.questionario!!.addPontuacao(2)

                    } else if (rBtn_q3.isChecked) {
                        questionarioViewModel.questionario!!.addPontuacao(4)

                    } else if (rBtn_q4.isChecked) {
                        questionarioViewModel.questionario!!.addPontuacao(5)

                    }
                    questionarioViewModel.questionario!!.navegador = 3
                    findNavController().navigate(R.id.q1Fragment)
                }

            }


        } else if (questionarioViewModel.questionario!!.navegador == 3) {
            txtView_questao.text = questionarioViewModel.questionario!!.questoes.get(2).enunciado
            txtView_enunciado.text = questionarioViewModel.questionario!!.questoes.get(2).getqNumero()
            rBtn_q1.text = questionarioViewModel.questionario!!.questoes.get(2).respostas.get(0)
            rBtn_q2.text = questionarioViewModel.questionario!!.questoes.get(2).respostas.get(1)
            rBtn_q3.text = questionarioViewModel.questionario!!.questoes.get(2).respostas.get(2)
            rBtn_q4.text = questionarioViewModel.questionario!!.questoes.get(2).respostas.get(3)
            rBtn_q5.visibility = View.INVISIBLE
            btn_proximo.setOnClickListener {
                if (!rBtn_q1.isChecked && !rBtn_q2.isChecked && !rBtn_q3.isChecked && !rBtn_q4.isChecked) {
                    Toast.makeText(
                        activity!!.baseContext!!,
                        "Marque pelo menos uma opção",
                        Toast.LENGTH_LONG
                    ).show()
                } else {
                    if (rBtn_q1.isChecked) {
                        questionarioViewModel.questionario!!.addPontuacao(0)
                    } else if (rBtn_q2.isChecked) {
                        questionarioViewModel.questionario!!.addPontuacao(1)

                    } else if (rBtn_q3.isChecked) {
                        questionarioViewModel.questionario!!.addPontuacao(2)

                    } else if (rBtn_q4.isChecked) {
                        questionarioViewModel.questionario!!.addPontuacao(4)

                    }
                    questionarioViewModel.questionario!!.navegador = 4
                    findNavController().navigate(R.id.q1Fragment)
                }
            }

        } else if (questionarioViewModel.questionario!!.navegador == 4) {
            txtView_questao.text = questionarioViewModel.questionario!!.questoes.get(3).enunciado
            txtView_enunciado.text = questionarioViewModel.questionario!!.questoes.get(3).getqNumero()
            rBtn_q1.text = questionarioViewModel.questionario!!.questoes.get(3).respostas.get(0)
            rBtn_q2.text = questionarioViewModel.questionario!!.questoes.get(3).respostas.get(1)
            rBtn_q3.text = questionarioViewModel.questionario!!.questoes.get(3).respostas.get(2)
            rBtn_q4.visibility = View.INVISIBLE
            rBtn_q5.visibility = View.INVISIBLE
            btn_proximo.setOnClickListener {
                if (!rBtn_q1.isChecked && !rBtn_q2.isChecked && !rBtn_q3.isChecked) {
                    Toast.makeText(
                        activity!!.baseContext!!,
                        "Marque pelo menos uma opção",
                        Toast.LENGTH_LONG
                    ).show()
                } else {
                    if (rBtn_q1.isChecked) {
                        questionarioViewModel.questionario!!.addPontuacao(0)
                    } else if (rBtn_q2.isChecked) {
                        questionarioViewModel.questionario!!.addPontuacao(2)
                    } else if (rBtn_q3.isChecked) {
                        questionarioViewModel.questionario!!.addPontuacao(4)
                    }
                    questionarioViewModel.questionario!!.navegador = 5
                    findNavController().navigate(R.id.q1Fragment)

                }
            }

        } else if (questionarioViewModel.questionario!!.navegador == 5) {
            txtView_questao.text = questionarioViewModel.questionario!!.questoes.get(4).enunciado
            txtView_enunciado.text = questionarioViewModel.questionario!!.questoes.get(4).getqNumero()
            rBtn_q1.text = questionarioViewModel.questionario!!.questoes.get(4).respostas.get(0)
            rBtn_q2.text = questionarioViewModel.questionario!!.questoes.get(4).respostas.get(1)
            rBtn_q3.text = questionarioViewModel.questionario!!.questoes.get(4).respostas.get(2)
            rBtn_q4.visibility = View.INVISIBLE
            rBtn_q5.visibility = View.INVISIBLE
            btn_proximo.setOnClickListener {
                if (!rBtn_q1.isChecked && !rBtn_q2.isChecked && !rBtn_q3.isChecked) {
                    Toast.makeText(
                        activity!!.baseContext!!,
                        "Marque pelo menos uma opção",
                        Toast.LENGTH_LONG
                    ).show()
                } else {
                    if (rBtn_q1.isChecked) {
                        questionarioViewModel.questionario!!.addPontuacao(0)
                    } else if (rBtn_q2.isChecked) {
                        questionarioViewModel.questionario!!.addPontuacao(2)
                    } else if (rBtn_q3.isChecked) {
                        questionarioViewModel.questionario!!.addPontuacao(4)
                    }
                    questionarioViewModel.questionario!!.navegador = 6
                    findNavController().navigate(R.id.q1Fragment)

                }
            }

        } else if (questionarioViewModel.questionario!!.navegador == 6) {
            txtView_questao.text = questionarioViewModel.questionario!!.questoes.get(5).enunciado
            txtView_enunciado.text = questionarioViewModel.questionario!!.questoes.get(5).getqNumero()
            rBtn_q1.text = questionarioViewModel.questionario!!.questoes.get(5).respostas.get(0)
            rBtn_q2.text = questionarioViewModel.questionario!!.questoes.get(5).respostas.get(1)
            rBtn_q3.text = questionarioViewModel.questionario!!.questoes.get(5).respostas.get(2)
            rBtn_q4.text = questionarioViewModel.questionario!!.questoes.get(5).respostas.get(3)
            rBtn_q5.visibility = View.INVISIBLE
            btn_proximo.setOnClickListener {
                if (!rBtn_q1.isChecked && !rBtn_q2.isChecked && !rBtn_q3.isChecked && !rBtn_q4.isChecked) {
                    Toast.makeText(

                        activity!!.baseContext!!,
                        "Marque pelo menos uma opção",
                        Toast.LENGTH_LONG
                    ).show()
                } else {
                    if (rBtn_q1.isChecked) {
                        questionarioViewModel.questionario!!.addPontuacao(0)
                    } else if (rBtn_q2.isChecked) {
                        questionarioViewModel.questionario!!.addPontuacao(2)

                    } else if (rBtn_q3.isChecked) {
                        questionarioViewModel.questionario!!.addPontuacao(3)

                    } else if (rBtn_q4.isChecked) {
                        questionarioViewModel.questionario!!.addPontuacao(4)

                    }
                    questionarioViewModel.questionario!!.navegador = 7
                    findNavController().navigate(R.id.q1Fragment)

                }
            }

        } else if (questionarioViewModel.questionario!!.navegador == 7) {
            txtView_questao.text = questionarioViewModel.questionario!!.questoes.get(6).enunciado
            txtView_enunciado.text = questionarioViewModel.questionario!!.questoes.get(6).getqNumero()
            rBtn_q1.text = questionarioViewModel.questionario!!.questoes.get(6).respostas.get(0)
            rBtn_q2.text = questionarioViewModel.questionario!!.questoes.get(6).respostas.get(1)
            rBtn_q3.text = questionarioViewModel.questionario!!.questoes.get(6).respostas.get(2)
            rBtn_q4.text = questionarioViewModel.questionario!!.questoes.get(6).respostas.get(3)
            rBtn_q5.visibility = View.INVISIBLE
            btn_proximo.setOnClickListener {
                if (!rBtn_q1.isChecked && !rBtn_q2.isChecked && !rBtn_q3.isChecked && !rBtn_q4.isChecked) {
                    Toast.makeText(
                        activity!!.baseContext!!,
                        "Marque pelo menos uma opção",
                        Toast.LENGTH_LONG
                    ).show()
                } else {
                    if (rBtn_q1.isChecked) {
                        questionarioViewModel.questionario!!.addPontuacao(0)
                    } else if (rBtn_q2.isChecked) {
                        questionarioViewModel.questionario!!.addPontuacao(2)

                    } else if (rBtn_q3.isChecked) {
                        questionarioViewModel.questionario!!.addPontuacao(3)

                    } else if (rBtn_q4.isChecked) {
                        questionarioViewModel.questionario!!.addPontuacao(4)

                    }
                    findNavController().navigate(R.id.q1Fragment)
                    questionarioViewModel.questionario!!.navegador = 8
                }
            }


        } else if (questionarioViewModel.questionario!!.navegador == 8) {
            txtView_questao.text = questionarioViewModel.questionario!!.questoes.get(7).enunciado
            txtView_enunciado.text = questionarioViewModel.questionario!!.questoes.get(7).getqNumero()
            rBtn_q1.text = questionarioViewModel.questionario!!.questoes.get(7).respostas.get(0)
            rBtn_q2.text = questionarioViewModel.questionario!!.questoes.get(7).respostas.get(1)
            rBtn_q3.text = questionarioViewModel.questionario!!.questoes.get(7).respostas.get(2)
            rBtn_q4.text = questionarioViewModel.questionario!!.questoes.get(7).respostas.get(3)
            rBtn_q5.visibility = View.INVISIBLE
            btn_proximo.setOnClickListener {
                if (!rBtn_q1.isChecked && !rBtn_q2.isChecked && !rBtn_q3.isChecked && !rBtn_q4.isChecked) {
                    Toast.makeText(
                        activity!!.baseContext!!,
                        "Marque pelo menos uma opção",
                        Toast.LENGTH_LONG
                    ).show()
                } else {
                    if (rBtn_q1.isChecked) {
                        questionarioViewModel.questionario!!.addPontuacao(0)
                    } else if (rBtn_q2.isChecked) {
                        questionarioViewModel.questionario!!.addPontuacao(1)

                    } else if (rBtn_q3.isChecked) {
                        questionarioViewModel.questionario!!.addPontuacao(2)

                    } else if (rBtn_q4.isChecked) {
                        questionarioViewModel.questionario!!.addPontuacao(4)

                    }
                    findNavController().navigate(R.id.q1Fragment)
                    questionarioViewModel.questionario!!.navegador = 9

                }
            }

        } else if (questionarioViewModel.questionario!!.navegador == 9) {
            txtView_questao.text = questionarioViewModel.questionario!!.questoes.get(8).enunciado
            txtView_enunciado.text =
                questionarioViewModel.questionario!!.questoes.get(8).getqNumero()
            rBtn_q1.text = questionarioViewModel.questionario!!.questoes.get(8).respostas.get(0)
            rBtn_q2.text = questionarioViewModel.questionario!!.questoes.get(8).respostas.get(1)
            rBtn_q3.text = questionarioViewModel.questionario!!.questoes.get(8).respostas.get(2)
            rBtn_q4.text = questionarioViewModel.questionario!!.questoes.get(8).respostas.get(3)
            rBtn_q5.text = questionarioViewModel.questionario!!.questoes.get(8).respostas.get(4)
            btn_proximo.setOnClickListener {
                if (!rBtn_q1.isChecked && !rBtn_q2.isChecked && !rBtn_q3.isChecked && !rBtn_q4.isChecked && !rBtn_q5.isChecked) {
                    Toast.makeText(
                        activity!!.baseContext!!,
                        "Marque pelo menos uma opção",
                        Toast.LENGTH_LONG
                    ).show()
                } else {
                    if (rBtn_q1.isChecked) {
                        questionarioViewModel.questionario!!.addPontuacao(0)

                    } else if (rBtn_q2.isChecked) {
                        questionarioViewModel.questionario!!.addPontuacao(1)

                    } else if (rBtn_q3.isChecked) {
                        questionarioViewModel.questionario!!.addPontuacao(2)

                    } else if (rBtn_q4.isChecked) {
                        questionarioViewModel.questionario!!.addPontuacao(4)

                    } else if (rBtn_q5.isChecked) {
                        questionarioViewModel.questionario!!.addPontuacao(5)

                    }
                    val intent = Intent(activity!!.baseContext, PontuacaoActivity::class.java)
                    intent.putExtra("respostas", questionarioViewModel.questionario!!.pontuacao)
                    intent.putExtra("cliente", questionarioViewModel.questionario!!.perfil)
                    startActivity(intent)
                }

            }
        }


        }
    }




