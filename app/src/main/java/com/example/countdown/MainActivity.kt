package com.example.countdown

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val initialTime:Long=1500000
        var millis:Long=initialTime
        val countdown =object : CountDownTimer(millis, 1000){
            override fun onTick(time: Long) {
                millis=time
                val minutes =millis.toInt()/1000/60
                val seconds =millis.toInt()/1000%60
                val timeleft = String.format("%02d:%02d",minutes,seconds)
                timerTextView.setText(timeleft)

            }

            override fun onFinish() {
                timerTextView.text = "done"
            }

        }
        startButton.setOnClickListener{
            countdown.start()
        }
        resetButton.setOnClickListener{
            countdown.cancel()
            val minutes =initialTime.toInt()/1000/60
            val seconds =initialTime.toInt()/1000%60
            val timeleft = String.format("%02d:%02d",minutes,seconds)
            timerTextView.setText(timeleft)

        }

    }
}