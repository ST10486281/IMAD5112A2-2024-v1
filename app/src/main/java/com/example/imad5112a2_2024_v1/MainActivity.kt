package com.example.imad5112a2_2024_v1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

private val days = arrayOf<String>(
    "Monday", "Tuesday", "Wednesday", "Thursday",
    "Friday", "Saturday", "Sunday"
)

private val grams = arrayOf<Int>(0, 0, 0, 0, 0, 0, 0)
private var currentIndex = 0

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val dayTextView = findViewById<TextView>(R.id.dayTextView)
        val inputEditText = findViewById<EditText>(R.id.editTextGrams)
        val nextButton = findViewById<Button>(R.id.nextButton)

        dayTextView.text = "Enter grams of food for: ${days[currentIndex]}"

        nextButton.setOnClickListener {
            val input = inputEditText.text.toString()
            val value = input.toIntOrNull()

            if (value != null) {
                grams[currentIndex] = value
                currentIndex++

                if (currentIndex < 7) {
                    dayTextView.text = "Enter grams of food for: ${days[currentIndex]}"
                    inputEditText.text.clear()
                } else {
                    // All days done, go to report screen
                    val intent = Intent(this, Report::class.java)
                    intent.putExtra("daysArray", days)
                    intent.putExtra("gramsArray", grams.toIntArray()) // convert to primitive array
                    startActivity(intent)
                }
            } else {
                inputEditText.error = "Please enter a number"
            }
        }


    }
}