package com.example.locationreminders.view.reminders


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.locationreminders.databinding.FragmentRemindersBinding

class RemindersFragment : Fragment() {

    private lateinit var binding: FragmentRemindersBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRemindersBinding.inflate(inflater, container, false)

        // Lógica da tela de lembretes

        return binding.root
    }
}
