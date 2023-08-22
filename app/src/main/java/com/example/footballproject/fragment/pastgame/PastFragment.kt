package com.example.footballproject.fragment.pastgame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.domain.model.PasteGameModel
import com.example.footballproject.R
import com.example.footballproject.databinding.FragmentPastBinding
import com.example.footballproject.fragment.upcoming.UpComingFragment
import com.example.footballproject.fragment.WorldRatinFragment.WorldRatingFragment
import com.example.footballproject.fragment.groupfragment.GroupFragment
import com.example.footballproject.fragment.pastgame.resultfragment.ResultFragment
import com.example.footballproject.viewmodel.FootballViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PastFragment : Fragment() {

    private lateinit var binding: FragmentPastBinding
    private val adapter = PastAdapter(this::onClick)

    private val viewModel by viewModels<FootballViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPastBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(name = String())
        initBtn()
    }

    private fun initBtn() {
        binding.btnTable.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fr_container, GroupFragment())
                .addToBackStack(null)
                .commit()
        }
        binding.btnRating.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fr_container, WorldRatingFragment())
                .addToBackStack(null)
                .commit()
        }
        binding.linearUpcoming.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fr_container, UpComingFragment())
                .addToBackStack(null)
                .commit()
        }
    }

    private fun initView(name:String) {
        binding.rv.adapter = adapter
        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            viewModel.football.collect{
                adapter.submitList(it.pastGame)
            }
        }
        viewModel.loadPastGame(name)
    }

    private fun onClick(model: PasteGameModel) {
        val fragment = ResultFragment()
        val bundle = Bundle()
        bundle.putInt("selectedGameId", model.id)
        bundle.putInt("imgCountry1", model.imgCountry1)
        bundle.putInt("imgCountry2", model.imgCountry2)
        bundle.putString("countryName1", model.countryName1)
        bundle.putString("countryName2", model.countryName2)
        bundle.putString("countryScore1", model.team1Score.toString())
        bundle.putString("countryScore2", model.team2Score.toString())
        bundle.putString("corner1", model.team1Corner.toString())
        bundle.putString("corner2", model.team2Corner.toString())
        bundle.putString("attack1", model.team1Attack.toString())
        bundle.putString("attack2", model.team2Attack.toString())
        bundle.putString("yellow1", model.team1YellowCard.toString())
        bundle.putString("yellow2", model.team2YellowCard.toString())
        bundle.putString("penalties1", model.team1Penalties.toString())
        bundle.putString("penalties2", model.team2Penalties.toString())

        fragment.arguments = bundle
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fr_container, fragment)
            .addToBackStack(null)
            .commit()

    }
}