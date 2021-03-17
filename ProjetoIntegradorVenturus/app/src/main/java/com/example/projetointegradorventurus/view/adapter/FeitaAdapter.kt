package com.example.projetointegradorventurus.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projetointegradorventurus.R
import com.example.projetointegradorventurus.model.TarefaFeita

class FeitaAdapter(private val listaFeitas: MutableList<TarefaFeita>): RecyclerView.Adapter<FeitaAdapter.FeitasHolder>(){

    class FeitasHolder(view: View) : RecyclerView.ViewHolder(view){
        val titulo: TextView = view.findViewById(R.id.tvTitulo)
        val descricao: TextView = view.findViewById(R.id.tvDescricao)
    }

    fun adicionarTarefa(novaTarefa: TarefaFeita){
        listaFeitas.add(novaTarefa)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeitasHolder {
        val view = LayoutInflater.from(parent.context).
        inflate(R.layout.item_tarefas, parent, false)
        return FeitasHolder(view)
    }

    override fun onBindViewHolder(holder: FeitasHolder, position: Int) {
        holder.titulo.text = listaFeitas[position].titulo
        holder.descricao.text = listaFeitas[position].descricao

    }

    override fun getItemCount(): Int = listaFeitas.size

}