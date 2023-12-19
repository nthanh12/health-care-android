package com.example.healthcare2.data.repository

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.healthcare2.data.api.RetrofitInstance
import com.example.healthcare2.data.model.Medicine
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MedicineRepository (application: Application){
    private var medicineMutableLiveData = MutableLiveData<Medicine>()
    private var listMedicineMutableLiveData = MutableLiveData<List<Medicine>>()

    fun getMedicine(idMedicine:Int) : MutableLiveData<Medicine>{
        val apiService = RetrofitInstance.getApiService()
        val call : Call<Medicine> = apiService.getMedicine(idMedicine)
        call.enqueue(object : Callback<Medicine?> {
            override fun onResponse(call: Call<Medicine?>, response: Response<Medicine?>) {
                if (response.body() != null) {
                    val medicine : Medicine = response.body()!!
                    medicineMutableLiveData.setValue(medicine)
                    Log.d("SUCCESS", medicine.toString())
                }
            }

            override fun onFailure(call: Call<Medicine?>, t: Throwable) {
                Log.d("ERROR", "msg: " + t.message)
                println("Lỗi: " + t.message)
            }
        })
        return medicineMutableLiveData
    }
    fun getListMedicine() : MutableLiveData<List<Medicine>>{
        val apiService = RetrofitInstance.getApiService()
        val call : Call<List<Medicine>> = apiService.medicineList
        call.enqueue(object : Callback<List<Medicine>> {
            override fun onResponse(
                call: Call<List<Medicine>>,
                response: Response<List<Medicine>>
            ) {
                if (response.isSuccessful){
                    listMedicineMutableLiveData.value = response.body()
                    Log.d("SUCCESS", "Get list medicine successfully")
                }
            }

            override fun onFailure(call: Call<List<Medicine>>, t: Throwable) {
                Log.d("ERROR", "msg get list medicine: " + t.message)
                println("Lỗi: " + t.message)
            }

        })
        return listMedicineMutableLiveData
    }
}