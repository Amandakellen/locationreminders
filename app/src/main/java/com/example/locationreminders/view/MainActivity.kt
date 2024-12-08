package com.example.locationreminders.view

import com.example.locationreminders.R

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.locationreminders.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class MainActivity : FragmentActivity() {

    private lateinit var navController: NavController
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Inicializa o Firebase Auth
        mAuth = FirebaseAuth.getInstance()

        // Configuração do NavController para navegação
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        // Verifica se o usuário está logado, senão navega para o LoginFragment
        if (mAuth.currentUser != null) {
            navController.navigate(R.id.remindersFragment)
        } else {
            navController.navigate(R.id.loginFragment)
        }
    }
}
