package com.example.healthcare2.data.repository;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.healthcare2.data.api.RestApiService;
import com.example.healthcare2.data.api.RetrofitInstance;
import com.example.healthcare2.data.model.Doctor;
import com.example.healthcare2.data.model.User;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DoctorRepository {
    private Application application;


    private MutableLiveData<Doctor> doctorMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<List<Doctor>> listDoctorMutableLiveData = new MutableLiveData<List<Doctor>>();

    public DoctorRepository(Application application) {
        this.application = application;
    }
    public MutableLiveData<Doctor> getDoctor(int idUser){
        RestApiService apiService = RetrofitInstance.getApiService();
        Call<Doctor> call = apiService.getDoctor(idUser);
        call.enqueue(new Callback<Doctor>() {
            @Override
            public void onResponse(Call<Doctor> call, Response<Doctor> response) {
                if (response.body() != null){
                    Doctor doctor = response.body();
                    doctorMutableLiveData.setValue(doctor);
                    Log.d("SUCCESS", doctor.toString());
                }
            }

            @Override
            public void onFailure(Call<Doctor> call, Throwable t) {
                Log.d("ERROR", "msg: " + t.getMessage());
                System.out.println("Lỗi: " + t.getMessage());
            }
        });
        return doctorMutableLiveData;
    }
    public MutableLiveData<List<Doctor>> getListDoctor(){
        RestApiService apiService = RetrofitInstance.getApiService();
        Call<List<Doctor>> call = apiService.getListDoctor();
        call.enqueue(new Callback<List<Doctor>>() {
            @Override
            public void onResponse(Call<List<Doctor>> call, Response<List<Doctor>> response) {
                if (response.isSuccessful()){
                    listDoctorMutableLiveData.setValue(response.body());
                    Log.d("SUCCESS", "get list doctor successfully");
                }
            }

            @Override
            public void onFailure(Call<List<Doctor>> call, Throwable t) {
                Log.d("ERROR", "msg get list doctor: " + t.getMessage());
                System.out.println("Lỗi: " + t.getMessage());
            }
        });
        return listDoctorMutableLiveData;
    }
}
