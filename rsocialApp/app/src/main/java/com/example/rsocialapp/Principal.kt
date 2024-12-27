package com.example.rsocialapp

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class Principal : AppCompatActivity() {

    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager2
    private lateinit var tabAdapter: TabAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)

        // Referencias a los componentes
        tabLayout = findViewById(R.id.tabs)
        viewPager = findViewById(R.id.viewPager)

        // Crear el adaptador para ViewPager2
        tabAdapter = TabAdapter(this)
        viewPager.adapter = tabAdapter

        // Configurar TabLayout con ViewPager
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "Feed"
                1 -> tab.text = "Post"
                2 -> tab.text = "Friends"
            }
        }.attach()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.perfil -> {
                Toast.makeText(this, "Perfil seleccionado", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.setting -> {
                Toast.makeText(this, "Configuración seleccionada", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.help -> {
                Toast.makeText(this, "Ayuda seleccionada", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}