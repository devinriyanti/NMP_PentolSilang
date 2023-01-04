package com.ubaya.PentolSilang_160419083

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.history_card.view.*

class HistoryAdapter() : RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {
    class HistoryViewHolder(val view:View):RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.history_card,parent,false)
        return HistoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        val history = GlobalData.History[position]
        with(holder.view){
            textSession.text = "Game Session #${history.gameSession}"
            textDate.text = history.tanggal
            if(history.menang == "O"){
                textPlayerHistory1.text = "Player 1 : ${history.player1} WIN"
                textPlayerHistory2.text = "Player 2 : ${history.player2}"
            }else if(history.menang == "X"){
                textPlayerHistory1.text = "Player 1 : ${history.player1}"
                textPlayerHistory2.text = "Player 2 : ${history.player2} WIN"
            }else{
                textPlayerHistory1.text = "Player 1 : ${history.player1} DRAW"
                textPlayerHistory2.text = "Player 2 : ${history.player2} DRAW"
            }

            textPlayerHistory1.setBackgroundColor(Color.parseColor(history.cPlayer1))
            textPlayerHistory2.setBackgroundColor(Color.parseColor(history.cPlayer2))
        }
    }

    override fun getItemCount(): Int {
        return GlobalData.History.size
    }
}