package com.example.projetointegradorventurus.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projetointegradorventurus.R
import com.example.projetointegradorventurus.model.TarefaFeita
import com.example.projetointegradorventurus.view.adapter.FeitaAdapter

class FeitasFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_feitas, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listaFeitas = mutableListOf(
            TarefaFeita(
                titulo = "Comprar remedio",
                descricao = "remedio listaFeitas remedio remedlistaFeitasio remedio"
            ),
            TarefaFeita(
                titulo = "Acordar cedo",
                descricao = "Acordar listaFeitas Acordar listaFeitas Acordar"
            ),
            TarefaFeita(
                titulo = "Entregar o projeto",
                descricao = "projeto listaFeitas projeto listaFeitas projeto"
            ),
        )

        val rvFeita = view.findViewById<RecyclerView>(R.id.rvFeitas)
        val adapterFeita = FeitaAdapter(listaFeitas)
        rvFeita.adapter = adapterFeita
        rvFeita.layoutManager = LinearLayoutManager(requireContext())
    }
}