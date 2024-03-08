package com.ruben.repaso2ev

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ruben.repaso2ev.data.entities.MoviesEntity

class MoviesAdapter( private var movieslist: List<MoviesEntity> = emptyList()) :
    RecyclerView.Adapter<MoviesViewHolder>() {

    fun updateList(list: List<MoviesEntity>) {
        movieslist = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        return MoviesViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int, ) {
        holder.bind(movieslist[position])
    }

    override fun getItemCount() = movieslist.size
}