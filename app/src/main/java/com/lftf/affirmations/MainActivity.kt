package com.lftf.affirmations

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.lftf.affirmations.adapter.ItemAdapter
import com.lftf.affirmations.data.Datasource

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myDataset = Datasource().loadAffirmations()
        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)

        val adapter = ItemAdapter(this, myDataset)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter
    }
}