package com.example.desafiomarveldh.view.activity

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.core.content.edit
import com.example.desafiomarveldh.R
import com.example.desafiomarveldh.databinding.ActivityLoginBinding
import com.example.desafiomarveldh.databinding.ActivityProfileBinding
import com.example.desafiomarveldh.databinding.ActivityRegisterBinding

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding
    private var sharedPreferences: SharedPreferences? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var nome = binding.tvProfileName
        var email = binding.tietProfileEmail
        var senha = binding.tietProfilePassword
        var foto = binding.rvContactsItemAvatar
        var editar = binding.btnEditProfile

        sharedPreferences = getSharedPreferences("Register", Context.MODE_PRIVATE)
        val savedName: String? = sharedPreferences?.getString("NAME_KEY",null)
        val savedEmail: String? = sharedPreferences?.getString("EMAIL_KEY",null)
        val savedSenha: String? = sharedPreferences?.getString("SENHA_KEY",null)

        nome?.text = savedName
        email?.setText(savedEmail)
        senha?.setText(savedSenha)

        editar.setOnClickListener {
            val registerName : String = nome.text.toString()
            val registerEmail : String = email.text.toString()
            val registerSenha : String = senha.text.toString()

            sharedPreferences?.edit {
                putString("NAME_KEY", registerName)
                putString("EMAIL_KEY", registerEmail)
                putString("SENHA_KEY", registerSenha)
            }

            Toast.makeText(this, "Data saved", Toast.LENGTH_SHORT).show()
        }
        email.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                if (android.util.Patterns.EMAIL_ADDRESS.matcher(email.text.toString()).matches()) {
                    if (!senha.text.isNullOrEmpty()) {
                        editar.isEnabled = true
                    } else {
                        senha.setError("Senha não pode ser vazia!")
                    }
                } else {
                    editar.isEnabled = false
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
                    editar.isEnabled = true

                } else {
                    editar.isEnabled = false
                    senha.setError("Senha Inválida!")
                }
            }
        })
    }

}