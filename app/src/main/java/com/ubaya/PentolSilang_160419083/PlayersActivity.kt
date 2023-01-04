package com.ubaya.PentolSilang_160419083

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_players.*

class PlayersActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_players)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, GlobalData.color)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerCP1.adapter = adapter
        spinnerCP2.adapter = adapter

        buttonPlay.setOnClickListener {
            GlobalData.player1 = editPlayer1.text.toString()
            GlobalData.player2 = editPlayer2.text.toString()
            GlobalData.cPlayer1 = spinnerCP1.selectedItem.toString()
            GlobalData.cPlayer2 = spinnerCP2.selectedItem.toString()

            if(!GlobalData.player1.equals("") || !GlobalData.player2.equals("")){
                if(GlobalData.cPlayer1 == GlobalData.cPlayer2){
                    AlertDialog.Builder(this).run {
                        setTitle("Warning!")
                        setMessage("Player's color can't be same!")
                        setPositiveButton("OK",null)
                        create().show()
                    }
                }
                else{
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
            }else{
                AlertDialog.Builder(this).run {
                    setTitle("Warning!")
                    setMessage("Player name can't be empty!")
                    setPositiveButton("OK",null)
                    create().show()
                }
            }
        }
    }
}