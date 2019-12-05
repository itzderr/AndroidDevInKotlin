package com.derrick.park.diceroller

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var diceImage1: ImageView
    lateinit var diceImage2: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        diceImage1 = findViewById(R.id.dice_image1)
        diceImage2 = findViewById(R.id.dice_image2)
    }

    private fun getRandomDiceImage(randomInt: Int): Int {
        val img = when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        return img
    }

    fun rollDice(view: View) {
        val randomInt1 = Random().nextInt(6) + 1
        val randomInt2 = Random().nextInt(6) + 1

        val img1 = getRandomDiceImage(randomInt1)
        val img2 = getRandomDiceImage(randomInt2)
        diceImage1.setImageResource(img1)
        diceImage2.setImageResource(img2)
    }
}
