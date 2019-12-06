package com.derrick.park.colorquiz

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val scoreTextView: TextView by bind(R.id.score_tv)
    private val leftBtn: Button by bind(R.id.left_btn)
    private val rightBtn: Button by bind(R.id.right_btn)
    private val questionTextView: TextView by bind(R.id.question_tv)

    private val questionManager = QuestionManager()
    private lateinit var question: ColorQuestion
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        updateUI()
    }

    private fun updateUI() {
        question = questionManager.getQuestion
        leftBtn.setBackgroundColor(question.leftColor)
        rightBtn.setBackgroundColor(question.rightColor)
        questionTextView.text = question.questionStr
        scoreTextView.text = "Score: $score"
    }

    fun buttonTapped(view: View) {
        val btn = view as Button
        when (btn.id) {
            R.id.left_btn -> showAnswer(question.isLeftAnswer)
            R.id.right_btn -> showAnswer(!question.isLeftAnswer)
        }
        updateUI()
    }

    private fun showAnswer(isAnswer: Boolean) {
        when {
            isAnswer -> {
                ++score
                toast("Right!")
            }
            else -> {
                --score
                toast("Wrong!")
            }
        }
    }

    private fun toast(message: String) = Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

}

fun <T: View> AppCompatActivity.bind(@IdRes res: Int): Lazy<T> {
    @Suppress("UNCHECKED_CAST")
    return lazy { findViewById<T>(res) }
}
