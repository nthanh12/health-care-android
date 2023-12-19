package com.example.healthcare2.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.healthcare2.data.repository.PostRepository

class PostViewModel(application: Application) : AndroidViewModel(application) {
    private val postRepository: PostRepository = PostRepository(application)
    fun getNumPostUser(idUser: Int) : LiveData<Int> { return postRepository.getNumPostUser(idUser)}
    fun getListNumPostDoctor() : LiveData<List<Int>> { return postRepository.getListNumPostDoctor()}
}