package com.example.healthcare2.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.healthcare2.data.model.Work
import com.example.healthcare2.data.repository.WorkRepository

class WorkViewModel(application: Application) : AndroidViewModel(application) {
    private val workRepository : WorkRepository = WorkRepository(application)
    fun getListWorkToday(): LiveData<List<Work>> {
        return workRepository.getListWorkToday()
    }

    fun getListWorkByDate(date: String): LiveData<List<Work>> {
        return workRepository.getListWorkByDate(date)
    }

    fun updateIsCheckWork(work: Work) {
        workRepository.updateIsCheckWork(work)
    }
}