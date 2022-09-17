package com.example.firstkotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var factLabel: TextView

    private lateinit var prevButton: Button

    private lateinit var nextButton: Button

    private var facts = arrayOf(
        "TRUE",
        "False",
        "Terrell D Lemons",
        "Alicia L Lemons"
    )

    private var factIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {

        // THE USUAL SYSTEM STUFF
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        // CONNECT OUR VIEWS
        this.connectViews()

        this.setupCallbacks()
    }

    private fun connectViews() {

        // COMMENT
        this.factLabel = this.findViewById(R.id.fact_label)
        this.prevButton = this.findViewById(R.id.prev_button)
        this.nextButton = this.findViewById(R.id.next_button)
    }

    private fun setupCallbacks() {

        // COMMENT
        this.prevButton.setOnClickListener { view: View ->

            // BODY OF THE CODE
            this.adjustFactIndex( adjustment = -1)
            this.factLabel.text = this.facts[this.factIndex]
            println("Previous Button was Clicked")
        }

        this.nextButton.setOnClickListener { view: View ->

            // BODY OF THE CODE
            this.adjustFactIndex( adjustment = 1)
            this.factLabel.text = this.facts[this.factIndex]
            println("Next Button was Clicked")
        }
    }

    private fun adjustFactIndex(adjustment: Int) {

        //
        this.factIndex += adjustment

        if ( this.factIndex < 0 ) {
            this.factIndex = this.facts.size - 1
        }
        else if ( this.factIndex >= this.facts.size ) {
            this.factIndex = 0
        }

        this.factLabel.text = "Something"
    }

}

