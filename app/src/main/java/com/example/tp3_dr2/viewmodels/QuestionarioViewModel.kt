package com.example.tp3_dr2.viewmodels

import androidx.lifecycle.ViewModel
import com.example.tp3_dr2.models.Questionario
import java.io.Serializable

class QuestionarioViewModel : ViewModel(), Serializable {
    var questionario : Questionario? = Questionario("null")
}