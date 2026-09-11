📱 App Móvil - Proyecto Android Kotlin - Comunicación entre Activities

    Nombre: ea2_androidkotlin
    
    Lenguaje: Kotlin
    
    Interfaz: XML + Views
    
    Package: com.example.ea2_androidkotlin
    
    Plantilla: Empty Views Activity

DESCRIPCION: Aplicación Android desarrollada en Kotlin utilizando XML y Views. El proyecto implementa la comunicación entre diferentes Activities mediante Intent, putExtra(), getStringExtra() y ActivityResultContracts.
La aplicación permite escribir un mensaje en MainActivity, enviarlo a Activity2 y seleccionar si el mensaje fue RECIBIDO o CANCELADO. Posteriormente, el resultado regresa a MainActivity, donde se muestra el estado y el mensaje procesado.

La aplicación también incluye una pantalla inicial de bienvenida y una opción para salir de la aplicación.

Características principales:

- Pantalla de bienvenida.
- Entrada de mensajes mediante EditText.
- Envío de mensajes desde MainActivity hacia Activity2.
- Recepción y visualización del mensaje en Activity2.
- Opción RECIBIDO.
- Opción CANCELADO.
- Regreso del resultado hacia MainActivity.
- Presentación del estado y del mensaje procesado.
- Cambio de colores según el resultado.
- Limpieza del campo de mensaje después de la operación.
- Diseño adaptado para orientación vertical y horizontal.
- Botón para salir de la aplicación.

REQUISITOS PARA EJECUTAR PROYECTO:

Android Studio instalado O IntelliJ IDEA con sooporte para android.
JDK 21
Android SDK configurado.
Gradle 9.5.0
Un dispositivo Android físico o un emulador.
Una versión de Android compatible con el proyecto.

ENTORNO DE PRUEBA:
La aplicacion fue probada utilizando:
- Dispositivo virtual: Medium Phone
- Android: 17/ API 37.1
- Imagen: Google APIs
- Arquitectura: x86_64
- Tamaño de pagina: 16 kb

🚀 Instalación y ejecución
Descargar o clonar este repositorio.
Abrir el proyecto desde Android Studio.
Esperar a que finalice la sincronización de Gradle.
Conectar un dispositivo Android o iniciar un emulador.
Ejecutar el proyecto mediante el botón Run ▶.
La aplicación iniciará en la pantalla de bienvenida.

FUNCIONAMIENTO:

Flujo de la aplicación

Pantalla de Bienvenida
↓
MainActivity
↓
Escribir mensaje
↓
ENVIAR
↓
Activity2
↓
┌───────────────┐
│               │
RECIBIDO      CANCELADO
│               │
└───────┬───────┘
↓
MainActivity
↓
Mostrar estado y mensaje
↓
Limpiar campo

Tecnologías utilizadas:
- Kotlin
- Android
- XML
- Views
- ConstraintLayout
- Intent
- ActivityResultContracts
- Gradle Kotlin DSL
- 
ESTRUCTURA PRINCIPAL:

app/
└── src/
└── main/
├── AndroidManifest.xml
│
├── kotlin+java/
│   └── com.example.miproyecto/
│       ├── Bienvenida.kt
│       ├── MainActivity.kt
│       └── Activity2.kt
│
└── res/
├── drawable/
├── layout/
├── layout-land/
└── values/

🖥️ PANTALLAS/ACTIVITIES
1. Pantalla de bienvenida: Es la primera pantalla que aparece al iniciar la aplicación.

Contiene:

Título de bienvenida.
Ícono de teléfono.
Nombre de la aplicación.
Descripción de la práctica.
Botón COMENCEMOS.

La pantalla cuenta con una versión vertical y otra horizontal para adaptarse a la orientación del dispositivo.

2. MainActivity

Es la actividad principal de la aplicación.

Permite:

Escribir un mensaje.
Enviar el mensaje a Activity2.
Visualizar el estado del mensaje.
Mostrar el mensaje recibido o cancelado.
Salir de la aplicación.
3. Activity2

Es la segunda actividad.

Su función principal es:

Recibir el mensaje enviado desde MainActivity.
Mostrar el mensaje recibido.
Permitir seleccionar RECIBIDO.
Permitir seleccionar CANCELADO.
Devolver el resultado a MainActivity.

Los botones RECIBIDO y CANCELADO se encuentran organizados horizontalmente cuando el dispositivo está en orientación horizontal.

Comunicación entre Activities: La comunicación entre las actividades se realiza mediante Intent.

MainActivity envía el mensaje a Activity2.

MainActivity
│
│ mensaje
▼
Activity2
│
│ resultado
▼
MainActivity


El resultado puede ser:

RECIBIDO


o

CANCELADO


Al regresar a MainActivity, el estado seleccionado se muestra en pantalla junto con el mensaje correspondiente.


DESCRIPCION DE ARCHIVOS:

Bienvenida.kt	Controla la pantalla inicial y el acceso a la aplicación.
MainActivity.kt	Permite escribir y enviar mensajes, recibir resultados y salir de la aplicación.
Activity2.kt	Recibe el mensaje y permite seleccionar RECIBIDO o CANCELADO.
activity_bienvenida.xml	Interfaz de la pantalla de bienvenida.
activity_main.xml	Interfaz principal de la aplicación.
activity_2.xml	Interfaz de la segunda actividad.
(land)	Variante de cada interfaz para orientación horizontal.
AndroidManifest.xml	Registra las Activities y configura la aplicación.
drawable	Contiene el recurso gráfico utilizado en la aplicación.
📐 Adaptación a la orientación

La aplicación dispone de diseños para:

📱 Orientación vertical.
📱 Orientación horizontal.

Las variantes land permiten reorganizar los componentes cuando el dispositivo se gira, evitando que botones o elementos importantes queden fuera de la pantalla.

Esto se implementó para:

Bienvenida
MainActivity
Activity2


La lógica de Kotlin no cambia al girar el dispositivo; únicamente se utiliza una distribución gráfica diferente.

INTERFAZ GRAFICA

La aplicación utiliza diferentes colores para distinguir visualmente sus componentes:

🔵 Azul: acciones principales y elementos de MainActivity.
🟣 Morado: elementos de Activity2.
🟢 Verde: estado RECIBIDO.
🔴 Rojo: estado CANCELADO.
⚪ Gris: botón SALIR DE APLICACIÓN.
🟢 Verde azulado: botón COMENCEMOS.

También se utilizan márgenes, tamaños de texto, colores y distribución mediante ConstraintLayout para mejorar la presentación visual.

Este proyecto fue desarrollado como una práctica de desarrollo móvil para aplicar conceptos fundamentales de Android, principalmente:

Creación y navegación entre Activities.
Uso de Intent.
Envío de información entre actividades.
Recepción de resultados.
Diseño de interfaces mediante XML.
Uso de layouts adaptables.
Manejo de diferentes orientaciones de pantalla.
Organización de un proyecto Android.

Autor: Proyecto desarrollado como práctica académica de desarrollo de aplicaciones móviles en Android.
