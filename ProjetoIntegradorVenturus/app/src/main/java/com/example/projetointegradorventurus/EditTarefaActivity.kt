package com.example.projetointegradorventurus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.projetointegradorventurus.view.adapter.AfazerAdapter
import kotlinx.android.synthetic.main.activity_edit_tarefa.*

class EditTarefaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_tarefa)

        val titulocampo = intent.getStringExtra("Titulo").toString()
        val descricaoCampo = intent.getStringExtra("Descricao").toString()
        val titulo: TextView = findViewById(R.id.tvNovaTarefa)
        val descricao: TextView = findViewById(R.id.tvDescricaoNovaTarefa)
        titulo.text = titulocampo
        descricao.text = descricaoCampo

//        val textView: TextView = findViewById(R.id.tvNovaTarefa) as TextView
//        textView.setOnClickListener {
//            textView.text = intent.getStringExtra("Titulo").toString()
//        }
        btnEditar.setOnClickListener {
            val intent = Intent(this@EditTarefaActivity, NovaTarefaActivity::class.java)
            startActivity(intent)
           // overridePendingTransition( R.anim.slide_in_up, R.anim.slide_out_up );
//
//            val intent = Intent(this@MainActivity, EditTarefaActivity::class.java)
//            startActivity(intent)
//            overridePendingTransition( R.anim.slide_in_up, R.anim.slide_out_up );
            // bottomSheetFragment.show(supportFragmentManager,"BottomSheetDialog")
        }
        btnDeletar.setOnClickListener {
            Toast.makeText(this,"clicou deletar!", Toast.LENGTH_LONG).show()
//            val intent = Intent(this@EditTarefaActivity, NovaTarefaActivity::class.java)
//            startActivity(intent)
            // overridePendingTransition( R.anim.slide_in_up, R.anim.slide_out_up );
//
//            val intent = Intent(this@MainActivity, EditTarefaActivity::class.java)
//            startActivity(intent)
//            overridePendingTransition( R.anim.slide_in_up, R.anim.slide_out_up );
            // bottomSheetFragment.show(supportFragmentManager,"BottomSheetDialog")
//            if(dataset.isEmpty())
//                ilustracao.visibility = View.VISIBLE
//            recyclerview.visibility = View.GONE

        }
    }


}