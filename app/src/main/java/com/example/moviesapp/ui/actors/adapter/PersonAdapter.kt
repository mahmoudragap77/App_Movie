package com.example.moviesapp.ui.actors.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviesapp.R
import com.example.moviesapp.databinding.OnePersonImageBinding
import com.example.moviesapp.model.ResultX
import com.example.moviesapp.utils.Constant
import kotlin.random.Random


class PersonAdapter(private var itemse:List<ResultX>) : RecyclerView.Adapter<PersonAdapter.MovieViewHolder>() {
    private var lastPosition = -1
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.one_person_image,parent,false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val currentItem =itemse[position]
        setAnimation(holder.itemView, position)
        holder.binding.apply {
            personName.text=currentItem.name
            personRate.text=currentItem.id.toString()

            val poster = Constant.POSTER_BASE_URL + currentItem.profilePath
            Glide.with(personImage)
                .load(poster)
                .into(personImage)

        }


    }
    fun setIteme(newItem: List<ResultX>){
        itemse=newItem
    }

    override fun getItemCount()= itemse.size

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
        val binding = OnePersonImageBinding.bind(viewItem)
    }
}