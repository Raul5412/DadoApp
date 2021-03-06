package edu.itesm.nytimes

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private val BASE_URL = "https://api.nytimes.com/svc/books/v3/lists/current/"
    private lateinit var recyclerView: RecyclerView
    private lateinit var manager: RecyclerView.LayoutManager
    private lateinit var myAdapter: RecyclerView.Adapter<*>
    private lateinit var results: Results

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        manager = LinearLayoutManager(this)
        Toast.makeText(this,"ON CREATE", Toast.LENGTH_SHORT).show();
        getAllData()
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }
    fun getAllData(){

        val callToService = getRetrofit().create(APIService::class.java)

        CoroutineScope(Dispatchers.IO).launch {
            val responseFromService = callToService.getBooks()
            runOnUiThread {
                results = responseFromService.body() as Results

                if (responseFromService.isSuccessful) {
                    Log.i("Books", results.results?.books.toString())

                    recyclerView = findViewById<RecyclerView>(R.id.recycler_view).apply {

                        layoutManager = LinearLayoutManager(this@MainActivity)
                        adapter = BooksAdapter(results.results?.books)

                    }

                }  else {
                    Log.i("Books", "No jaló")
                    Toast.makeText(applicationContext, "Error!", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    override fun onStart() {
        // TODO Auto-generated method stub
        super.onStart()
        Toast.makeText(this, "ON START", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        // TODO Auto-generated method stub
        super.onResume()
        Toast.makeText(this, "ON RESUME", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        // TODO Auto-generated method stub
        super.onPause()
        Toast.makeText(this, "ON PAUSE", Toast.LENGTH_SHORT).show()
    }

    override fun onRestart() {
        // TODO Auto-generated method stub
        super.onRestart()
        Toast.makeText(this, "ON RESTART", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        // TODO Auto-generated method stub
        super.onStop()
        Toast.makeText(this, "ON STOP", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy()
        Toast.makeText(this, "ON DESTROY", Toast.LENGTH_SHORT).show()
    }
}