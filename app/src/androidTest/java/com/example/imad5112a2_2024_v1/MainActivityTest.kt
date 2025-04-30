package com.example.imad5112a2_2024_v1

import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    private lateinit var scenario: ActivityScenario<MainActivity>

    @Before
    fun setup() {
        scenario = ActivityScenario.launch(MainActivity::class.java)
    }

    @Test
    fun testInputAndDayLabelUpdate() {
        scenario.onActivity { activity ->
            val editText = activity.findViewById<EditText>(R.id.editTextGrams)
            val button = activity.findViewById<Button>(R.id.nextButton)
            val dayLabel = activity.findViewById<TextView>(R.id.dayTextView)

            editText.setText("100")
            button.performClick()

            // After one click, the label should now show Tuesday
            assertTrue(dayLabel.text.contains("Tuesday"))
        }
    }
}
