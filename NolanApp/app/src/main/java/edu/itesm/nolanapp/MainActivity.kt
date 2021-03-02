package edu.itesm.nolanapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.fragment_tenet.*

class MainActivity : AppCompatActivity() {
    private  val fragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initIteractions()
    }

    fun initIteractions(){
        toggleButton.setOnCheckedChangeListener { buttonView, isChecked ->
            val transaction = fragmentManager.beginTransaction()
            if(isChecked){
                transaction.replace(R.id.frameLayout2, NolanCUFragment() )
            }else{
                transaction.replace(R.id.frameLayout2, TenetFragment() )
            }
            transaction.commit()
        }
    }
}