package com.example.desafiomarveldh.view.activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.core.content.edit

import com.example.desafiomarveldh.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private var sharedPreferences: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.isEnabled = false

        var email = binding.tietEmail
        var senha = binding.tietPassword
        var logar = binding.btnLogin

        sharedPreferences = getSharedPreferences("Register", Context.MODE_PRIVATE)
        val savedEmail: String? = sharedPreferences?.getString("EMAIL_KEY",null)
        val savedSenha: String? = sharedPreferences?.getString("SENHA_KEY",null)

        email?.setText(savedEmail)
        senha?.setText(savedSenha)

        email.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                if (android.util.Patterns.EMAIL_ADDRESS.matcher(email.text.toString()).matches()) {
                    if (!senha.text.isNullOrEmpty()) {
                        binding.btnLogin.isEnabled = true
                    } else {
                        senha.setError("Senha não pode ser vazia!")
                    }
                } else {
                    binding.btnLogin.isEnabled = false
                    email.setError("E-mail Inválido!")
                }

            }
        })

        senha.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (android.util.Patterns.EMAIL_ADDRESS.matcher(email.text.toString())
                        .matches() && !senha.text.isNullOrEmpty()
                ) {
                    binding.btnLogin.isEnabled = true

                } else {
                    binding.btnLogin.isEnabled = false
                    senha.setError("Senha Inválida!")
                }
            }
        })

        logar.setOnClickListener{
            binding.btnLogin.setOnClickListener {
                val i = Intent(this, ComicsActivity::class.java)
                startActivity(i)
            }

            binding.tvCreate.setOnClickListener {
                val i = Intent(this, RegisterActivity::class.java)
                startActivity(i)
            }
            if (binding.cbRemember.isChecked) {

                sharedPreferences = getSharedPreferences("Login", Context.MODE_PRIVATE)

                sharedPreferences?.edit {
                    val loginEmail : String = email.text.toString()
                    val loginSenha : String = senha.text.toString()

                    putString("EMAIL_KEY", loginEmail)
                    putString("SENHA_KEY", loginSenha)
                }
                Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()
             }
        }
    }
}