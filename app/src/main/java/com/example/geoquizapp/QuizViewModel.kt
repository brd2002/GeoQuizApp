package com.example.geoquizapp

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class QuizViewModel(saveStateHandle: SavedStateHandle) : ViewModel() {
    val question_bank = listOf<Question>(
        Question(R.string.Question_dog , false),
        Question(R.string.Question_cow , true),
        Question(R.string.Question_duck , false),
        Question(R.string.Question_phone , false)
    )
    var currentIndex = 0
    val currentQuestionAnswer: Boolean
        get() = question_bank[currentIndex].answer
    val currentQuestionText: Int
        get() = question_bank[currentIndex].textResId
    fun moveToNext(){
        currentIndex = (currentIndex + 1) % question_bank.size
    }
}