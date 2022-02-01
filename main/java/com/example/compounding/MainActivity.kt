package com.example.compounding

import android.content.Intent
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.nio.file.attribute.GroupPrincipal
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    lateinit var etPrincipal: EditText
    lateinit var etRate: EditText
    lateinit var etYears: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etPrincipal = findViewById(R.id.et_principal)
        etYears = findViewById(R.id.et_years)
        etRate = findViewById(R.id.et_rate)
    }

    fun calculate(view: android.view.View) {
        val p:Int = etPrincipal.getText().toString().toInt()
        val r:Double = etRate.getText().toString().toDouble()
        val y:Int = etYears.getText().toString().toInt()

        val ci = p*(1+ (r/100)).pow(y)



        val tvinterest:TextView = findViewById(R.id.interest)
        val tvmaturity:TextView = findViewById(R.id.maturity)
        val but2:Button = findViewById(R.id.second_button)
        tvinterest.text = "Interest earned is : ${(ci-p).toInt().toString()}"
        tvmaturity.text = "Maturity amount is : ${(ci).toInt().toString()}"
        tvinterest.visibility = View.VISIBLE
        tvmaturity.visibility = View.VISIBLE
        but2.visibility = View.VISIBLE
    }

    fun nextActivity(view: android.view.View) {
        val intent: Intent = Intent(this, secondActivity::class.java)
        startActivity(intent)

    }
}