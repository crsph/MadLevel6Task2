package com.example.madlevel6task2.ui

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.example.madlevel6task2.R
import com.example.madlevel6task2.vm.MovieViewModel
import kotlinx.android.synthetic.main.fragment_movie_information.*
import kotlinx.android.synthetic.main.fragment_movie_list.*


class MovieInformationFragment : Fragment() {

    private val viewModel: MovieViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_information, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ivStar.setImageResource(R.drawable.green_star)

        val selectedMovie = viewModel.getSelectedMovie
        val movie = viewModel.movie.value?.get(selectedMovie)

        if (movie != null) {
            tvTitle.text = movie.title
            tvReleaseDate.text = movie.releaseDate
            tvVoteAverage.text = movie.rating
            tvOverview.text = movie.overview
            Glide.with(requireContext()).load(movie.getBackdropImageUrl()).into(ivBackdrop)
            Glide.with(requireContext()).load(movie.getPosterImageUrl()).into(ivPoster)
        }

    }

}