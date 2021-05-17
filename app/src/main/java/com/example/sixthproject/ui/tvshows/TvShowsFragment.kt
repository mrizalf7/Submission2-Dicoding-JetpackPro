package com.example.sixthproject.ui.tvshows

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.sixthproject.databinding.FragmentTvShowsBinding
import com.example.sixthproject.viewmodel.ViewModelFactory


class TvShowsFragment: Fragment() {

    private lateinit var fragmentTvShowBinding: FragmentTvShowsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        fragmentTvShowBinding = FragmentTvShowsBinding.inflate(layoutInflater, container, false)
        return fragmentTvShowBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val tvShowsAdapter = TvShowsAdapter()
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this,factory)[TvShowsViewModel::class.java]

            fragmentTvShowBinding.progressBar.visibility = View.VISIBLE
            viewModel.getTvShows().observe(this,{tvShows->
                fragmentTvShowBinding.progressBar.visibility = View.GONE
                tvShowsAdapter.setTvShows(tvShows)
                tvShowsAdapter.notifyDataSetChanged()
            })




            with(fragmentTvShowBinding.rvTvShows) {
                layoutManager = GridLayoutManager(requireContext(),3)
                setHasFixedSize(true)
                adapter = tvShowsAdapter
            }
        }
    }
}