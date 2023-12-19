package com.example.healthcare2.view
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.healthcare2.R
import com.example.healthcare2.adapter.MedicinesAdapter
import com.example.healthcare2.databinding.FragmentMedicinesBinding
import com.example.healthcare2.viewmodel.MedicineViewModel

class MedicinesFragment : Fragment() {
    private lateinit var binding: FragmentMedicinesBinding
    private lateinit var medicineViewModel: MedicineViewModel
    private lateinit var recyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMedicinesBinding.inflate(layoutInflater)
        medicineViewModel = ViewModelProvider(this).get(MedicineViewModel::class.java)
        recyclerView = binding.recyclerViewMedicines
        getMedicineList()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnReturn.setOnClickListener {
            findNavController().navigateUp()
        }
        binding.btnAddMedicine.setOnClickListener {
            findNavController().navigate(R.id.action_medicinesFragment_to_addMedicinesFragment)
        }
    }

    fun getMedicineList() {
        medicineViewModel.getListMedicine().observe(viewLifecycleOwner) { listMedicine ->
            recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
            val medicinesAdapter = MedicinesAdapter(requireContext(), listMedicine, R.layout.item_medicines)
            val navController = Navigation.findNavController(requireView())
            medicinesAdapter.setNavController(navController)
            recyclerView.adapter = medicinesAdapter

        }
    }
}