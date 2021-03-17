package com.ctt.restaurantes.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import com.ctt.restaurantes.R
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_Restaurantes)
        setContentView(R.layout.activity_register)

        initComponents()
    }

    private fun initComponents() {
        btnFormRegister.setOnClickListener {
            val intent = Intent(this, RestaurantsActivity::class.java)
            startActivity(intent)
        }
        etFormName.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (etFormName.text.isNullOrEmpty() ) {
                    btnFormRegister.isEnabled = false
                    etFormName.setError("Nome não pode ser vazio!")
                }else if( !etFormMail.text.isNullOrEmpty()  && !etFormPassword.text.isNullOrEmpty()  && !etFormRepeatePassword.text.isNullOrEmpty() ){
                    btnFormRegister.isEnabled = true

                }
            }
        })
        etFormMail.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (!android.util.Patterns.EMAIL_ADDRESS.matcher(etFormMail.text.toString()).matches() ) {
                    btnFormRegister.isEnabled = false
                    etFormMail.setError("E-mail Inválido!")
                } else if (!etFormPassword.text.isNullOrEmpty()  || !etFormRepeatePassword.text.isNullOrEmpty() ){
                    btnFormRegister.isEnabled = true
                }
            }
        })
        etFormPassword.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (etFormPassword.text.isNullOrEmpty()  ) {
                    btnFormRegister.isEnabled = false
                    etFormPassword.setError("Senha não pode ser vazia!")
                }else if(!etFormRepeatePassword.text.isNullOrEmpty()){
                    btnFormRegister.isEnabled = true
                }
            }
        })
        etFormRepeatePassword.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (etFormPassword.text.toString()  != etFormRepeatePassword.text.toString() ) {
                    btnFormRegister.isEnabled = false
                    etFormRepeatePassword.setError("A confirmação da senha deve ser igual a senha !")
                }else{
                    btnFormRegister.isEnabled = true
                }
            }
        })

    }
}