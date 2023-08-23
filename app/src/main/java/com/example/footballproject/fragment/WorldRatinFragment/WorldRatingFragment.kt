package com.example.footballproject.fragment.WorldRatinFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.footballproject.R
import com.example.footballproject.databinding.FragmentWorlRatingBinding
import com.example.footballproject.fragment.groupfragment.GroupFragment
import com.example.footballproject.fragment.pastgame.PastFragment
import com.example.footballproject.viewmodel.FootballViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class WorldRatingFragment : Fragment() {

    private lateinit var binding: FragmentWorlRatingBinding
    private val adapter = RatingAdapter()
    private val viewModel by viewModels<FootballViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWorlRatingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initBtn()
    }

    private fun initBtn() {
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
    }

    private fun initView() {
        binding.rv.adapter = adapter
        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            viewModel.football.collect{
                adapter.submitList(it.rating)
            }
        }
        viewModel.loadRating()
    }
}