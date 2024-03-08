package com.example.consumoapis

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.consumoapis.databinding.ItemGamesBinding
import com.squareup.picasso.Picasso

class VideoGamesViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val binding = ItemGamesBinding.bind(view)
    fun bind (videoGameItemResponse: VideoGameItemResponse){
        binding.tvVideoGameName.text = videoGameItemResponse.videoGameName
        Picasso.get().load(videoGameItemResponse.image).into(binding.ivVideoGameImage)
        binding.tvFechaLanzamientoData.text = videoGameItemResponse.releaseDate
        binding.tvValoracionData.text = videoGameItemResponse.rating.toString()
        getPlatforms(videoGameItemResponse)

    }
    fun getPlatforms(videoGameItemResponse: VideoGameItemResponse) {
        var platformForGame = ""
        for (i in videoGameItemResponse.platforms){
            platformForGame = platformForGame+ i.platform.platformName + ", "
        }
        binding.tvPlataformaData.text = platformForGame

    }

}

