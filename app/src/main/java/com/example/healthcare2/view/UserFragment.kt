package com.example.healthcare2.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.healthcare2.data.model.User
import com.example.healthcare2.databinding.FragmentUserBinding
import com.example.healthcare2.viewmodel.UserViewModel
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class UserFragment : Fragment() {
    private lateinit var binding: FragmentUserBinding
    private lateinit var userViewModel: UserViewModel
    private val auth: FirebaseUser? = Firebase.auth.currentUser
    private lateinit var user: User

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserBinding.inflate(layoutInflater)
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        getUser()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
    fun getUser(){
        userViewModel.getUser(auth?.email).observe(viewLifecycleOwner){ userResponse ->
            user = userResponse
            if (!user.avatar.isNullOrEmpty()) Glide.with(requireContext()).load(user.avatar).into(binding.imgAvatarUser)
            binding.txtNameUser.text = user.nameUser
            binding.txtEmail.text = user.email
        }
    }
}