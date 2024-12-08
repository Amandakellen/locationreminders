package com.example.locationreminders.presentation.view.reminders

import android.Manifest
import android.app.AlertDialog
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import android.widget.Toast
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import android.location.Location
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.example.locationreminders.R
import com.example.locationreminders.databinding.FragmentRemindersBinding

class RemindersFragment : Fragment(), OnMapReadyCallback {

    private val LOCATION_PERMISSION_REQUEST_CODE = 1
    private lateinit var mMap: GoogleMap
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private var selectedLocation: LatLng? = null
    private var _binding: FragmentRemindersBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRemindersBinding.inflate(inflater, container, false)
        // Solicitar permissão para acessar a localização
        if (ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            requestPermissions(
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                LOCATION_PERMISSION_REQUEST_CODE
            )
        } else {
            // Se a permissão já foi concedida, inicializa o mapa
            initializeMap()
        }
        return binding.root
    }

    override fun onRequestPermissionsResult(
        requestCode: Int, permissions: Array<out String>, grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                initializeMap()
            } else {
                Toast.makeText(context, "Permissão de localização negada", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun initializeMap() {
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireContext())
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        if (ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            mMap.isMyLocationEnabled = true
            fusedLocationClient.lastLocation.addOnSuccessListener { location: Location? ->
                if (location != null) {
                    val currentLatLng = LatLng(location.latitude, location.longitude)
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(currentLatLng, 15f))
                }
            }
        }

        mMap.setOnMapClickListener { latLng ->
            selectedLocation = latLng
            mMap.addMarker(MarkerOptions().position(latLng).title("Novo POI"))
            showReminderDialog(latLng)
        }
    }

    private fun showReminderDialog(latLng: LatLng) {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Adicionar Lembrete")

        val view = layoutInflater.inflate(R.layout.dialog_add_reminder, null)
        val titleEditText = view.findViewById<EditText>(R.id.reminderTitle)
        val descriptionEditText = view.findViewById<EditText>(R.id.reminderDescription)

        builder.setView(view)
        builder.setPositiveButton("Salvar") { _, _ ->
            val title = titleEditText.text.toString()
            val description = descriptionEditText.text.toString()

            // Aqui você pode salvar o lembrete no banco de dados ou em algum repositório
            saveReminder(title, description, latLng)
        }

        builder.setNegativeButton("Cancelar", null)
        builder.show()
    }

    private fun saveReminder(title: String, description: String, location: LatLng) {
        // Lógica para salvar o lembrete com o título, descrição e localização
        // Aqui você pode armazenar isso no banco de dados local ou algum repositório
        Toast.makeText(context, "Lembrete salvo com sucesso", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
