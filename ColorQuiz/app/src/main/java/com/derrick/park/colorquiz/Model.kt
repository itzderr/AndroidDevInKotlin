package com.derrick.park.colorquiz

import android.graphics.Color.*
import kotlin.random.Random

class ColorQuestion(val leftColor: Int, val rightColor: Int, val isLeftAnswer: Boolean, val questionStr: String)

class QuestionManager {
    private val questionList = listOf(
        BLACK to "Black", BLUE to "Blue", DKGRAY to "Dark Gray", WHITE to "White", YELLOW to "Yellow",
        GREEN to "Green", GRAY to "Gray", MAGENTA to "Magenta", CYAN to "Cyan", RED to "Red"
    )

    val getQuestion: ColorQuestion
        get() {
            val rand = Random(System.currentTimeMillis())
            val l = rand.nextInt(questionList.size)
            var r: Int
            do {
                r = rand.nextInt(questionList.size)
            } while (l == r)

            val isLeft = rand.nextInt(2).toBool()
            val qStr = if (isLeft) questionList[l].second else questionList[r].second
            return ColorQuestion(questionList[l].first, questionList[r].first, isLeft, qStr)
        }
}

private fun Int.toBool() = this != 0

