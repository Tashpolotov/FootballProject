package com.example.footballproject.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.footballproject.R
import com.example.footballproject.databinding.ActivityMainBinding
import com.example.footballproject.fragment.groupfragment.GroupFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        val fragment = GroupFragment()
        supportFragmentManager.beginTransaction().replace(R.id.fr_container, fragment)
            .addToBackStack(null)
            .commit()
    }
}