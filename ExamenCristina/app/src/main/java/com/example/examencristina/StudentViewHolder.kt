package com.example.examencristina

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.data.database.StudentEntity
import com.example.examencristina.databinding.ActivityItemBinding

class StudentViewHolder(view :View): RecyclerView.ViewHolder(view){
    private val binding = ActivityItemBinding.bind(view)

    fun bind (studentEntity: StudentEntity){

        binding.tvStudent.text = studentEntity.name
        binding.tvGrade.text = studentEntity.grade.toString()
    }
}