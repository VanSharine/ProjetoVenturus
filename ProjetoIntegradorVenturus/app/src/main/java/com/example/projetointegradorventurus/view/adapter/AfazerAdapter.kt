package com.example.projetointegradorventurus.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projetointegradorventurus.R
import com.example.projetointegradorventurus.model.TarefaAfazer

class AfazerAdapter(private val listaAfazer: MutableList<TarefaAfazer>) :
    RecyclerView.Adapter<AfazerAdapter.AfazerHolder>() {

    class AfazerHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titulo: TextView = view.findViewById(R.id.tvTitulo)
        val descricao: TextView = view.findViewById(R.id.tvDescricao)
    }

    fun adicionarTarefa(novaTarefa: TarefaAfazer) {
        listaAfazer.add(novaTarefa)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AfazerHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_tarefas, parent, false)
        return AfazerHolder(view)
    }

    override fun onBindViewHolder(holder: AfazerHolder, position: Int) {
        holder.titulo.text = listaAfazer[position].titulo
        holder.descricao.text = listaAfazer[position].descricao

    }

    override fun getItemCount(): Int = listaAfazer.size

}
