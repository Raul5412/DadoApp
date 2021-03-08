package edu.itesm.stanley

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MoviesAdapter(private val movies : List<Movie>)
    : RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>(){

    inner class MovieViewHolder(renglon: View) : RecyclerView.ViewHolder(renglon){
        var titulo = renglon.findViewById<TextView>(R.id.titulo)
        var anio = renglon.findViewById<TextView>(R.id.anio)
        var plot = renglon.findViewById<TextView>(R.id.plot)
        var foto = renglon.findViewById<ImageView>(R.id.foto)
    }

    //Crea el renglón
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val renglon_vista = inflater.inflate(R.layout.movies_renglon,parent, false)
        return MovieViewHolder(renglon_vista)
    }

    //Asocia datos con los elementos del renglón
    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie= movies[position]
        holder.foto.setImageResource(movie.picture)
        holder.titulo.text = movie.titulo
        holder.anio.text = movie.anio
        holder.plot.text = movie.plot
    }

    // Cuantos elementos tiene la lista
    override fun getItemCount(): Int {
        return movies.size
    }
}