package com.derrick.park.recyclerviewdemo

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.kittinunf.fuel.Fuel

// RecyclerView
// - Data : Array<SWChar> (v)
// - RecyclerView.Adapter
// - RecyclerView.ViewHolder - layout (v)
// - LayoutManager - LinearLayoutManager, GridLayoutManager, ...

class MainActivity : AppCompatActivity(), OnSWClickListener {
    companion object {
        const val NAME_EXTRA = "NAME"
        const val HEIGHT_EXTRA = "HEIGHT"
        const val MASS_EXTRA = "MASS"
        const val EYE_EXTRA = "EYE"
        const val GENDER_EXTRA = "GENDER"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.swRecyclerView)
        // android
        Fuel.get("https://swapi.co/api/people/")
            .responseObject(Data.Deserializer()) { _, _, result ->
                val (data, _) = result
                // We have to notify the recyclerView that
                // we received all data (done!)
                data?.let {
                    val swChars = it.results
                    val adapter = SWAdapter(this, swChars)
                    // 1. set the layout manager
                    recyclerView.layoutManager = LinearLayoutManager(this)
                    // 2. set adapter
                    recyclerView.adapter = adapter
                }
            }
    }

    override fun onClick(v: View, item: SWChar) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(NAME_EXTRA, item.name)
        intent.putExtra(HEIGHT_EXTRA, item.height)
        intent.putExtra(MASS_EXTRA, item.mass)
        intent.putExtra(EYE_EXTRA, item.eye_color)
        intent.putExtra(GENDER_EXTRA, item.gender)

        startActivity(intent)
    }
}
