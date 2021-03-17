package com.ctt.restaurantes.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import com.ctt.restaurantes.R
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_Restaurantes)
        setContentView(R.layout.activity_main)
        initComponents()
    }


    private fun initComponents() {


        btnLogin.setOnClickListener {
            val intent = Intent(this, RestaurantsActivity::class.java)
            startActivity(intent)
        }
        btnRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }


        etMail.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (!android.util.Patterns.EMAIL_ADDRESS.matcher(etMail.text.toString())
                                .matches()
                ) {
                    btnLogin.isEnabled = false
                    etMail.setError("E-mail Inválido!")
                } else if (!etPassword.text.isNullOrEmpty()) {
                    btnLogin.isEnabled = true
                }
            }
        })
        etPassword.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (etPassword.text.isNullOrEmpty()) {
                    btnLogin.isEnabled = false
                    etPassword.setError("Senha Inválida!")
                } else {
                    btnLogin.isEnabled = true

                }
            }
        })

    }
}
