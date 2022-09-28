package com.codepath.flixter

/**
 * This interface is used by the [MovieRecyclerViewAdapter] to ensure
 * it has an appropriate Listener.
 *
 * In this app, it's implemented by [MovieBooksFragment]
 */
interface OnListFragmentInteractionListener {
    fun onItemClick(item: Movie)
}
