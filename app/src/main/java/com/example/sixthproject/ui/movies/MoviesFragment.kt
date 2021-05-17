package com.example.sixthproject.ui.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.sixthproject.databinding.FragmentMovieBinding
import com.example.sixthproject.viewmodel.ViewModelFactory

class MoviesFragment: Fragment() {

    private lateinit var fragmentMovieBinding: FragmentMovieBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        fragmentMovieBinding = FragmentMovieBinding.inflate(layoutInflater, container, false)
        return fragmentMovieBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]


            val movieAdapter = MoviesAdapter()
            fragmentMovieBinding
            fragmentMovieBinding.progressBar.visibility = View.VISIBLE
            viewModel.getMovies().observe(this, { movies ->
                fragmentMovieBinding.progressBar.visibility = View.GONE
                movieAdapter.setMovies(movies)
                movieAdapter.notifyDataSetChanged()
            })


            with(fragmentMovieBinding.rvMovie) {
                layoutManager = GridLayoutManager(requireContext(),3)
                setHasFixedSize(true)
                adapter = movieAdapter
            }
        }
    }

}