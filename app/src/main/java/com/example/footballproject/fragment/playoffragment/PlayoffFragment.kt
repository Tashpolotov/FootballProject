package com.example.footballproject.fragment.playoffragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.footballproject.R
import com.example.footballproject.databinding.FragmentPlayoffBinding
import com.example.footballproject.fragment.WorldRatinFragment.WorldRatingFragment
import com.example.footballproject.fragment.groupfragment.GroupFragment
import com.example.footballproject.fragment.pastgame.PastFragment
import com.example.footballproject.viewmodel.FootballViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PlayoffFragment : Fragment() {

    private lateinit var binding:FragmentPlayoffBinding
    private val viewModel by viewModels<FootballViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPlayoffBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.linearGroup.setOnClickListener {
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
        binding.btnRating.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fr_container, WorldRatingFragment())
                .addToBackStack(null)
                .commit()
        }

    }
}