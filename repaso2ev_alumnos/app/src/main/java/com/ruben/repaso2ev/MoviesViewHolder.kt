package com.ruben.repaso2ev

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.ruben.repaso2ev.data.entities.MoviesEntity
import com.ruben.repaso2ev.databinding.ItemLayoutBinding
import com.squareup.picasso.Picasso

class MoviesViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val binding = ItemLayoutBinding.bind(view)
    fun bind(moviesEntity: MoviesEntity) {

        binding.titulo.text = moviesEntity.title
        binding.tvReleaseDate.text = moviesEntity.releaseDate
        binding.tvDirector.text= moviesEntity.director
        binding.tvGenre.text= moviesEntity.genre
        binding.tvDuration.text= moviesEntity.duration
        binding.tvLeadActor.text= moviesEntity.leadActor
        binding.tvSynopsis.text= moviesEntity.synopsis
        binding.tvWriters.text= moviesEntity.writer1 + moviesEntity.writer2 + moviesEntity.writer3 + moviesEntity.writer4
        Picasso.get().load(moviesEntity.image).into(binding.ivMovie)

    }
}