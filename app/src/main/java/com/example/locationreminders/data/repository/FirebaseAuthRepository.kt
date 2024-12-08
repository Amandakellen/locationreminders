package com.example.locationreminders.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider

class FirebaseAuthRepository {
    private val firebaseAuth = FirebaseAuth.getInstance()
    private val _user = MutableLiveData<FirebaseUser?>()
    val user: LiveData<FirebaseUser?> = _user

    init {
        _user.value = firebaseAuth.currentUser
    }

    fun login(email: String, password: String, onResult: (Boolean) -> Unit) {
        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            _user.value = firebaseAuth.currentUser
            onResult(task.isSuccessful)
        }
    }

    fun logout() {
        firebaseAuth.signOut()
        _user.value = null
    }

    fun register(email: String, password: String, onResult: (Boolean) -> Unit) {
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            _user.value = firebaseAuth.currentUser
            onResult(task.isSuccessful)
        }
    }

    fun loginWithGoogle(account: GoogleSignInAccount, onResult: (Boolean) -> Unit) {
        val credential = GoogleAuthProvider.getCredential(account.idToken, null)
        firebaseAuth.signInWithCredential(credential)
            .addOnCompleteListener { task ->
                onResult(task.isSuccessful)
            }
    }
}