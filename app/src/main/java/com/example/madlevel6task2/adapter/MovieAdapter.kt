package com.example.madlevel6task2.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.madlevel6task2.R
import com.example.madlevel6task2.model.Movie
import kotlinx.android.synthetic.main.item_movie.view.*

class MovieAdapter(private val movies: List<Movie>, private val onClick: (Int) -> Unit) :
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context

        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(movies[position])

    override fun getItemCount(): Int = movies.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener {
                onClick(adapterPosition)
            }
        }

        fun bind(movieItem: Movie) {
            val number = adapterPosition + 1

            itemView.tvMovieNumber.text = "$number."
            Glide.with(context).load(movieItem.getPosterImageUrl()).into(itemView.ivMoviePoster)
        }
    }
}