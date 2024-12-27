package com.example.rsocialapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : ComponentActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button
    private lateinit var registerButton: Button // Referencia al botón "Regístrate"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Inicializar Firebase Auth
        auth = FirebaseAuth.getInstance()

        // Referencias a los componentes de la UI
        emailEditText = findViewById(R.id.editTextTextEmailAddress4)
        passwordEditText = findViewById(R.id.editTextTextPassword3)
        loginButton = findViewById(R.id.button4)
        registerButton = findViewById(R.id.button) // Vincular el botón "Regístrate"

        loginButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                loginUser(email, password)
            } else {
                Toast.makeText(this, "Por favor ingrese su correo y contraseña", Toast.LENGTH_SHORT).show()
            }
        }

        // Configurar el evento para el botón "Regístrate"
        registerButton.setOnClickListener {
            // Navegar a la actividad de registro
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    private fun loginUser(email: String, password: String) {
        // Autenticación con Firebase
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Login exitoso
                    val user = auth.currentUser
                    Toast.makeText(this, "Bienvenido, ${user?.email}", Toast.LENGTH_SHORT).show()

                    // Redirigir al usuario a la actividad principal
                    val intent = Intent(this, Principal::class.java)
                    startActivity(intent)  // Iniciar la actividad principal
                    finish()  // Finalizar LoginActivity para que el usuario no pueda volver a ella al presionar el botón atrás
                } else {
                    // Error en el login
                    Toast.makeText(this, "Autenticación fallida. Intente de nuevo.", Toast.LENGTH_SHORT).show()
                }
            }
    }
}