package com.example.footballproject.fragment.upcoming

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.model.UpcomingModel
import com.example.footballproject.R
import com.example.footballproject.databinding.ItemUpcomingBinding

class UpcomingAdapter(val onClick:(UpcomingModel)-> Unit): ListAdapter<UpcomingModel, UpcomingAdapter.PastViewHolder>(PastDiff()) {

    inner class PastViewHolder(val binding: ItemUpcomingBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(model: UpcomingModel, position: Int) {
            binding.tvCountryName.text = model.countryName1
            binding.tvCountryName2.text = model.countryName2
            binding.tvData.text = model.date
            binding.tvTime.text = model.time
            Glide.with(binding.root)
                .load(model.imgCountry1)
                .into(binding.imgCountry)
            Glide.with(binding.root)
                .load(model.imgCountry2)
                .into(binding.imgCountry2)

            Log.d("AdapterAzamat", "Position: $position, Background: ${binding.root.background}")

            itemView.isActivated = position % 2 == 1 //

            itemView.setOnClickListener {
                onClick(model)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PastViewHolder {
        return PastViewHolder(
            ItemUpcomingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PastViewHolder, position: Int) {
        holder.bind(getItem(position), position)
    }
}

class PastDiff:DiffUtil.ItemCallback<UpcomingModel>() {
    override fun areItemsTheSame(oldItem: UpcomingModel, newItem: UpcomingModel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: UpcomingModel, newItem: UpcomingModel): Boolean {
        return oldItem == newItem
    }

}
