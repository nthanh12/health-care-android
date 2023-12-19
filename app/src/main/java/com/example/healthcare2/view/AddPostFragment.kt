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
import com.example.healthcare2.databinding.FragmentAddPostBinding
import com.example.healthcare2.viewmodel.PostViewModel

class AddPostFragment : Fragment() {
    private lateinit var binding: FragmentAddPostBinding
    private lateinit var postViewModel: PostViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddPostBinding.inflate(layoutInflater)
        postViewModel = ViewModelProvider(this).get(PostViewModel::class.java)

        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnReturn.setOnClickListener {
            findNavController().navigateUp()
        }
    }

}