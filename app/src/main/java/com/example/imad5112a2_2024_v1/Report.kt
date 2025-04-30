package com.example.imad5112a2_2024_v1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Report : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report)


        val reportTextView = findViewById<TextView>(R.id.reportTextView)

        val bundle: Bundle? = intent.extras
        val days = bundle?.getStringArray("daysArray")
        val grams = bundle?.getIntArray("gramsArray")


        var total = 0

        if (days != null) {
            for (i in days.indices) {
                total = total+grams[i]
            }
        }

        reportTextView.text = "Total: $total grams fed this week."
    }
}