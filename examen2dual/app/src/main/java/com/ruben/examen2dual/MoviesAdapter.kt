package com.ruben.examen2dual

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ruben.examen2dual.data.MoviesEntity

class MoviesAdapter
    (
    var moviesList: List<MoviesEntity> = emptyList()
) :
    RecyclerView.Adapter<MoviesViewHolder>() {

    fun updateList(list: List<MoviesEntity>) {
        moviesList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        return MoviesViewHolder(

            LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        )
    }

    override fun getItemCount() = moviesList.size
    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.bind(moviesList[position])
    }


}