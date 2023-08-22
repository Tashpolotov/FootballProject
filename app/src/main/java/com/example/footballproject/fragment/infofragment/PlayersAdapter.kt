package com.example.footballproject.fragment.infofragment

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.PlayerModel
import com.example.footballproject.databinding.ItemPlayerBinding

class PlayersAdapter:ListAdapter<PlayerModel, PlayersAdapter.PlayersViewHolder>(PlayerDiff()) {


    inner class PlayersViewHolder(val binding:ItemPlayerBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(model: PlayerModel) {
            Log.d("PlayersAdapter", "Binding data for country: ${model.nameCountry}")
            binding.tvNumberPlayer.text = model.numberPlayer[0].toString()
            binding.tvNumberPlayer2.text = model.numberPlayer[1].toString()


            binding.tvPlayerName.text = model.namePlayer[0].toString()
            binding.tvPlayerName2.text = model.namePlayer[1].toString()

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayersViewHolder {
        return PlayersViewHolder(ItemPlayerBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: PlayersViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class PlayerDiff:DiffUtil.ItemCallback<PlayerModel>() {
    override fun areItemsTheSame(oldItem: PlayerModel, newItem: PlayerModel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: PlayerModel, newItem: PlayerModel): Boolean {
        return oldItem == newItem
    }

}
