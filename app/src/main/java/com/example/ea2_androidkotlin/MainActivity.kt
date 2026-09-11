package com.example.ea2_androidkotlin

// Permite identificar el resultado devuelto por Activity2.
import android.app.Activity

// Permite crear y enviar información entre Activities.
import android.content.Intent

// Permite cambiar los colores del estado.
import android.graphics.Color

import android.os.Bundle

// Componentes gráficos utilizados.
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

// Herramientas para recibir resultados de otras Activities.
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    /*
     * Permite abrir Activity2 y recibir la información
     * que esta devuelve al finalizar.
     */
    private val activity2Launcher =
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { resultado ->

            // Comprobamos que Activity2 haya devuelto un resultado correcto.
            if (resultado.resultCode == Activity.RESULT_OK) {

                // Recuperamos el estado enviado desde Activity2.
                val estado =
                    resultado.data?.getStringExtra("resultado")

                // Recuperamos el mensaje original.
                val mensaje =
                    resultado.data?.getStringExtra("mensaje")

                // Obtenemos el TextView que muestra el estado.
                val txtEstado =
                    findViewById<TextView>(R.id.txtEstado)

                // Si el mensaje fue recibido, usamos el diseño verde.
                if (estado == "RECIBIDO") {

                    txtEstado.text =
                        "ESTADO: RECIBIDO\n\nMensaje Recibido: $mensaje"

                    txtEstado.setBackgroundColor(
                        Color.rgb(207, 235, 216)
                    )

                    txtEstado.setTextColor(
                        Color.rgb(38, 92, 55)
                    )

                    // Si el mensaje fue cancelado, usamos el diseño rojo.
                } else if (estado == "CANCELADO") {

                    txtEstado.text =
                        "ESTADO: CANCELADO\n\nMensaje Cancelado: $mensaje"

                    txtEstado.setBackgroundColor(
                        Color.rgb(248, 214, 216)
                    )

                    txtEstado.setTextColor(
                        Color.rgb(125, 48, 55)
                    )
                }

                // Limpia el campo para poder escribir un nuevo mensaje.
                findViewById<EditText>(
                    R.id.editMensaje
                ).text.clear()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Permite utilizar el espacio completo de la pantalla.
        enableEdgeToEdge()

        // Carga la interfaz definida en activity_main.xml.
        setContentView(R.layout.activity_main)

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

        // Referencia al campo donde se escribe el mensaje.
        val editMensaje =
            findViewById<EditText>(R.id.editMensaje)

        // Referencia al botón de envío.
        val btnEnviar =
            findViewById<Button>(R.id.btnEnviar)

        // Referencia al botón para salir.
        val btnSalir =
            findViewById<Button>(R.id.btnSalir)

        // Acción que se ejecuta al pulsar ENVIAR MENSAJE.
        btnEnviar.setOnClickListener {

            // Obtiene el texto escrito por el usuario.
            val mensaje =
                editMensaje.text.toString()

            // Crea un Intent para abrir Activity2.
            val intent =
                Intent(this, Activity2::class.java)

            // Envía el mensaje dentro del Intent.
            intent.putExtra("mensaje", mensaje)

            // Abre Activity2 esperando recibir un resultado.
            activity2Launcher.launch(intent)
        }

        // Acción que se ejecuta al pulsar SALIR.
        btnSalir.setOnClickListener {

            // Cierra la aplicación y sus Activities actuales.
            finishAffinity()
        }
    }
}
