package com.example.footballproject.onboard

import android.animation.Animator
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.footballproject.R
import com.airbnb.lottie.LottieAnimationView
import com.example.footballproject.databinding.FragmentBoardBinding
import com.example.footballproject.fragment.LineupFragment
import com.example.footballproject.onboard.model.OnBoardModel
import com.example.footballproject.onboard.utils.Preferences
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class BoardFragment : Fragment() {

    private lateinit var binding: FragmentBoardBinding
    @Inject
    lateinit var preferences: Preferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentBoardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }
    private fun initView() {
        arguments.let {
            val data = it?.getSerializable("board") as OnBoardModel
            binding.tvName.text = data.desc
            binding.tvDesc.text = data.text
        }
        binding.btnNext.setOnClickListener {
            val fragmentManager = requireFragmentManager()
            fragmentManager.beginTransaction().replace(R.id.fr_container, LineupFragment())
                .commit()
            preferences.setBoardingShow(true)
        }
    }
}