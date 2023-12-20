package com.example.healthcare2.data.repository

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.healthcare2.data.api.RetrofitInstance
import com.example.healthcare2.data.model.Doctor
import com.example.healthcare2.data.model.Medicine
import com.example.healthcare2.data.model.Post
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostRepository(application: Application) {
    private var numPostMutableLiveData = MutableLiveData<Int>()
    private var listNumPostDoctorMutableLiveData = MutableLiveData<List<Int>>()
    private val listPostMutableLiveData = MutableLiveData<List<Post>>()

    fun getNumPostUser(idUser: Int) : MutableLiveData<Int>{
        val apiService = RetrofitInstance.getApiService()
        val call : Call<Int> = apiService.getNumPostUser(idUser)
        call.enqueue(object : Callback<Int> {
            override fun onResponse(call: Call<Int>, response: Response<Int>) {
                numPostMutableLiveData.value = response.body()
            }

            override fun onFailure(call: Call<Int>, t: Throwable) {
                numPostMutableLiveData.value = 0
                Log.d("ERROR", "msg numAllCommentMedicine: " + t.message)
            }

        })
        return numPostMutableLiveData
    }
    fun getListNumPostDoctor() : MutableLiveData<List<Int>>{
        val apiService = RetrofitInstance.getApiService()
        val call : Call<List<Int>> = apiService.listNumPostDoctor
        call.enqueue(object : Callback<List<Int>>{
            override fun onResponse(call: Call<List<Int>>, response: Response<List<Int>>) {
                if (response.isSuccessful){
                    listNumPostDoctorMutableLiveData.value = response.body()
                    Log.d("SUCCESS", "get list num post doctor successfully")
                }
            }

            override fun onFailure(call: Call<List<Int>>, t: Throwable) {
                Log.d("ERROR", "msg listNumPostDoctor: " + t.message)
            }

        })
        return listNumPostDoctorMutableLiveData
    }
    fun getListPost() : MutableLiveData<List<Post>>{
        val apiService = RetrofitInstance.getApiService()
        val call : Call<List<Post>> = apiService.listPost
        call.enqueue(object : Callback<List<Post>> {
            override fun onResponse(
                call: Call<List<Post>>,
                response: Response<List<Post>>
            ) {
                if (response.isSuccessful){
                    listPostMutableLiveData.value = response.body()
                    Log.d("SUCCESS", "Get list medicine successfully")
                }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                Log.d("ERROR", "msg get list medicine: " + t.message)
                println("Lỗi: " + t.message)
            }

        })
        return listPostMutableLiveData
    }

}