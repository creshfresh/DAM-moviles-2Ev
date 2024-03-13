package com.ruben.examen2dual

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.ruben.examen2dual.data.MoviesEntity
import com.ruben.examen2dual.databinding.ItemLayoutBinding
import com.squareup.picasso.Picasso

class MoviesViewHolder(view : View): RecyclerView.ViewHolder(view){
    private val binding =ItemLayoutBinding.bind(view)

    fun bind (moviesEntity: MoviesEntity){

        binding.tvTitle.text = moviesEntity.title
        binding.tvDirector.text = moviesEntity.director
        binding.tvDuration.text = moviesEntity.duration
        binding.tvGenre.text = moviesEntity.genre
        binding.tvReleaseDate.text= moviesEntity.releaseDate
        Picasso.get().load(moviesEntity.image).into((binding.ivMovie))

    }
}