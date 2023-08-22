package com.example.footballproject.fragment.groupfragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.model.CountryModel
import com.example.footballproject.databinding.ItemGroupBinding


class GroupAdapter(val onClick:(CountryModel)->Unit):ListAdapter<CountryModel, GroupAdapter.GroupViewHolder>(GroupDiff()) {


    inner class GroupViewHolder(val binding: com.example.footballproject.databinding.ItemGroupBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(model: CountryModel) {
            binding.tvGroupA.text = model.group[0]
            Glide.with(binding.root).load(model.img[0]).into(binding.imgCountry)
            Glide.with(binding.root).load(model.img[1]).into(binding.imgCountry2)
            Glide.with(binding.root).load(model.img[2]).into(binding.imgCountry3)
            Glide.with(binding.root).load(model.img[3]).into(binding.imgCountry4)

            binding.tvCountryName.text = model.country[0]
            binding.tvCountryName2.text = model.country[1]
            binding.tvCountryName3.text = model.country[2]
            binding.tvCountryName4.text = model.country[3]

            itemView.isActivated = position % 2 == 1 //
            itemView.setOnClickListener {
                onClick(model)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupViewHolder {
        return GroupViewHolder(ItemGroupBinding.inflate(LayoutInflater.from(parent.context), parent,false))
    }

    override fun onBindViewHolder(holder: GroupViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class GroupDiff:DiffUtil.ItemCallback<CountryModel>() {
    override fun areItemsTheSame(oldItem: CountryModel, newItem: CountryModel): Boolean {
        return oldItem.country == newItem.country
    }

    override fun areContentsTheSame(oldItem: CountryModel, newItem: CountryModel): Boolean {
        return oldItem == newItem
    }

}
