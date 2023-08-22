package com.example.footballproject.fragment.pastgame

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.PasteGameModel
import com.example.footballproject.databinding.ItemPastBinding

class PastAdapter(val onClick:(PasteGameModel)-> Unit):ListAdapter<PasteGameModel, PastAdapter.PastViewHolder>(PastDiff()) {

    inner class PastViewHolder(val binding: ItemPastBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(model: PasteGameModel) {
            binding.tvCountryName.text = model.countryName1
            binding.tvCountryName2.text = model.countryName2
            binding.tvData.text = model.date
            binding.tvScoreTeam1.text = model.team1Score.toString()
            binding.tvScoreTeam2.text = model.team2Score.toString()


            itemView.setOnClickListener {
                onClick(model)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PastViewHolder {
        return PastViewHolder(ItemPastBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: PastViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class PastDiff:DiffUtil.ItemCallback<PasteGameModel>() {
    override fun areItemsTheSame(oldItem: PasteGameModel, newItem: PasteGameModel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: PasteGameModel, newItem: PasteGameModel): Boolean {
        return oldItem == newItem
    }

}
