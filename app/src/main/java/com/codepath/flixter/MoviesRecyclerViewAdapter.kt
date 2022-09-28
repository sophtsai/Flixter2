package com.codepath.flixter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.codepath.flixter.R.id

class MoviesRecyclerViewAdapter (
    private val movies: List<Movie>,
    private val mListener: OnListFragmentInteractionListener?
)
    : RecyclerView.Adapter<MoviesRecyclerViewAdapter.MovieViewHolder>()
{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie, parent, false)
        return MovieViewHolder(view)
    }

    inner class MovieViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        var mItem: Movie? = null
        val mMovieTitle: TextView = mView.findViewById<View>(id.movie_title) as TextView
        val mMovieRelease: TextView = mView.findViewById<View>(id.movie_release) as TextView
        val mMovieImage: ImageView = mView.findViewById<View>(id.movie_image) as ImageView
        val mMovieDescription: TextView = mView.findViewById<View>(id.movie_description) as TextView

        override fun toString(): String {
            return mMovieTitle.toString() + " '" + mMovieRelease.text + "'"
        }
    }

    /**
     * This lets us "bind" each Views in the ViewHolder to its' actual data!
     */
    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
        val base = "https://image.tmdb.org/t/p/w500/"

        holder.mItem = movie
        holder.mMovieTitle.text = movie.title
        holder.mMovieRelease.text = movie.release
        holder.mMovieDescription.text = movie.overview

        Glide.with(holder.mView)
            .load(base.plus(movie.posterImageUrl))
            .centerInside()
            .into(holder.mMovieImage)

        holder.mView.setOnClickListener {
            holder.mItem?.let { book ->
                mListener?.onItemClick(book)
            }
        }
    }

    /**
     * Remember: RecyclerView adapters require a getItemCount() method.
     */
    override fun getItemCount(): Int {
        return movies.size
    }
}