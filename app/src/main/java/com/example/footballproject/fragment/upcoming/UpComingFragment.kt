package com.example.footballproject.fragment.upcoming

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.domain.model.UpcomingModel
import com.example.footballproject.R
import com.example.footballproject.databinding.FragmentUpComingBinding
import com.example.footballproject.fragment.WorldRatinFragment.WorldRatingFragment
import com.example.footballproject.fragment.groupfragment.GroupFragment
import com.example.footballproject.fragment.pastgame.PastFragment
import com.example.footballproject.fragment.upcoming.previewfragment.PreviewFragment
import com.example.footballproject.viewmodel.FootballViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UpComingFragment : Fragment() {
    private lateinit var binding: FragmentUpComingBinding
    private val adapter = UpcomingAdapter(this::onClick)
    private val viewModel by viewModels<FootballViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUpComingBinding.inflate(inflater, container, false)
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
        binding.linearPast.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fr_container, PastFragment())
                .addToBackStack(null)
                .commit()
        }
    }

    private fun initView(name:String) {
        binding.rv.adapter = adapter
        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            viewModel.football.collect{
                adapter.submitList(it.upcoming)
            }
        }
        viewModel.loadUpcoming(name)
    }

    private fun onClick(model: UpcomingModel) {
        val fragment = PreviewFragment()
        val bundle = Bundle()
        bundle.putInt("selectedGameId", model.id)
        bundle.putInt("imgCountry1", model.imgCountry1)
        bundle.putInt("imgCountry2", model.imgCountry2)
        bundle.putString("countryName1", model.countryName1)
        bundle.putString("countryName2", model.countryName2)
        bundle.putString("time", model.time)
        bundle.putInt("refereeImg", model.refereeCountryImg)
        bundle.putString("referee", model.referee)
        bundle.putString("stadium", model.stadium)
        bundle.putInt("stadiumMuch", model.muchStadium)


        fragment.arguments = bundle
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fr_container, fragment)
            .addToBackStack(null)
            .commit()

    }
}