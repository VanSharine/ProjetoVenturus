package com.example.projetointegradorventurus.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projetointegradorventurus.R
import com.example.projetointegradorventurus.model.TarefaEmProgresso
import com.example.projetointegradorventurus.view.adapter.EmProgressoAdapter

class EmProgressoFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_em_progresso, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listaEmProgresso = mutableListOf(
            TarefaEmProgresso(
                titulo = "Comprar remedio",
                descricao = "remedio remTarefaEmProgressoedio remedio TarefaEmProgresso remedio"
            ),
            TarefaEmProgresso(
                titulo = "Acordar cedo",
                descricao = "Acordar TarefaEmProgresso TarefaEmProgresso acordar TarefaEmProgresso"
            ),
            TarefaEmProgresso(
                titulo = "Entregar o projeto",
                descricao = "projeto TarefaEmProgresso projeto projeto TarefaEmProgresso"
            ),
        )

        val rvEmProgresso = view.findViewById<RecyclerView>(R.id.rvEmProgresso)
        val adapterContato = EmProgressoAdapter(listaEmProgresso)
        rvEmProgresso.adapter = adapterContato
        rvEmProgresso.layoutManager = LinearLayoutManager(requireContext())
    }
}