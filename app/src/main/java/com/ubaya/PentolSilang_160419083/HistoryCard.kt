package com.ubaya.PentolSilang_160419083

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.history_card.*

class HistoryCard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.history_card)

        if(GlobalData.menang == "O"){
            textPlayerHistory1.text = "Player 1 : ${GlobalData.player1} WIN"
            textPlayerHistory1.text = "Player 2 : ${GlobalData.player2}"

        }else if(GlobalData.menang == "X"){
            textPlayerHistory1.text = "Player 1 : ${GlobalData.player1}"
            textPlayerHistory1.text = "Player 2 : ${GlobalData.player2} WIN"
        }else{
            textPlayerHistory1.text = "Player 1 : ${GlobalData.player1} DRAW"
            textPlayerHistory1.text = "Player 2 : ${GlobalData.player2} DRAW"
        }
        textPlayerHistory1.setBackgroundColor(Color.parseColor(GlobalData.cPlayer1))
        textPlayerHistory2.setBackgroundColor(Color.parseColor(GlobalData.cPlayer2))
    }
}