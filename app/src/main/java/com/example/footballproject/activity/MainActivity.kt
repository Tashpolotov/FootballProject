package com.example.footballproject.activity

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.navigation.NavController
import com.example.footballproject.R
import com.example.footballproject.databinding.ActivityMainBinding
import com.example.footballproject.fragment.LineupFragment
import com.example.footballproject.fragment.groupfragment.GroupFragment
import com.example.footballproject.onboard.VpFragment
import com.example.footballproject.onboard.utils.Preferences
import com.example.footballproject.viewmodel.FootballViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var onBoardingCompletedKey: String

    @Inject
    lateinit var preferences: Preferences


    private val viewModel: FootballViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onBoardingCompletedKey = "onBoardingCompleted"
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)


        if (savedInstanceState == null) {
            if (!preferences.isBoardingShow()) {
                supportFragmentManager.beginTransaction().add(R.id.fr_container, VpFragment())
                    .commit()
            } else {
                supportFragmentManager.beginTransaction()
                    .add(R.id.fr_container, LineupFragment()).commit()
            }
        }
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean(onBoardingCompletedKey, preferences.isBoardingShow())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        preferences.setBoardingShow(savedInstanceState.getBoolean(onBoardingCompletedKey, false))
    }
    override fun onBackPressed() {
        finish()
    }
}