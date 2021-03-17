package com.example.projetointegradorventurus.view.adapter
/*
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.projetointegradorventurus.R
import com.example.projetointegradorventurus.model.Tarefa
import kotlinx.android.synthetic.main.item_tarefas.view.*

class TarefasAdapter(
    private val tarefasList: List<Tarefa>,
    private val onItemClicked: (Int) -> Unit
) : RecyclerView.Adapter<TarefasAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_tarefas, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(tarefasList[position], onItemClicked)
    }

    override fun getItemCount(): Int {
        return tarefasList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(tarefas: Tarefa, onItemClicked: (Int) -> Unit) = with(itemView) {

            tvTitulo.text = tarefas.titulo
            tvDescricao.text = tarefas.descricao

            cvTarefas.setOnClickListener {
                onItemClicked(this@ViewHolder.adapterPosition)
            }
        }

    }


}*/