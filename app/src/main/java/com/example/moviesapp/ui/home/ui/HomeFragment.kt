package com.example.moviesapp.ui.home.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.moviesapp.R
import com.example.moviesapp.databinding.HomeFragmentBinding
import com.example.moviesapp.model.Result

import com.example.moviesapp.ui.home.adapter.MovieAdapter
import com.example.moviesapp.ui.home.adapter.MoviesDetailsInter


class HomeFragment :Fragment() , MoviesDetailsInter {
    private val viewModel : HomeViewModel by viewModels()
    lateinit var binding : HomeFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.home_fragment, container, false)
        return binding.root

    }
    override fun onStart() {
        super.onStart()
        binding.lifecycleOwner = this
        binding.view = viewModel

        val adapter = MovieAdapter(mutableListOf(),this)
        binding.rcv.adapter=adapter

        val adapter1 = MovieAdapter(mutableListOf(),this)
        binding.rcv1.adapter=adapter1

        val adapter2 = MovieAdapter(mutableListOf(),this)
        binding.rcv2.adapter=adapter2


    }

    override fun onClickItem(moviesDatail: Result) {
       val action=HomeFragmentDirections.actionHomeFragmentToDetailsOfMovie(moviesDatail)
        findNavController().navigate(action)
    }
}