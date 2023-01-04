package com.ubaya.PentolSilang_160419083

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.graphics.toColorInt
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        textPlayName1.text = GlobalData.player1 + " (O)"
        textPlayName2.text = GlobalData.player2 + " (X)"

        cardResultPlayer1.setBackgroundColor(Color.parseColor(GlobalData.cPlayer1))
        cardResultPlayer2.setBackgroundColor(Color.parseColor(GlobalData.cPlayer2))

        if(GlobalData.menang == "O"){
            textPlayerResult1.text = "YOU WIN"
            textPlayerResult2.text = "YOU LOSE"
        }else if(GlobalData.menang == "X"){
            textPlayerResult2.text = "YOU WIN"
            textPlayerResult1.text = "YOU LOSE"
        }else{
            textPlayerResult2.text = "GAME DRAW"
            textPlayerResult1.text = "GAME DRAW"
        }

        buttonHistory.setOnClickListener {
            var intent = Intent(this,HistoryActivity::class.java)
            startActivity(intent)
        }
        buttonPlayAgain.setOnClickListener {
            var intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}