package net.waloyodev.browsermini4g.search

import net.waloyodev.browsermini4g.R
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class SuggestionViewHolder(view: View) {
    val imageView: ImageView = view.findViewById(R.id.suggestionIcon)
    val titleView: TextView = view.findViewById(R.id.title)
    val urlView: TextView = view.findViewById(R.id.url)
}
