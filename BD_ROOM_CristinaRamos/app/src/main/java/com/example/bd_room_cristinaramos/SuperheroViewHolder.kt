package com.example.bd_room_cristinaramos
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.bd_room_cristinaramos.data.entities.SuperHeroEntity
import com.example.bd_room_cristinaramos.databinding.ItemSuperheroBinding
import com.squareup.picasso.Picasso

class SuperheroViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemSuperheroBinding.bind(view)

    fun bind(superHeroEntity: SuperHeroEntity,  navigateToDetailActivity: (String) -> Unit) {

        binding.tvSuperheroName.text = superHeroEntity.name
        Picasso.get().load(superHeroEntity.image).into(binding.ivSuperhero)

        binding.root.setOnClickListener {
            navigateToDetailActivity(superHeroEntity.id.toString())
        }

    }
}