package com.example.moviesapp.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviesapp.R
import com.example.moviesapp.databinding.OneMovieBinding
import com.example.moviesapp.model.Result
import com.example.moviesapp.utils.Constant
import kotlin.random.Random


class MovieAdapter(private var items:List<Result>,val listener: MoviesDetailsInter) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    private var lastPosition = -1
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.one_movie,parent,false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val currentItem =items[position]
        setAnimation(holder.itemView, position)
        holder.binding.apply {

            movieTitle.text=currentItem.originalTitle
            movieRate.text=currentItem.voteAverage?.toString()
            moviesDate.text=currentItem.releaseDate

            val moviePosterURL = Constant.POSTER_BASE_URL + currentItem.posterPath
            Glide.with(image)
                .load(moviePosterURL)
                .into(image)
            root.setOnClickListener { listener.onClickItem(currentItem) }

        }


    }
    fun setItem(newItem: List<Result>){
        items=newItem
    }

    override fun getItemCount()= items.size

    private fun setAnimation(viewToAnimate: View, position: Int) {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition) {
            val anim = ScaleAnimation(
                0.0f,
                1.0f,
                0.0f,
                1.0f,
                Animation.RELATIVE_TO_SELF,
                0.5f,
                Animation.RELATIVE_TO_SELF,
                0.5f
            )
            anim.duration = Random.nextLong(501) //to make duration random number between [0,501)
            viewToAnimate.startAnimation(anim)
            lastPosition = position
        }
    }


    class MovieViewHolder(viewItem : View) : RecyclerView.ViewHolder(viewItem) {
        val binding = OneMovieBinding.bind(viewItem)
    }
}