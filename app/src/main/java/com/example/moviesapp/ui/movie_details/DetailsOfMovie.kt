package com.example.moviesapp.ui.movie_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.moviesapp.R
import com.example.moviesapp.databinding.ActivityDetailsOfMovieBinding
import com.example.moviesapp.model.Result


class DetailsOfMovie : Fragment() {
    lateinit var binding: ActivityDetailsOfMovieBinding
    private val args by navArgs<DetailsOfMovieArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.activity_details_of_movie, container, false)
        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindmovie(args.movieD)


    }



    private fun bindmovie(it: Result) {
        binding.apply {
            name.text=it.originalTitle
            overView.text=it.overview
           language.text=it.originalLanguage
            date.text=it.releaseDate
            votecount.text=it.voteCount.toString()
            vote.text=it.voteAverage.toString()
            val POSTER_BASE_URL = "https://image.tmdb.org/t/p/w342"
            val moviePosterURL = POSTER_BASE_URL + it.posterPath
            Glide.with(imagee)
                .load(moviePosterURL)
                .into(imagee)
        }

    }
}