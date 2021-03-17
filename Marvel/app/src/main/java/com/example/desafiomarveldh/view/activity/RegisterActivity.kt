package com.example.desafiomarveldh.view.activity

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.edit
import com.example.desafiomarveldh.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private var sharedPreferences: SharedPreferences? = null
    lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var nome = binding.tietRegisterName
        var email = binding.tietRegisterEmail
        var senha = binding.tietRegisterPassword
        var foto = binding.rvContactsItemAvatar
        var save = binding.btnRegisterSave

        sharedPreferences = getSharedPreferences("Register", Context.MODE_PRIVATE)
        val savedName: String? = sharedPreferences?.getString("NAME_KEY", null)
        val savedEmail: String? = sharedPreferences?.getString("EMAIL_KEY", null)
        val savedSenha: String? = sharedPreferences?.getString("SENHA_KEY", null)

        //nome?.text = savedName.setText("")
        nome?.setText(savedName)
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
                        binding.btnRegisterSave.isEnabled = true
                        senha.setError("Senha Não pode ser vazia!")
                    }
                    //  setupObservables()

                } else {
                    binding.btnRegisterSave.isEnabled = false
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
                    binding.btnRegisterSave.isEnabled = true
                    //setupObservables()

                } else {
                    binding.btnRegisterSave.isEnabled = false
                    senha.setError("Senha Inválida!")
                }
            }
        })

        foto.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
                    val permissions = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE);
                    requestPermissions(permissions, PERMISSION_CODE);
                } else {
                    pickImageFromGallery();
                }
            } else {
                pickImageFromGallery();
            }
        }

        save.setOnClickListener {
            val registerName: String = nome.text.toString()
            val registerEmail: String = email.text.toString()
            val registerSenha: String = senha.text.toString()

            sharedPreferences = getSharedPreferences("Register", Context.MODE_PRIVATE)
            sharedPreferences?.edit {
                putString("NAME_KEY", registerName)
                putString("EMAIL_KEY", registerEmail)
                putString("SENHA_KEY", registerSenha)
            }
            Toast.makeText(this, "Register saved", Toast.LENGTH_SHORT).show()
        }
    }


    private fun pickImageFromGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_PICK_CODE)
    }

    companion object {
        private val IMAGE_PICK_CODE = 1000;
        private val PERMISSION_CODE = 1001;
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            PERMISSION_CODE -> {
                if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    pickImageFromGallery()
                } else {
                    Toast.makeText(this, "Permissão negada", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == IMAGE_PICK_CODE) {
            imageView.setImageURI(data?.data)
        }
    }


}