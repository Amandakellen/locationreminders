package com.example.locationreminders.presentation.view.reminders

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.locationreminders.R
import com.example.locationreminders.presentation.viewModel.reminders.RemindersViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import androidx.recyclerview.widget.RecyclerView
import android.widget.TextView
import androidx.fragment.app.viewModels
import org.koin.androidx.viewmodel.ext.android.viewModel

class RemindersFragment : Fragment() {

    private val viewModel: RemindersViewModel by viewModel()

    private lateinit var remindersAdapter: RemindersAdapter

    private lateinit var remindersRecyclerView: RecyclerView
    private lateinit var emptyTextView: TextView
    private lateinit var addReminderButton: FloatingActionButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_reminders, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inicializa os componentes do layout
        remindersRecyclerView = view.findViewById(R.id.remindersRecyclerView)
        emptyTextView = view.findViewById(R.id.emptyTextView)
        addReminderButton = view.findViewById(R.id.addReminderButton)

        setupRecyclerView()
        setupObservers()
        setupClickListeners()
    }

    private fun setupRecyclerView() {
        remindersAdapter = RemindersAdapter()
        remindersRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = remindersAdapter
        }
    }

    private fun setupObservers() {
      if(viewModel.reminders.value?.isEmpty() == true){

      }
//        viewModel.errorMessage.observe(viewLifecycleOwner, Observer { error ->
//            error?.let {
//                Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show()
//            }
//        })
    }

    private fun setupClickListeners() {
        addReminderButton.setOnClickListener {
            findNavController().navigate(R.id.action_remindersFragment_to_addReminderFragment)
        }
    }
}
