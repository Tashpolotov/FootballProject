package com.example.footballproject.fragment.pastgame.resultfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.footballproject.R
import com.example.footballproject.databinding.FragmentResultBinding
import com.example.footballproject.fragment.WorldRatinFragment.WorldRatingFragment
import com.example.footballproject.fragment.groupfragment.GroupFragment
import com.example.footballproject.fragment.pastgame.PastFragment

class ResultFragment : Fragment() {

    private lateinit var binding: FragmentResultBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
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
                .replace(R.id.fr_container, PastFragment())
                .addToBackStack(null)
                .commit()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBtn()
        val gameId = arguments?.getInt("gameId")
        val imgCountry1 = arguments?.getInt("imgCountry1")
        val imgCountry2 = arguments?.getInt("imgCountry2")
        val countryName1 = arguments?.getString("countryName1")
        val countryName2 = arguments?.getString("countryName2")
        val countryScore1 = arguments?.getString("countryScore1")
        val countryScore2 = arguments?.getString("countryScore2")


        val corner1 = arguments?.getString("corner1")
        val corner2 = arguments?.getString("corner2")
        val attack1 = arguments?.getString("attack1")
        val attack2 = arguments?.getString("attack2")
        val yellow1 = arguments?.getString("yellow1")
        val yellow2 = arguments?.getString("yellow2")
        val penalties1 = arguments?.getString("penalties1")
        val penalties2 = arguments?.getString("penalties2")



        binding.img1.setImageResource(imgCountry1 ?: com.example.data.R.drawable.ecuador)
        binding.img2.setImageResource(imgCountry2 ?: com.example.data.R.drawable.ecuador)
        binding.tvNameCountry.text = countryName1
        binding.tvNameCountry2.text = countryName2
        binding.tvScore1Country.text = countryScore1
        binding.tvScore2Country.text = countryScore2
        binding.tvCountry1Goals.text = countryScore1
        binding.tvCountry2Goals.text = countryScore2
        binding.tvCountry1Corner.text = corner1
        binding.tvCountry2Corner.text = corner2
        binding.tvCountry1Attaks.text = attack1
        binding.tvCountry2Attaks.text = attack2
        binding.tvCountry1YellowCard.text = yellow1
        binding.tvCountry2YellowCard.text = yellow1
        binding.tvCountry1Penalties.text = penalties1
        binding.tvCountry2Penalties.text = penalties2
    }
}