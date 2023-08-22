package com.example.footballproject.fragment.upcoming.previewfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.footballproject.R
import com.example.footballproject.databinding.FragmentPreviewBinding
import com.example.footballproject.fragment.WorldRatinFragment.WorldRatingFragment
import com.example.footballproject.fragment.groupfragment.GroupFragment
import com.example.footballproject.fragment.pastgame.PastFragment
import com.example.footballproject.fragment.upcoming.UpComingFragment

class PreviewFragment : Fragment() {

    private lateinit var binding:FragmentPreviewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPreviewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBtn()
        val gameId = arguments?.getInt("gameId")
        val imgCountry1 = arguments?.getInt("imgCountry1")
        val imgCountry2 = arguments?.getInt("imgCountry2")
        val countryName1 = arguments?.getString("countryName1")
        val countryName2 = arguments?.getString("countryName2")
        val time = arguments?.getString("time")
        val refereeImg = arguments?.getInt("refereeImg")
        val referee = arguments?.getString("referee")
        val stadium = arguments?.getString("stadium")
        val stadiumMuch = arguments?.getInt("stadiumMuch")


        binding.img1.setImageResource(imgCountry1 ?: com.example.data.R.drawable.ecuador)
        binding.img2.setImageResource(imgCountry2 ?: com.example.data.R.drawable.qatar)
        binding.tvNameCountry.text = countryName1
        binding.tvNameCountry2.text = countryName2
        binding.tvTime.text = time
        binding.imgReferee.setImageResource(refereeImg ?: com.example.data.R.drawable.ecuador)
        binding.tvNameReferee.text = referee
        binding.tvStadium.text = stadium
        binding.tvPeopleStadim.text = stadiumMuch.toString()
    }

    private fun initBtn() {
        binding.btnRating.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fr_container, WorldRatingFragment())
                .addToBackStack(null)
                .commit()
        }
        binding.btnTable.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fr_container, GroupFragment())
                .addToBackStack(null)
                .commit()
        }
        binding.btnMatches.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fr_container, PastFragment())
                .addToBackStack(null)
                .commit()
        }
        binding.cardView1.setOnClickListener{
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fr_container, UpComingFragment())
                .addToBackStack(null)
                .commit()
        }
    }
}