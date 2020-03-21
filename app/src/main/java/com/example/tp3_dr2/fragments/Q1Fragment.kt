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
import kotlinx.android.synthetic.main.fragment_q1.btn_anterior
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
        if (questionarioViewModel.questionario!!.navegador == 1) {
            txtView_questao.text = "Questão 1"
            txtView_enunciado.text = "Por quanto tempo você pretende deixar seu dinheiro investido?"
            rBtn_q1.text = "Menos de 6 meses"
            rBtn_q2.text = "Entre 6 meses e 1 ano"
            rBtn_q3.text = "Entre 1 ano e 6 anos"
            rBtn_q4.text = "Acima de 3 anos"
            rBtn_q5.visibility = View.INVISIBLE
            btn_proximo.setOnClickListener {
                if (!rBtn_q1.isChecked && !rBtn_q2.isChecked && !rBtn_q3.isChecked && !rBtn_q4.isChecked) {
                    Toast.makeText(
                        activity!!.baseContext!!,
                        "Marque todas opções",
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
            btn_anterior.setOnClickListener {
                activity!!.finish()
            }
        } else if (questionarioViewModel.questionario!!.navegador == 2) {
            txtView_questao.text = "Questão 2"
            txtView_enunciado.text = "Qual objetivo desse investimento?"
            rBtn_q1.text =
                "Preservação do capital para não perder valor ao longo do tempo, assumindo baixos riscos de perdas"
            rBtn_q2.text =
                "Aumento gradual do capital ao longo do tempo, assumindo riscos moderados"
            rBtn_q3.text =
                "Aumento do capital acima da taxa de retorno média do mercado, mesmo que isso implique assumir riscos de perdas elevadas"
            rBtn_q4.text =
                "Obter no curto prazo retornos elevados e significativamente acima da taxa de retorno média do mercado, assumindo riscos elevados"
            rBtn_q5.visibility = View.INVISIBLE
            btn_proximo.setOnClickListener {
                if (!rBtn_q1.isChecked && !rBtn_q2.isChecked && !rBtn_q3.isChecked && !rBtn_q4.isChecked) {
                    Toast.makeText(
                        activity!!.baseContext!!,
                        "Marque todas opções",
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
            btn_anterior.setOnClickListener {
                questionarioViewModel.questionario!!.navegador -= 1
                questionarioViewModel.questionario!!.removePontuacao()
                findNavController().navigate(R.id.q1Fragment)
            }

        } else if (questionarioViewModel.questionario!!.navegador == 3) {
            txtView_questao.text = "Questão 3"
            txtView_enunciado.text =
                "Qual das alternativas melhor classifica sua formação e experiência com o mercado financeiro?"
            rBtn_q1.text = "Não possuo formação acadêmica ou conhecimento do mercado financeiro"
            rBtn_q2.text =
                "Possuo formação acadêmica na área financeira mas não tenho experiência com o mercado financeiro"
            rBtn_q3.text =
                "Possuo formação acadêmica em outra área, mas possuo conhecimento do mercado financeiro"
            rBtn_q4.text =
                "Possuo formação acadêmica na área financeira ou pleno conhecimento do mercado financeiro"
            rBtn_q5.visibility = View.INVISIBLE
            btn_proximo.setOnClickListener {
                if (!rBtn_q1.isChecked && !rBtn_q2.isChecked && !rBtn_q3.isChecked && !rBtn_q4.isChecked) {
                    Toast.makeText(
                        activity!!.baseContext!!,
                        "Marque todas opções",
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
            btn_anterior.setOnClickListener {
                questionarioViewModel.questionario!!.navegador -= 1
                questionarioViewModel.questionario!!.removePontuacao()
                findNavController().navigate(R.id.q1Fragment)
            }
        } else if (questionarioViewModel.questionario!!.navegador == 4) {
            txtView_questao.text = "Questão 4"
            txtView_enunciado.text =
                "Considerando seus rendimentos regulares, qual a porcentagem você pretende reservar para aplicações financeiras?"
            rBtn_q1.text = "No máximo 25% "
            rBtn_q2.text = "Entre 25.01% e 50%"
            rBtn_q3.text = "Acima de 50%"
            rBtn_q4.visibility = View.INVISIBLE
            rBtn_q5.visibility = View.INVISIBLE
            btn_proximo.setOnClickListener {
                if (!rBtn_q1.isChecked && !rBtn_q2.isChecked && !rBtn_q3.isChecked) {
                    Toast.makeText(
                        activity!!.baseContext!!,
                        "Marque todas opções",
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
            btn_anterior.setOnClickListener {
                questionarioViewModel.questionario!!.navegador -= 1
                questionarioViewModel.questionario!!.removePontuacao()
                findNavController().navigate(R.id.q1Fragment)
            }
        } else if (questionarioViewModel.questionario!!.navegador == 5) {
            txtView_questao.text = "Questão 5"
            txtView_enunciado.text =
                "Caso as suas aplicações sofressem uma queda superior a 30%, o que você faria?"
            rBtn_q1.text = "Resgataria toda a aplicação e aplicaria na poupança "
            rBtn_q2.text = "Manteria aplicação aguardando uma melhora do mercado "
            rBtn_q3.text = "Aumentaria a aplicação para aproveitar as oportunidades do mercado"
            rBtn_q4.visibility = View.INVISIBLE
            rBtn_q5.visibility = View.INVISIBLE
            btn_proximo.setOnClickListener {
                if (!rBtn_q1.isChecked && !rBtn_q2.isChecked && !rBtn_q3.isChecked) {
                    Toast.makeText(
                        activity!!.baseContext!!,
                        "Marque todas opções",
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
            btn_anterior.setOnClickListener {
                questionarioViewModel.questionario!!.navegador -= 1
                questionarioViewModel.questionario!!.removePontuacao()
                findNavController().navigate(R.id.q1Fragment)
            }
        } else if (questionarioViewModel.questionario!!.navegador == 6) {
            txtView_questao.text = "Questão 6"
            txtView_enunciado.text = "Como está distribuido seu patrimônio?"
            rBtn_q1.text =
                "Meu patrimônio não está aplicado ou está todo aplicado em renda fixa e/ou imóveis"
            rBtn_q2.text = "Menos de 25% em renda variável e o restante em renda fixa e/ou imóveis"
            rBtn_q3.text =
                "Entre 25,01 e 50% aplicado em renda variável e o restante em renda fixa e/ou imóveis"
            rBtn_q4.text = "Acima de 50% em renda variável"
            rBtn_q5.visibility = View.INVISIBLE
            btn_proximo.setOnClickListener {
                if (!rBtn_q1.isChecked && !rBtn_q2.isChecked && !rBtn_q3.isChecked && !rBtn_q4.isChecked) {
                    Toast.makeText(

                        activity!!.baseContext!!,
                        "Marque todas opções",
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
            btn_anterior.setOnClickListener {
                questionarioViewModel.questionario!!.navegador -= 1
                questionarioViewModel.questionario!!.removePontuacao()
                findNavController().navigate(R.id.q1Fragment)
            }
        } else if (questionarioViewModel.questionario!!.navegador == 7) {
            txtView_questao.text = "Questão 7"
            txtView_enunciado.text =
                "Em relação as aplicações e rendimentos, em qual dessas situações você se enquadra?"
            rBtn_q1.text =
                "Conto com o rendimento dessas aplicações para complementar minha renda mensal"
            rBtn_q2.text =
                "Eventualmente posso resgatar parte das aplicações para fazer frente aos meus gastos. " +
                        "Contudo, não tenho intenção de resgatar no curto prazo e pretendo fazer aplicações regulares"
            rBtn_q3.text =
                "Não tenho intenção de resgatar no curto prazo, mas não pretendo realizar novas aplicações"
            rBtn_q4.text =
                "Não tenho intenção de resgatar no curto prazo e ainda pretendo fazer aplicações regulares"
            rBtn_q5.visibility = View.INVISIBLE
            btn_proximo.setOnClickListener {
                if (!rBtn_q1.isChecked && !rBtn_q2.isChecked && !rBtn_q3.isChecked && !rBtn_q4.isChecked) {
                    Toast.makeText(
                        activity!!.baseContext!!,
                        "Marque todas opções",
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

            btn_anterior.setOnClickListener {
                questionarioViewModel.questionario!!.navegador -= 1
                questionarioViewModel.questionario!!.removePontuacao()
                findNavController().navigate(R.id.q1Fragment)
            }
        } else if (questionarioViewModel.questionario!!.navegador == 8) {
            txtView_questao.text = "Questão 8"
            txtView_enunciado.text = "Qual sua renda mensal média"
            rBtn_q1.text = "Até R$1000"
            rBtn_q2.text = "De R$1001 até R$5000"
            rBtn_q3.text = "De R$5001 até R$10000"
            rBtn_q4.text = "Acima de R$10000"
            rBtn_q5.visibility = View.INVISIBLE
            btn_proximo.setOnClickListener {
                if (!rBtn_q1.isChecked && !rBtn_q2.isChecked && !rBtn_q3.isChecked && !rBtn_q4.isChecked) {
                    Toast.makeText(
                        activity!!.baseContext!!,
                        "Marque todas opções",
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
            btn_anterior.setOnClickListener {
                questionarioViewModel.questionario!!.navegador -= 1
                questionarioViewModel.questionario!!.removePontuacao()
                findNavController().navigate(R.id.q1Fragment)
            }
        } else if (questionarioViewModel.questionario!!.navegador == 9) {
            txtView_questao.text = "Questão 9"
            txtView_enunciado.text = "Qual valor aproximado do seu patrimonio"
            rBtn_q1.text = "Até R$10000"
            rBtn_q2.text = "De R$ 10.001 até R$ 100.000"
            rBtn_q3.text = "De R$ 100.001 até R$ 500.000"
            rBtn_q4.text = "De R$ 500.001 até R$ 1.000.000"
            rBtn_q5.text = "Acima de R$ 1.000.001"

            btn_proximo.setOnClickListener {
                if (!rBtn_q1.isChecked && !rBtn_q2.isChecked && !rBtn_q3.isChecked && !rBtn_q4.isChecked && !rBtn_q5.isChecked) {
                    Toast.makeText(
                        activity!!.baseContext!!,
                        "Marque todas opções",
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
                    var respostas = questionarioViewModel.questionario!!.pontuacao
                    var cliente = questionarioViewModel.questionario!!.perfil
                    intent.putExtra("respostas", respostas)
                    intent.putExtra("cliente", cliente)
                    startActivity(intent)
                }

            }
            btn_anterior.setOnClickListener {
                questionarioViewModel.questionario!!.navegador -= 1
                questionarioViewModel.questionario!!.removePontuacao()
                findNavController().navigate(R.id.q1Fragment)
            }

        }
    }

}


