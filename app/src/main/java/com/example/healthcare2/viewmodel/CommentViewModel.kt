package com.example.healthcare2.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.healthcare2.data.model.Comment
import com.example.healthcare2.data.model.Medicine
import com.example.healthcare2.data.model.Rating
import com.example.healthcare2.data.repository.CommentRepository

class CommentViewModel(application: Application) : AndroidViewModel(application) {
    private val commentRepository: CommentRepository = CommentRepository(application)
    fun getNumAllCommentMedicine(idMedicine: Int) : LiveData<Int> { return commentRepository.getNumAllCommentMedicine(idMedicine)}
    fun getCommentMedicine(idMedicine: Int) : LiveData<List<Comment>>{ return commentRepository.getCommentMecicidne(idMedicine)}
    fun getIsCommentMedicine(idMedicine: Int, idUser: Int) : LiveData<Int> { return commentRepository.getIsCommentMedicine(idMedicine, idUser)}
    fun addCommentMedicine(comment: Comment)  { return commentRepository.addCommentMedicine(comment)}
    fun getListCommentNotification(idUser: Int) : LiveData<List<Comment>> { return commentRepository.getCommentNotification(idUser)}

}