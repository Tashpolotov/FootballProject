package com.example.footballproject.onboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.footballproject.R
import com.example.footballproject.databinding.FragmentVpBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class VpFragment : Fragment() {
    private lateinit var binding: FragmentVpBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentVpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapterBoard = BoardAdapter(requireActivity())
        binding.viewPager222.adapter = adapterBoard
        binding.indic.attachTo(binding.viewPager222)
    }
}