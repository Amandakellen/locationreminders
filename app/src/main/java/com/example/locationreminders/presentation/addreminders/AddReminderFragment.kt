package com.example.locationreminders.presentation.addreminders

import com.example.locationreminders.presentation.viewModel.addreminders.AddReminderViewModel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.locationreminders.databinding.AddReminderFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class AddReminderFragment : Fragment() {

    private val viewModel: AddReminderViewModel by viewModel()
    private lateinit var binding: AddReminderFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = AddReminderFragmentBinding.inflate(inflater, container, false)

        binding.viewModel = viewModel

        binding.saveButton.setOnClickListener {
            viewModel.saveReminder()
            activity?.onBackPressed()
        }

        return binding.root
    }
}
