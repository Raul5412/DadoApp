package edu.itesm.imcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class ResultadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)
        val peso = intent.getDoubleExtra("peso", 67.6)
        val altura = intent.getDoubleExtra("altura", 1.58)
        val imc = peso / (altura* altura)
        Toast.makeText(this, "$imc tu imc!", Toast.LENGTH_LONG ).show()
    }
}