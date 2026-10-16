package com.comp3074.assignment1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Display the calculator screen
        setContentView(R.layout.activity_main)

        // Connect the input boxes, buttons, and result text
        val hoursInput = findViewById<EditText>(R.id.hoursInput)
        val rateInput = findViewById<EditText>(R.id.rateInput)
        val taxInput = findViewById<EditText>(R.id.taxInput)
        val calculateButton = findViewById<Button>(R.id.calculateButton)
        val aboutButton = findViewById<Button>(R.id.aboutButton)
        val resultText = findViewById<TextView>(R.id.resultText)

        // Calculate the pay when the Calculate button is pressed
        calculateButton.setOnClickListener {

            // Read the values entered by the user
            // Use 0 if an input is empty or invalid
            val hours = hoursInput.text.toString().toDoubleOrNull() ?: 0.0
            val hourlyRate = rateInput.text.toString().toDoubleOrNull() ?: 0.0
            val taxRate =
                (taxInput.text.toString().toDoubleOrNull() ?: 0.0) / 100

            // Create variables for regular pay and overtime pay
            val pay: Double
            val overtimePay: Double

            // Calculate regular pay and overtime after 40 hours
            if (hours <= 40) {
                pay = hours * hourlyRate
                overtimePay = 0.0
            } else {
                pay = 40 * hourlyRate
                overtimePay = (hours - 40) * hourlyRate * 1.5
            }

            // Add regular pay and overtime pay together
            val totalPay = pay + overtimePay

            // Calculate tax on regular pay
            val tax = pay * taxRate

            // Display the results with two decimal places
            resultText.text = "Pay: $%.2f\nOvertime Pay: $%.2f\nTotal Pay: $%.2f\nTax: $%.2f"
                .format(pay, overtimePay, totalPay, tax)
        }

        // Open the About screen when the About button is pressed
        aboutButton.setOnClickListener {
            startActivity(Intent(this, AboutActivity::class.java))
        }
    }
}
