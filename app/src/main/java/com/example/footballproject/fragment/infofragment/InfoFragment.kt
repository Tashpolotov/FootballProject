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
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class InfoFragment : Fragment() {

    private lateinit var binding: FragmentInfoBinding
    private val viewModel by viewModels<FootballViewModel>()
    private val adapter = PlayersAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val flagResId = arguments?.getInt("flag", R.drawable.qatar)
        val country = arguments?.getString("country")
        val name = arguments?.getString("name")
        country?.let {
            viewModel.loadPlayer(it)
            initView(country = it) // Передаем country
        }
        binding.imgCountry.setImageResource(flagResId ?: com.example.data.R.drawable.qatar)
        binding.tvNameCountry.text = name
        initBtn()
    }

    private fun initView(country: String) {
        binding.rv.adapter = adapter
        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            viewModel.football.collect {
                adapter.submitList(it.player)
            }
        }
        viewModel.loadPlayer(country)
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
}
