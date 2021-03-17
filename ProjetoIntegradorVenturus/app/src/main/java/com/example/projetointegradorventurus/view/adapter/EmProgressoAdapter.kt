package com.example.projetointegradorventurus.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projetointegradorventurus.R
import com.example.projetointegradorventurus.model.TarefaEmProgresso

class EmProgressoAdapter(private val listaEmProgresso: MutableList<TarefaEmProgresso>) :
    RecyclerView.Adapter<EmProgressoAdapter.EmProgressoHolder>() {

    class EmProgressoHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titulo: TextView = view.findViewById(R.id.tvTitulo)
        val descricao: TextView = view.findViewById(R.id.tvDescricao)
    }

    fun adicionarTarefa(novaTarefa: TarefaEmProgresso) {
        listaEmProgresso.add(novaTarefa)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmProgressoHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_tarefas, parent, false)
        return EmProgressoHolder(view)
    }

    override fun onBindViewHolder(holder: EmProgressoHolder, position: Int) {
        holder.titulo.text = listaEmProgresso[position].titulo
        holder.descricao.text = listaEmProgresso[position].descricao

    }

    override fun getItemCount(): Int = listaEmProgresso.size

}
