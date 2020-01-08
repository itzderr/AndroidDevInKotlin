package com.derrick.park.recyclerviewdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.derrick.park.recyclerviewdemo.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)

        val name = intent.getStringExtra(MainActivity.NAME_EXTRA)
        val height = intent.getIntExtra(MainActivity.HEIGHT_EXTRA, 0)
        val mass = intent.getIntExtra(MainActivity.MASS_EXTRA, 0)
        val eye = intent.getStringExtra(MainActivity.EYE_EXTRA)
        val gender = intent.getStringExtra(MainActivity.GENDER_EXTRA)

        binding.apply {
            nameTextView.text = name
            heightTextView.text = "Height: $height"
            massTextView.text = "Mass: $mass"
            eyeTextView.text = "Eye Color: $eye"
            genderTextView.text = "Gender: $gender"
        }
    }
}
