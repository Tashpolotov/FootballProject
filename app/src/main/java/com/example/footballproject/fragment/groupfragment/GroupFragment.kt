package com.example.footballproject.fragment.groupfragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.domain.model.CountryModel
import com.example.footballproject.R
import com.example.footballproject.databinding.FragmentGroupBinding
import com.example.footballproject.fragment.infofragment.InfoFragment
import com.example.footballproject.fragment.WorldRatinFragment.WorldRatingFragment
import com.example.footballproject.fragment.pastgame.PastFragment
import com.example.footballproject.fragment.playoffragment.PlayoffFragment
import com.example.footballproject.viewmodel.FootballViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GroupFragment : Fragment() {

    private lateinit var binding: FragmentGroupBinding
    private val adapter = GroupAdapter(this::onClick)
    private val viewModel by viewModels<FootballViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGroupBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(country = String())
        initListener()
    }

    private fun initListener() {
        binding.linearPlayoff.setOnClickListener {
            fragmentManager?.beginTransaction()?.replace(R.id.fr_container, PlayoffFragment())
                ?.addToBackStack(null)
                ?.commit()
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

    private fun initView(country: String) {
        binding.rv.adapter = adapter
        Log.d("GroupFragment", "Initializing view with country: $country")
        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            viewModel.football.collect {
                Log.d("GroupFragment", "Received football state: $it")
                adapter.submitList(it.country)
            }
        }
        viewModel.loadCountry(country)
    }

    private fun onClick(model: CountryModel) {
        Log.d("GroupFragment", "Clicked on item with country: ${model.country}")
        val fragment = InfoFragment()
        val bundle = Bundle()
        bundle.putString("country", model.country)
        bundle.putInt("flag", model.img)
        bundle.putString("name", model.name)
        fragment.arguments = bundle

        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fr_container, fragment)
            .addToBackStack(null)
            .commit()
    }
}