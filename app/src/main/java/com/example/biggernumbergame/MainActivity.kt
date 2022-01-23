package com.example.biggernumbergame

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.biggernumbergame.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        assignNumbersToButtons()

        binding.btnLeft.setOnClickListener {
            //code here will run everytime left button is clicked

            //1. Compare the number in the buttons
            checkAnswer(true)
            //2. Pick new random numbers
            assignNumbersToButtons()
        }

        binding.btnRight.setOnClickListener {
            //code here will run everytime left button is clicked

            //1. Compare the number in the buttons
            checkAnswer(false)
            //2. Pick new random numbers
            assignNumbersToButtons()
        }
    }

    private fun checkAnswer(isLeftButtonSelected: Boolean) {
        val leftNum = binding.btnLeft.text.toString().toInt()
        val rightNum = binding.btnRight.text.toString().toInt()

        //Ternary Statement
        val isAnswerCorrect = if(isLeftButtonSelected) leftNum > rightNum else rightNum > leftNum

        if (isAnswerCorrect) {
            //Correct answer!
            //Change background color
            binding.backgroundView.setBackgroundColor(Color.GREEN)
            //Show a notification (called toast in Android)
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
        } else {
            //Wrong answer!
            //Change background color
            binding.backgroundView.setBackgroundColor(Color.RED)
            //Show a notification (called toast in Android)
            Toast.makeText(this, "Wrong!", Toast.LENGTH_SHORT).show()
        }
    }


    private fun assignNumbersToButtons() {
        val r = Random()
        val leftNum: Int  = r.nextInt(10)

        var rightNum = leftNum
        while (rightNum == leftNum) {
            rightNum = r.nextInt(10)
        }

        binding.apply {
            btnLeft.text = leftNum.toString()
            btnRight.text = rightNum.toString()
        }
    }
}