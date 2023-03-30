package com.example.moviesapp.ui


import android.os.Bundle

import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.moviesapp.R
import com.example.moviesapp.databinding.ActivityYoutubeBinding
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer


class Youtube : YouTubeBaseActivity() {

    companion object {
        const val VIDEO_ID :String = "RipFrHQxJJg"
        const val API : String= "AIzaSyCLteg5CDmTWeYrRlg62TPzqcuKbNI_aSI"
    }
    lateinit var youtubePlayerInit :YouTubePlayer.OnInitializedListener

    lateinit var binding: ActivityYoutubeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_youtube)
        initUi()
    }

    private fun initUi() {
        youtubePlayerInit = object : YouTubePlayer.OnInitializedListener{
            override fun onInitializationSuccess(
                p0: YouTubePlayer.Provider?,
                p1: YouTubePlayer?,
                p2: Boolean
            ) {
                p1?.loadVideo(VIDEO_ID)
            }

            override fun onInitializationFailure(
                p0: YouTubePlayer.Provider?,
                p1: YouTubeInitializationResult?
            ) {
               Toast.makeText(applicationContext,"fail",Toast.LENGTH_LONG).show()
            }


        }

        binding.btn.setOnClickListener {
            binding.youtube.initialize(API, youtubePlayerInit)
        }
    }
}