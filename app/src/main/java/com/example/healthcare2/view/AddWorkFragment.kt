package com.example.healthcare2.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.healthcare2.databinding.FragmentAddPostBinding
import com.example.healthcare2.databinding.FragmentAddWorkBinding
import com.example.healthcare2.viewmodel.PostViewModel
import com.example.healthcare2.viewmodel.WorkViewModel

class AddWorkFragment : Fragment() {
    private lateinit var binding: FragmentAddWorkBinding
    private lateinit var workViewModel: WorkViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddWorkBinding.inflate(layoutInflater)
        workViewModel = ViewModelProvider(this).get(WorkViewModel::class.java)

        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnReturn.setOnClickListener {
            findNavController().navigateUp()
        }
    }

}