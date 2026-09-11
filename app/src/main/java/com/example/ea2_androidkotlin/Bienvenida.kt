package com.example.ea2_androidkotlin

// Permite cambiar de una Activity a otra.
import android.content.Intent
import android.os.Bundle
import android.widget.Button

import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Bienvenida : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Permite utilizar el espacio completo de la pantalla.
        enableEdgeToEdge()

        // Carga la interfaz de activity_bienvenida.xml.
        setContentView(R.layout.activity_bienvenida)

        // Ajusta la pantalla para respetar las barras del sistema.
        ViewCompat.setOnApplyWindowInsetsListener(
            findViewById(R.id.main)
        ) { v, insets ->

            val systemBars =
                insets.getInsets(
                    WindowInsetsCompat.Type.systemBars()
                )

            v.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )

            insets
        }

        // Obtiene el botón COMENZAR.
        val btnComenzar =
            findViewById<Button>(R.id.btnComenzar)

        // Acción que se ejecuta al pulsar COMENZAR.
        btnComenzar.setOnClickListener {

            // Crea un Intent para abrir MainActivity.
            val intent =
                Intent(this, MainActivity::class.java)

            // Abre la actividad principal.
            startActivity(intent)

            /*
             * Cierra Bienvenida para que al regresar
             * no vuelva a aparecer la pantalla inicial.
             */
            finish()
        }
    }
}
