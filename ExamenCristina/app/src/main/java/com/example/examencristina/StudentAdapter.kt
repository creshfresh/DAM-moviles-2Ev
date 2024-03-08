package com.example.examencristina

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.data.database.StudentEntity

class StudentAdapter (
    var studentList: List<StudentEntity> = emptyList()
) :
    RecyclerView.Adapter<StudentViewHolder>() {

    fun updateList(list: List<StudentEntity>) {
        studentList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        return StudentViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.activity_item, parent, false)
        )
    }

    override fun getItemCount() = studentList.size
    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.bind(studentList[position])
    }


}