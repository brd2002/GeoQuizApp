package com.example.geoquizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.geoquizapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityMainBinding
    var currentIndex = 0
    val question_bank = listOf<Question>(
        Question(R.string.Question_dog , false),
        Question(R.string.Question_cow , true),
        Question(R.string.Question_duck , false),
        Question(R.string.Question_phone , false)
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        val true_button = findViewById<Button>(R.id.true_button)
//        val false_button = findViewById<Button>(R.id.false_button)


//        val questionTextResId = question_bank[currentIndex].textResId
//        binding.questionTextView.setText(questionTextResId)
        binding.trueButton.setOnClickListener {
//            Toast.makeText(this , R.string.correct_toast , Toast.LENGTH_SHORT).show()
            checkAnswer(true)
        }
        binding.falseButton.setOnClickListener {
//            Toast.makeText(this , R.string.incorrect_toast , Toast.LENGTH_SHORT).show()
            checkAnswer(false)
        }
        binding.nextButton.setOnClickListener {
         updateQuestion()
        }
        updateQuestion()

    }
    private fun updateQuestion() {
        currentIndex = (currentIndex + 1) % question_bank.size
        val questionTextResId = question_bank[currentIndex].textResId
        binding.questionTextView.setText(questionTextResId)
    }
    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = question_bank[currentIndex].answer
        val messageResId = if (userAnswer == correctAnswer) {
            R.string.correct_toast
        } else {
            R.string.incorrect_toast
        }
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT)
            .show()
    }
}