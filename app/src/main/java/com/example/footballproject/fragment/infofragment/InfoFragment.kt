package com.example.footballproject.fragment.infofragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.footballproject.R
import com.example.footballproject.databinding.FragmentInfoBinding
import com.example.footballproject.fragment.WorldRatinFragment.WorldRatingFragment
import com.example.footballproject.fragment.groupfragment.GroupFragment
import com.example.footballproject.fragment.pastgame.PastFragment
import com.example.footballproject.viewmodel.FootballViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InfoFragment : Fragment() {

    private lateinit var binding:FragmentInfoBinding
    private val adapter = PlayersAdapter()
    private val viewModel by viewModels<FootballViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initBtn()
    }

    private fun initBtn() {
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
        binding.btnTable.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fr_container, GroupFragment())
                .addToBackStack(null)
                .commit()
        }
        binding.cardView1.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fr_container, GroupFragment())
                .addToBackStack(null)
                .commit()
        }
    }

    private fun initView() {
        binding.rv.adapter = adapter
        val selectedCountries = arguments?.getStringArrayList("country")
        selectedCountries?.let { countries ->
            viewLifecycleOwner.lifecycleScope.launchWhenCreated {
                for (selectedCountry in countries) {
                    Log.d("InfoFragment", "Calling loadPlayer for country: $selectedCountry")
                    viewModel.loadPlayer(selectedCountry)
                }
                viewModel.football.collect { state ->
                    Log.d("InfoFragment", "Received football state: $state")
                    adapter.submitList(state.player)
                }
            }
        }
    }
}