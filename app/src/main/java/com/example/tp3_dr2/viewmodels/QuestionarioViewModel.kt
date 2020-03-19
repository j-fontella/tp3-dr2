package com.example.tp3_dr2.viewmodels

import androidx.lifecycle.ViewModel
import com.example.tp3_dr2.models.Questionario

class QuestionarioViewModel : ViewModel() {
    var questionario : Questionario? = Questionario("null")
}