package com.example.currency

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private val GBPtoUSD = 1.23878f
    private val GBPtoEUR = 1.15921f

    lateinit var poundText: EditText
    lateinit var dollarText: EditText
    lateinit var euroText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Get layout components:
        poundText = findViewById<View>(R.id.poundValue) as EditText
        dollarText = findViewById<View>(R.id.dollarValue) as EditText
        euroText = findViewById<View>(R.id.euroValue) as EditText

        //Setup action listeners:
        val clearButton = findViewById<View>(R.id.clearButton) as Button
        clearButton.setOnClickListener{
            clearFields()
        }

        val convertButton = findViewById<View>(R.id.convertButton) as Button
        convertButton.setOnClickListener{
            convertCurrencies()
        }

    }

    fun clearFields()
    {
        poundText.setText("").toString()
        dollarText.setText("").toString()
        euroText.setText("").toString()
    }

    fun convertCurrencies()
    {
        try {
            val gbpString = poundText.text.toString()
            val gbpVal = gbpString.toFloat()
            val euros = Math.round(gbpVal * GBPtoEUR * 100) / 100f
            euroText.setText(euros.toString())
            val dollars = Math.round(gbpVal * GBPtoUSD * 100) / 100f
            dollarText.setText(dollars.toString())
        } catch (nfe: NumberFormatException) {
            //Incorrect input by user
            poundText.setText("Numbers go here!").toString()
        }
    }

}