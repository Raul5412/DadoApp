package edu.itesm.justiceleague

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val jl = mutableListOf<SuperHeroe>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun init(){
        editTextTextPersonName.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                button.text = s.toString()
            }

        })
    }

    fun guarda(view: View){
        val superHeroe = SuperHeroe(editTextTextPersonName.text.toString() )
        superHeroe.movil = editTextPhone.text.toString()
        superHeroe.mail = editTextTextEmailAddress.text.toString()
        superHeroe.edad = editTextNumberSigned.text.toString().toInt()

        Log.i("edu.itesm.daec.jl", superHeroe.toString() )

        jl.add(superHeroe)
        Log.i("edu.itesm.daec.jl", jl.toString())
        Log.i("edu.itesm.daec.jl", jl.sumBy { it.edad }.toString())
    }
}