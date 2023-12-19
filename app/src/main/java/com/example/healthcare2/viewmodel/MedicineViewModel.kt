package com.example.healthcare2.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.healthcare2.data.model.Medicine
import com.example.healthcare2.data.repository.MedicineRepository

class MedicineViewModel(application: Application) : AndroidViewModel(application) {
    private val medicineRepository: MedicineRepository = MedicineRepository(application)

    fun getMedicine(idMedicine : Int) : LiveData<Medicine>{ return medicineRepository.getMedicine(idMedicine)}
    fun getListMedicine() : LiveData<List<Medicine>> { return medicineRepository.getListMedicine()}

}