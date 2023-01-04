package com.ubaya.PentolSilang_160419083

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.core.graphics.toColorInt
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_result.*
import java.text.DateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textPlayer1.text = GlobalData.player1.toString() + " (O)"
        textPlayer2.text = GlobalData.player2.toString()+ " (X)"
        textTurnP1.text = "YOUR TURN"
        cardPlayer1.setBackgroundColor(Color.parseColor(GlobalData.cPlayer1))
        cardPlayer2.setBackgroundColor(Color.parseColor(GlobalData.cPlayer2))
    }

    override fun onBackPressed() {
            AlertDialog.Builder(this).run{
            setTitle("Exit Game")
            setMessage("Are you sure want to quit this game?")
            setPositiveButton("QUIT") { _, _ ->
                var intent = Intent(this@MainActivity,PlayersActivity::class.java)
                startActivity(intent)
            }
            setNegativeButton("KEEP PLAYING",null)
            create().show()
        }
    }

    fun btnClick(view:View){
        val btnSelected = view as Button
        var id = 0
        when(btnSelected.id){
            R.id.b1->id = 1
            R.id.b2->id = 2
            R.id.b3->id = 3
            R.id.b4->id = 4
            R.id.b5->id = 5
            R.id.b6->id = 6
            R.id.b7->id = 7
            R.id.b8->id = 8
            R.id.b9->id = 9
        }
        inGame(id,btnSelected)
    }
    var player1 = arrayListOf<Int>();
    var player2 = arrayListOf<Int>();
    var active = 1;


    private fun inGame(id: Int, btnSelected: Button) {
        if(active == 1){
            btnSelected.text = "O";
            textTurnP1.text = ""
            textTurnP2.text = "${GlobalData.player1.toUpperCase()}'S TURN"
            btnSelected.setBackgroundColor(Color.parseColor(GlobalData.cPlayer1.toString()))
            player1.add(id)
            active = 2
        }else{
            btnSelected.text = "X";
            textTurnP1.text = "YOUR TURN"
            textTurnP2.text = ""
            btnSelected.setBackgroundColor(Color.parseColor(GlobalData.cPlayer2.toString()))
            player2.add(id)
            active = 1
        }
        btnSelected.isEnabled = false
        cekPemenang()
    }

    private fun cekPemenang() {
        var menang = "win"
        //Cek Player 1 (O)
        if(b1.text == "O" && b2.text == "O" && b3.text == "O") menang = "O"
        if(b4.text == "O" && b5.text == "O" && b6.text == "O") menang = "O"
        if(b7.text == "O" && b8.text == "O" && b9.text == "O") menang = "O"
        if(b1.text == "O" && b4.text == "O" && b7.text == "O") menang = "O"
        if(b2.text == "O" && b5.text == "O" && b8.text == "O") menang = "O"
        if(b3.text == "O" && b6.text == "O" && b9.text == "O") menang = "O"
        if(b1.text == "O" && b5.text == "O" && b9.text == "O") menang = "O"
        if(b3.text == "O" && b5.text == "O" && b7.text == "O") menang = "O"

        //Cek player 2 (X)
        if(b1.text == "X" && b2.text == "X" && b3.text == "X") menang = "X"
        if(b4.text == "X" && b5.text == "X" && b6.text == "X") menang = "X"
        if(b7.text == "X" && b8.text == "X" && b9.text == "X") menang = "X"
        if(b1.text == "X" && b4.text == "X" && b7.text == "X") menang = "X"
        if(b2.text == "X" && b5.text == "X" && b8.text == "X") menang = "X"
        if(b3.text == "X" && b6.text == "X" && b9.text == "X") menang = "X"
        if(b1.text == "X" && b5.text == "X" && b9.text == "X") menang = "X"
        if(b3.text == "X" && b5.text == "X" && b7.text == "X") menang = "X"

        var intent = Intent(this,ResultActivity::class.java)
        if(menang != "win"){
            if(menang == "O"){
                GlobalData.menang = "O"
                GlobalData.gameSession++
                GlobalData.History.add(
                    History(
                        GlobalData.player1,GlobalData.player2,GlobalData.cPlayer1,
                        GlobalData.cPlayer2,GlobalData.menang, GlobalData.gameSession,Calendar.getInstance().time.toString()
                    )
                )
                AlertDialog.Builder(this).run {
                    setTitle("GAME OVER!")
                    setMessage("${GlobalData.player1.toString()} Wins!")
                    setPositiveButton("HOORAY!"){_,_->
                        startActivity(intent)
                    }
                    create().show()
                }
            }else if(menang == "X"){
                GlobalData.menang = "X"
                GlobalData.gameSession++
                GlobalData.History.add(
                    History(
                        GlobalData.player1,GlobalData.player2,GlobalData.cPlayer1,
                        GlobalData.cPlayer2,GlobalData.menang, GlobalData.gameSession,Calendar.getInstance().time.toString()
                    )
                )
                AlertDialog.Builder(this).run {
                    setTitle("GAME OVER!")
                    setMessage("${GlobalData.player2.toString()} Wins!")
                    setPositiveButton("HOORAY!"){_,_->
                        startActivity(intent)
                    }
                    create().show()
                }
            }
        }else if(player1.size + player2.size == 9){
            GlobalData.menang = "draw"
            GlobalData.gameSession++
            GlobalData.History.add(
                History(
                    GlobalData.player1,GlobalData.player2,GlobalData.cPlayer1,
                    GlobalData.cPlayer2,GlobalData.menang, GlobalData.gameSession,Calendar.getInstance().time.toString()
                )
            )
            AlertDialog.Builder(this).run {
                setTitle("GAME OVER!")
                setMessage("Game draw!")
                setPositiveButton("OH NO..."){_,_->
                    startActivity(intent)
                }
                create().show()
            }
        }
    }


}