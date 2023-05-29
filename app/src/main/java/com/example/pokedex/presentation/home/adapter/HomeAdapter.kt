package com.example.pokedex.presentation.home.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.pokedex.framework.network.response.PokemonResult
import com.example.pokedex.presentation.home.viewholder.HomeViewHolder

class HomeAdapter: ListAdapter<PokemonResult, HomeViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
       return HomeViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        private val diffCallback = object: DiffUtil.ItemCallback<PokemonResult>(){
            override fun areItemsTheSame(
                oldItem: PokemonResult,
                newItem: PokemonResult
            ): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(
                oldItem: PokemonResult,
                newItem: PokemonResult
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}