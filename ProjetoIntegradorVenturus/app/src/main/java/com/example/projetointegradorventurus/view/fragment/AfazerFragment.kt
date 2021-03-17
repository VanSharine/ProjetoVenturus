package com.example.projetointegradorventurus.view.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projetointegradorventurus.EditTarefaActivity
import com.example.projetointegradorventurus.R
import com.example.projetointegradorventurus.databinding.ActivityMainBinding
import com.example.projetointegradorventurus.databinding.FragmentAfazerBinding
import com.example.projetointegradorventurus.model.TarefaAfazer
import com.example.projetointegradorventurus.view.adapter.AfazerAdapter
import kotlinx.android.synthetic.main.activity_edit_tarefa.*
import kotlinx.android.synthetic.main.item_tarefas.*


class AfazerFragment : Fragment() {

    private lateinit var binding: FragmentAfazerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentAfazerBinding.inflate(layoutInflater)
        //setContentView(binding.root)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_afazer, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val listaAfazer = mutableListOf(
            TarefaAfazer(
                titulo = "Comprar remedio",
                descricao = "listaAfazer remedio listaAfazer remedio remedio"
            ),
            TarefaAfazer(
                titulo = "Acordar cedo",
                descricao = "Acordar listaAfazer Acordar listaAfazer Acordar"
            ),
            TarefaAfazer(
                titulo = "Entregar o projeto",
                descricao = "projeto listaAfazer projeto listaAfazer projeto"
            ),
        )

        val rvAfazer = view.findViewById<RecyclerView>(R.id.rvAfazer)
        val adapterAfazer = AfazerAdapter(listaAfazer)
        rvAfazer.adapter = adapterAfazer
        rvAfazer.layoutManager = LinearLayoutManager(requireContext())

       // val intent = Intent(requireContext(), EditTarefaActivity::class.java)
        //intent.putExtra(KEY_INTENT_TAREFA, tarefas.tarefasList[position])
       // startActivity(intent)
        val tarefas = view.findViewById<RecyclerView>(R.id.cvTarefas)

        tarefas.setOnClickListener {
            Toast.makeText(requireContext(),"clicando no recycler!", Toast.LENGTH_LONG).show()
            activity?.let {
//                val intent = Intent(it, EditTarefaActivity::class.java)
//                intent.putExtra("Titulo", "teste")
//                intent.putExtra("Descricao", "teste2222")
//                it.startActivity(intent)
//                Intent : Bundle()
//                Arguments: Bundle()

            }
        }
    }
}



/*
class AfazerFragment : Fragment() {

    private lateinit var viewModel: TarefasViewModel


    private val recyclerView: RecyclerView by lazy {

           view.findViewById(R.id.rvAfazer)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_afazer, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(TarefasViewModel::class.java)
        viewModel.getTarefas()

    }

    private fun setupObservables() {
        viewModel.tarefasLiveData.observe(viewLifecycleOwner, {
            it?.let { tarefas ->
                recyclerView.apply {
                    layoutManager = LinearLayoutManager(requireContext())
                    adapter = TarefasAdapter(tarefas.tarefasList) { position ->
                        val intent =
                            Intent(requireContext(), EditTarefaActivity::class.java)
                        intent.putExtra(KEY_INTENT_TAREFA, tarefas.tarefasList[position])
                        startActivity(intent)
                    }
                }
            }
        })
    }

    companion object {
        const val KEY_INTENT_TAREFA = "tarefas"
    }
}*/
