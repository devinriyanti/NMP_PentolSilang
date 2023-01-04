package com.ubaya.PentolSilang_160419083

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_history.*

class HistoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        val lm = LinearLayoutManager(this)
        with(recyclerView){
            layoutManager = lm
            setHasFixedSize(true)
            adapter = HistoryAdapter()
        }
    }
}