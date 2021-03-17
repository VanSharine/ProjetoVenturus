package com.example.projetointegradorventurus

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.projetointegradorventurus.databinding.ActivityMainBinding
import com.example.projetointegradorventurus.view.fragment.AfazerFragment
import com.example.projetointegradorventurus.view.fragment.EmProgressoFragment
import com.example.projetointegradorventurus.view.fragment.FeitasFragment
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadFragment(AfazerFragment())

        binding.tabTarefas.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab?.position) {
                    0 -> {
                        loadFragment(AfazerFragment())
                    }
                    1 -> {
                        loadFragment(EmProgressoFragment())
                    }
                    2 -> {
                        loadFragment(FeitasFragment())
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}

            override fun onTabReselected(tab: TabLayout.Tab?) {}

        })
//        binding.efaAdicionar.setOnClickListener {
//            loadFragment(NovaTarefaFragment())
//        }
        val bottomSheetFragment = NovaTarefaFragment()

        binding.efaAdicionar.setOnClickListener {
            val intent = Intent(this@MainActivity, NovaTarefaActivity::class.java)
            startActivity(intent)
            overridePendingTransition( R.anim.slide_in_up, R.anim.slide_out_up );

//            val intent = Intent(this@MainActivity, EditTarefaActivity::class.java)
//            startActivity(intent)
//            overridePendingTransition( R.anim.slide_in_up, R.anim.slide_out_up );
//           bottomSheetFragment.show(supportFragmentManager,"BottomSheetDialog")
        }

    }

    private fun loadFragment(fragment: Fragment) {
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(binding.containerMain.id, fragment)
        ft.commit()
    }


}