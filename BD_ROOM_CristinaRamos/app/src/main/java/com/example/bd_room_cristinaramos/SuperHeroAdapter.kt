package com.example.bd_room_cristinaramos

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bd_room_cristinaramos.data.entities.SuperHeroEntity

class SuperheroAdapter( private var superheroList: List<SuperHeroEntity> = emptyList(),
                        private val navigateToDetailActivity: (String) -> Unit) :
    RecyclerView.Adapter<SuperheroViewHolder>() {

    fun updateList(list: List<SuperHeroEntity>) {
        superheroList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperheroViewHolder {
        return SuperheroViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_superhero, parent, false)
        )
    }

    override fun onBindViewHolder(holder: SuperheroViewHolder, position: Int, ) {
        holder.bind(superheroList[position], navigateToDetailActivity)
    }

    override fun getItemCount() = superheroList.size
}