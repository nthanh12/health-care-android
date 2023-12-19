package com.example.healthcare2.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.healthcare2.R
import com.example.healthcare2.adapter.WorkAdapter
import com.example.healthcare2.data.model.Work
import com.example.healthcare2.databinding.FragmentScheduleBinding
import com.example.healthcare2.viewmodel.WorkViewModel
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class ScheduleFragment : Fragment(){
    private lateinit var binding : FragmentScheduleBinding
    private lateinit var recyclerView : RecyclerView
    private lateinit var workList : List<Work>
    private lateinit var workAdapter : WorkAdapter
    private lateinit var workViewModel: WorkViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentScheduleBinding.inflate(layoutInflater)
        recyclerView = binding.recyclerViewListWork
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        getListWorkToday()
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.simpleCalendarView.setOnDateChangeListener { calendarView, year, month, dayOfMonth ->
            val formattedMonth = (month + 1).toString().padStart(2, '0')
            val formattedDay = dayOfMonth.toString().padStart(2, '0')
            val dateStr = "$year-$formattedMonth-$formattedDay"
            Log.d("DATE_STRING", dateStr)
            getListWorkByDate(dateStr)
        }
    }
    fun getListWorkToday(){
        workViewModel = ViewModelProvider(this).get(WorkViewModel::class.java)
        workViewModel.getListWorkToday().observe(viewLifecycleOwner) { workListByDate ->
                workList = workListByDate
                workAdapter = WorkAdapter(requireContext(), workList, R.layout.item_work, workViewModel)
                recyclerView.adapter = workAdapter
        }

    }
    fun getListWorkByDate(dateString : String){
        workViewModel.getListWorkByDate(dateString).observe(viewLifecycleOwner) { workListByDate ->
                workList = workListByDate
                workAdapter = WorkAdapter(requireContext(), workList, R.layout.item_work, workViewModel)
                recyclerView.adapter = workAdapter
        }

    }
}