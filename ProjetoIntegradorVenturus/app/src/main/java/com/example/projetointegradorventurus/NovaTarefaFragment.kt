package com.example.projetointegradorventurus

import android.accounts.AccountManager.get
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.projetointegradorventurus.databinding.ActivityMainBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class NovaTarefaFragment : BottomSheetDialogFragment() {

    private lateinit var binding: NovaTarefaFragment
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_nova_tarefa, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ///Toast.makeText(getContext(),"Algum campo está em branco!", Toast.LENGTH_LONG).show()
        val botaoCriarTarefa = view.findViewById<Button>(R.id.btnCriarTarefa)
        val titulo = view.findViewById<EditText>(R.id.tieTarefa)
        val descricao = view.findViewById<EditText>(R.id.tieTarefaDescricao)
        Toast.makeText(getContext(),"Algum campo está em 22branco!", Toast.LENGTH_LONG).show()

        botaoCriarTarefa.setOnClickListener {
            Toast.makeText(getContext(),"Algum campo está em branco!", Toast.LENGTH_LONG).show()
            //Toast.makeText(context,"Algum campo está em branco!", Toast.LENGTH_LONG).show()
            val tituloTarefa = titulo.text.toString()
            val descricaoTarefa = descricao.text.toString()

            if (tituloTarefa.isEmpty() || descricaoTarefa.isEmpty()){
                Toast.makeText(getContext(),"Algum campo está em branco!", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(getContext(),"Cadastro realizado com sucesso!", Toast.LENGTH_LONG).show()
            }
        }
    }
//    val botaoCadastrar = findViewById<Button>(R.id.btn_commit)
//    val nome = findViewById<EditText>(R.id.edt_cadastroNome)
//    val email = findViewById<EditText>(R.id.edt_cadastroEmail)
//    val senha = findViewById<EditText>(R.id.edt_cadastroSenha)
//    val bairro = findViewById<EditText>(R.id.edt_cadastroBairro)
//    val idade = findViewById<EditText>(R.id.edt_cadastroIdade)
//
//    botaoCadastrar.setOnClickListener{
//        val nomeDigitado = nome.text.toString()
//        val emailDigitado = email.text.toString()
//        val senhaDigitado = senha.text.toString()
//        val bairroDigitado = bairro.text.toString()
//        val idadeDigitado = idade.text.toString()
//
//        if (nomeDigitado.isEmpty() || emailDigitado.isEmpty() || senhaDigitado.isEmpty() || bairroDigitado.isEmpty() || idadeDigitado.isEmpty()){
//            Toast.makeText(this,"Algum campo está em branco!", Toast.LENGTH_LONG).show()
//        }else{
//            Toast.makeText(this,"Cadastro realizado com sucesso!", Toast.LENGTH_LONG).show()
//        }
//    }

}