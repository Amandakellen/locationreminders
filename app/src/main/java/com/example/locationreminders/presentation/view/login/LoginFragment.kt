package com.example.locationreminders.presentation.view.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.locationreminders.R
import com.example.locationreminders.databinding.FragmentLoginBinding
import com.example.locationreminders.presentation.viewModel.login.LoginViewModel
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.auth.api.signin.GoogleSignInStatusCodes
import com.google.android.gms.common.api.ApiException

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private val loginViewModel: LoginViewModel by viewModels()
    private lateinit var googleSignInClient: GoogleSignInClient

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        googleSignInClient = GoogleSignIn.getClient(requireContext(), gso)

        binding.googleLoginButton.setOnClickListener {
            signInWithGoogle()
        }

        binding.loginButton.setOnClickListener {
            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()
            loginViewModel.login(email, password) { success ->
                if (success) {
                    Toast.makeText(requireContext(), "Login bem-sucedido!", Toast.LENGTH_SHORT).show()
                    findNavController().navigate(R.id.action_loginFragment_to_remindersFragment)
                } else {
                    Toast.makeText(requireContext(), "Erro ao fazer login.", Toast.LENGTH_SHORT).show()
                }
            }
        }

        binding.signupTextView.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_signUpFragment)
        }
    }

    private val googleSignInLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
        try {
            val account = task.getResult(ApiException::class.java)
            account?.let {
                loginViewModel.loginWithGoogle(it) { success ->
                    if (success) {
                        Toast.makeText(requireContext(), "Login com Google bem-sucedido!", Toast.LENGTH_SHORT).show()
                        findNavController().navigate(R.id.action_loginFragment_to_remindersFragment)
                    } else {
                        Toast.makeText(requireContext(), "Erro ao autenticar com Google.", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        } catch (e: ApiException) {
            e.printStackTrace()
            val errorMessage = when (e.statusCode) {
                GoogleSignInStatusCodes.SIGN_IN_CANCELLED -> "Login cancelado pelo usuário."
                GoogleSignInStatusCodes.SIGN_IN_FAILED -> "Falha no login. Verifique sua configuração."
                GoogleSignInStatusCodes.NETWORK_ERROR -> "Erro de rede. Verifique sua conexão."
                else -> "Erro desconhecido: ${e.localizedMessage}"
            }
            Toast.makeText(requireContext(), "Falha no login com Google: $errorMessage", Toast.LENGTH_LONG).show()
        }
    }

    private fun signInWithGoogle() {
        val signInIntent = googleSignInClient.signInIntent
        googleSignInLauncher.launch(signInIntent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
