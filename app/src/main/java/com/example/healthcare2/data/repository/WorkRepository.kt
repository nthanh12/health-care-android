package com.example.healthcare2.data.repository

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.healthcare2.data.api.RetrofitInstance
import com.example.healthcare2.data.model.Work
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.Date

class WorkRepository(application: Application) {
    private var listWorkMutableLiveData: MutableLiveData<List<Work>> = MutableLiveData<List<Work>>()
    fun getListWorkToday() : MutableLiveData<List<Work>>{
        val apiService = RetrofitInstance.getApiService()
        val call : Call<List<Work>> = apiService.listWorkToday
        call.enqueue(object : Callback<List<Work>>{
            override fun onResponse(call: Call<List<Work>>, response: Response<List<Work>>) {
                if (response.isSuccessful){
                    listWorkMutableLiveData.value = response.body()
                    Log.d("SUCCESS", "get list work today successfully")
                }
            }

            override fun onFailure(call: Call<List<Work>>, t: Throwable) {
                Log.d("ERROR", "msg get list work today: " + t.message)
            }

        })
        return listWorkMutableLiveData
    }
    fun getListWorkByDate(date: String) : MutableLiveData<List<Work>>{
        val apiService = RetrofitInstance.getApiService()
        val call : Call<List<Work>> = apiService.getListWorkByDate(date)
        call.enqueue(object : Callback<List<Work>>{
            override fun onResponse(call: Call<List<Work>>, response: Response<List<Work>>) {
                if (response.isSuccessful){
                    listWorkMutableLiveData.value = response.body()
                    Log.d("SUCCESS", "get list work by date successfully")
                }
            }

            override fun onFailure(call: Call<List<Work>>, t: Throwable) {
                Log.d("ERROR", "msg get list work by date: " + t.message)
            }

        })
        return listWorkMutableLiveData
    }
    fun updateIsCheckWork(work: Work){
        Log.d("SUCCESS", "đã chạy vào update isCheck work successfully: ")
        val apiService = RetrofitInstance.getApiService()
        val call : Call<ResponseBody> = apiService.updateIsCheckWork(work)
        call.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.body() != null) {
                    Log.d("SUCCESS", "update isCheck work successfully: " + response.body().toString())
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Log.d("ERROR", "msg update isCheck work: " + t.message)
            }

        })
    }
}