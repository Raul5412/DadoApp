package edu.itesm.imcapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ImcAdapter(private val medidas : List<Medida>)
    : RecyclerView.Adapter<ImcAdapter.ImcViewHolder>(){
    inner class ImcViewHolder(renglon: View) : RecyclerView.ViewHolder(renglon){
        var fecha = renglon.findViewById<TextView>(R.id.fecha)
        var imc = renglon.findViewById<TextView>(R.id.imc)
    }
    //Crea el renglón
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImcViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val regVista = inflater.inflate(R.layout.renglon_layout,parent, false)
        return ImcViewHolder(regVista)
    }
    //Asocia datos con los elementos del renglón
    override fun onBindViewHolder(holder: ImcViewHolder, position: Int) {
        val dato = medidas[position]
        val peso = dato.peso
        val altura = dato.altura
        val imc = peso / Math.pow(altura, 2.0)
        holder.fecha.text = dato.fecha
        holder.imc.text = " imc = $imc ...."
    }
    // Cuantos elementos tiene la lista
    override fun getItemCount(): Int {
        return medidas.size
    }
}