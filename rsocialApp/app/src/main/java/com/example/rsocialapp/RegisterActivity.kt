package com.example.rsocialapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Inicializar Firebase Auth
        auth = FirebaseAuth.getInstance()

        // Referencias a los campos del formulario
        val nameInput = findViewById<EditText>(R.id.editTextName)
        val emailInput = findViewById<EditText>(R.id.editTextEmail)
        val passwordInput = findViewById<EditText>(R.id.editTextPassword)
        val registerButton = findViewById<Button>(R.id.registerButton)

        // Manejo del evento de clic del botón
        registerButton.setOnClickListener {
            val name = nameInput.text.toString().trim()
            val email = emailInput.text.toString().trim()
            val password = passwordInput.text.toString().trim()

            if (name.isEmpty()) {
                Toast.makeText(this, "Por favor, ingresa tu nombre.", Toast.LENGTH_SHORT).show()
            } else if (email.isEmpty()) {
                Toast.makeText(this, "Por favor, ingresa tu correo electrónico.", Toast.LENGTH_SHORT).show()
            } else if (password.isEmpty()) {
                Toast.makeText(this, "Por favor, ingresa tu contraseña.", Toast.LENGTH_SHORT).show()
            } else if (password.length < 6) {
                Toast.makeText(this, "La contraseña debe tener al menos 6 caracteres.", Toast.LENGTH_SHORT).show()
            } else {
                // Llamar a Firebase para crear el usuario
                registerUser(email, password, name)
            }
        }
    }

    private fun registerUser(email: String, password: String, name: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Registro exitoso
                    val user = auth.currentUser
                    Toast.makeText(this, "Registro exitoso. ¡Bienvenido $name!", Toast.LENGTH_SHORT).show()

                    // Puedes agregar más lógica aquí, como guardar el nombre del usuario en Firestore o redirigir a otra actividad
                    // Por ejemplo, navegar al FeedActivity
                    // startActivity(Intent(this, FeedActivity::class.java))
                    // finish() // Para cerrar la actividad de registro
                } else {
                    // Si el registro falla, mostrar el error
                    Toast.makeText(this, "Error en el registro. Intente de nuevo.", Toast.LENGTH_SHORT).show()
                }
            }
    }
}