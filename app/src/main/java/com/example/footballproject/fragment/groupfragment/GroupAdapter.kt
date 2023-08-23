package com.example.footballproject.fragment.groupfragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.model.CountryModel
import com.example.footballproject.databinding.ItemGroupBinding


class GroupAdapter(val onClick:(CountryModel)->Unit):ListAdapter<CountryModel, GroupAdapter.GroupViewHolder>(GroupDiff()) {

    companion object {
        val alphabet = listOf("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z")
    }

    inner class GroupViewHolder(val binding: com.example.footballproject.databinding.ItemGroupBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(model: CountryModel) {

           binding.tvCountryName.text = model.country
            binding.tvA1.text= model.a1
            Glide.with(binding.root)
                .load(model.img)
                .into(binding.imgCountry)

            val groupIndex = position / 4
            binding.tvGroupA.text = if (groupIndex < alphabet.size) "Group ${alphabet[groupIndex]}" else ""

            if (position % 4 == 0 || position == itemCount - 1) {
                binding.const1.visibility = View.VISIBLE
            } else {
                binding.const1.visibility = View.GONE
            }

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
