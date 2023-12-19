package com.example.healthcare2.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.healthcare2.data.model.Doctor;
import com.example.healthcare2.data.repository.DoctorRepository;

import java.util.List;

public class DoctorViewModel extends AndroidViewModel {
    private DoctorRepository doctorRepository;
    public DoctorViewModel(@NonNull Application application) {
        super(application);
        doctorRepository = new DoctorRepository(application);
    }
    public LiveData<List<Doctor>> getListDoctor(){
        return doctorRepository.getListDoctor();
    }
}
