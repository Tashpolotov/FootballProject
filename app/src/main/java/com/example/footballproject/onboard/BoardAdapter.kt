package com.example.footballproject.onboard

import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.footballproject.R
import com.example.footballproject.onboard.model.OnBoardModel
import dagger.hilt.android.qualifiers.ApplicationContext

class BoardAdapter (@ApplicationContext fragment: FragmentActivity): FragmentStateAdapter(fragment) {

    private val listBoarding = arrayOf(
        OnBoardModel(
            "Welcome to Football Scores",
            R.drawable.qatar,
            "Stay updated with live match scores and updates from your favorite football leagues and teams."
        ),
        OnBoardModel(
            "Track Matches and Fixtures",
            R.drawable.qatar,
            "Keep track of upcoming matches, fixtures, and results of your favorite teams, so you're always in the know about their performance."
        )
    )
    override fun getItemCount(): Int = listBoarding.size

    override fun createFragment(position: Int): Fragment {
        val data = bundleOf("board" to listBoarding[position])
        val fragment = BoardFragment()
        fragment.arguments = data
        return fragment
    }
}