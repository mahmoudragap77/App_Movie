package com.example.moviesapp.ui.actors.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.moviesapp.R
import com.example.moviesapp.databinding.ActorsFragmentBinding
import com.example.moviesapp.ui.actors.adapter.PersonAdapter

class ActorsFragment: Fragment() {
    private val viewModel : PersonViewModel by viewModels()
    lateinit var binding : ActorsFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.actors_fragment, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.lifecycleOwner = this
        binding.view = viewModel

        val adapter = PersonAdapter(mutableListOf())
        binding.personRcv.adapter=adapter


    }

}