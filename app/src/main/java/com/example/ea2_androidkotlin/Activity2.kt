package com.example.ea2_androidkotlin

// Permite crear el resultado que volverá a MainActivity.
import android.content.Intent
import android.os.Bundle

// Componentes gráficos utilizados.
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Activity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Permite utilizar el espacio completo de la pantalla.
        enableEdgeToEdge()

        // Carga la interfaz definida en activity_2.xml.
        setContentView(R.layout.activity_2)

        // Ajusta el contenido para respetar las barras del sistema.
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

        // Referencia al TextView donde se mostrará el mensaje.
        val txtMensaje =
            findViewById<TextView>(R.id.txtMensaje)

        // Recupera el mensaje enviado desde MainActivity.
        val mensaje =
            intent.getStringExtra("mensaje")

        // Muestra el mensaje en pantalla.
        txtMensaje.text = mensaje

        // Referencia al botón RECIBIDO.
        val btnRecibido =
            findViewById<Button>(R.id.btnRecibido)

        // Referencia al botón CANCELADO.
        val btnCancelado =
            findViewById<Button>(R.id.btnCancelado)

        // Acción que se ejecuta al pulsar RECIBIDO.
        btnRecibido.setOnClickListener {

            // Crea un Intent para devolver información.
            val resultado = Intent()

            // Envía el estado RECIBIDO.
            resultado.putExtra(
                "resultado",
                "RECIBIDO"
            )

            // Devuelve también el mensaje original.
            resultado.putExtra(
                "mensaje",
                mensaje
            )

            // Envía el resultado a MainActivity.
            setResult(
                RESULT_OK,
                resultado
            )

            // Cierra Activity2 y regresa a MainActivity.
            finish()
        }

        // Acción que se ejecuta al pulsar CANCELADO.
        btnCancelado.setOnClickListener {

            // Crea un Intent para devolver información.
            val resultado = Intent()

            // Envía el estado CANCELADO.
            resultado.putExtra(
                "resultado",
                "CANCELADO"
            )

            // Devuelve también el mensaje original.
            resultado.putExtra(
                "mensaje",
                mensaje
            )

            // Envía el resultado a MainActivity.
            setResult(
                RESULT_OK,
                resultado
            )

            // Cierra Activity2 y regresa a MainActivity.
            finish()
        }
    }
}
