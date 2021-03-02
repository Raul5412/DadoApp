package edu.itesm.nolanapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_nolan_c_u.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [NolanCUFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NolanCUFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nolan_c_u, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    private lateinit var movies : ArrayList<Movie>
    private var position = 0


    fun initInteractions(){
        movies = ArrayList<Movie>()
        movies.add(Movie(R.drawable.nolan01, "2008", "Dark Knight" ))
        movies.add(Movie(R.drawable.nolan02, "2010", "Inception" ))
        movies.add(Movie(R.drawable.nolan03, "2014", "Interstellar" ))
        movies.add(Movie(R.drawable.nolan04, "2020", "Tenet" ))
        movies.add(Movie(R.drawable.nolan05, "2017", "Dunkirk" ))
        val movie = movies[0]
        imageView.setImageResource(movie.idview)
        fecha.text = movie.anio
        titulo.text = movie.titulo

        imageView.setOnClickListener {
            position = ++position % movies.size
            val movie = movies[position]
            imageView.setImageResource(movie.idview)
            fecha.text = movie.anio
            titulo.text = movie.titulo
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment NolanCUFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            NolanCUFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}