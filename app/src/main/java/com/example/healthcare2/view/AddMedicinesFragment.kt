package com.example.healthcare2.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.healthcare2.R
import com.example.healthcare2.databinding.FragmentAddMedicinesBinding
import com.example.healthcare2.viewmodel.MedicineViewModel

class AddMedicinesFragment : Fragment() {
    private lateinit var binding: FragmentAddMedicinesBinding
    private lateinit var medicineViewModel: MedicineViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddMedicinesBinding.inflate(layoutInflater)
        medicineViewModel = ViewModelProvider(this).get(MedicineViewModel::class.java)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnReturn.setOnClickListener {
            findNavController().navigateUp()
        }
    }

}