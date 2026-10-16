
package com.comp3074.assignment1

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Display the About screen layout
        setContentView(R.layout.activity_about)

        // Show the back arrow in the ActionBar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Set the title
        supportActionBar?.title = "About"

        // Make the Back to Calculator button work
        val backButton = findViewById<Button>(R.id.backButton)

        backButton.setOnClickListener {
            finish()
        }
    }

    // Return to the existing MainActivity using the ActionBar arrow
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
