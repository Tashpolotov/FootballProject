package com.example.footballproject.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.footballproject.R
import com.example.footballproject.databinding.FragmentLineupBinding
import com.example.footballproject.fragment.WorldRatinFragment.WorldRatingFragment
import com.example.footballproject.fragment.groupfragment.GroupFragment
import com.example.footballproject.fragment.pastgame.PastFragment
import com.example.footballproject.fragment.playoffragment.PlayoffFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LineupFragment : Fragment() {

    private lateinit var binding:FragmentLineupBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLineupBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBtn()
    }

    private fun initBtn() {

            binding.linearTable.setOnClickListener {
                fragmentManager?.beginTransaction()?.replace(R.id.fr_container, GroupFragment())
                    ?.addToBackStack(null)
                    ?.commit()
            }
            binding.linearMatches.setOnClickListener {
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.fr_container, PastFragment())
                    .addToBackStack(null)
                    .commit()
            }
            binding.linearRating.setOnClickListener {
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.fr_container, WorldRatingFragment())
                    .addToBackStack(null)
                    .commit()
            }


    }
}