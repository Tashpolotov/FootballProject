package com.example.footballproject.fragment.WorldRatinFragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.model.RatingModel
import com.example.footballproject.databinding.ItemRatingBinding

class RatingAdapter:ListAdapter<RatingModel, RatingAdapter.RatingViewHolder>(RatingDiff()) {


    inner class RatingViewHolder(private val binding:ItemRatingBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(model: RatingModel) {
            binding.tvNumber.text = model.number.toString()
            binding.tvCountryName.text = model.nameCountry
            binding.tvPts.text = model.pts.toString()
            Glide.with(binding.root)
                .load(model.imgCountry)
                .into(binding.imgCountry)

            itemView.isActivated = position % 2 == 1 //
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RatingViewHolder {
        return RatingViewHolder(ItemRatingBinding.inflate(LayoutInflater.from(parent.context), parent,false))
    }

    override fun onBindViewHolder(holder: RatingViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class RatingDiff:DiffUtil.ItemCallback<RatingModel>() {
    override fun areItemsTheSame(oldItem: RatingModel, newItem: RatingModel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: RatingModel, newItem: RatingModel): Boolean {
        return  oldItem == newItem
    }

}
