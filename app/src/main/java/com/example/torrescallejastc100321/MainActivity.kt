package com.example.torrescallejastc100321

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    private lateinit var txtNombres:EditText
    private lateinit var txtApellidos:EditText
    private lateinit var txtEmail:EditText
    private lateinit var botonGuardar:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtNombres = findViewById(R.id.txt_nombres)
        txtApellidos = findViewById(R.id.txt_apellidos)
        txtEmail = findViewById(R.id.txt_email)
        botonGuardar = findViewById(R.id.btn_guardar)

        botonGuardar.setOnClickListener{

            if(this.txtNombres.getText().toString().isNullOrEmpty() || txtApellidos.getText().toString().isNullOrEmpty() || txtEmail.getText().toString().isNullOrEmpty()) {
                mensaje("Campos Vacios" ,"Se a detectado que al menos un campo esta vacio")
            }else {
                val intent = Intent(this,MainActivity2::class.java)
                intent.putExtra("nombres", txtNombres.getText().toString())
                intent.putExtra("apellidos", txtApellidos.getText().toString())
                intent.putExtra("email", txtEmail.getText().toString())
            }

        }

    }

    fun mensaje(titulo:String,mensaje:String){
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder
            .setMessage(mensaje)
            .setTitle(titulo)
            .setPositiveButton("Aceptar") { _, _ ->
                // Do something.
            }
        /*.setNegativeButton("Cancelar") { _, _ ->
            // Do something else.
        }*/

        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
}