package net.waloyodev.browsermini4g.search.engine

import net.waloyodev.browsermini4g.R
import android.app.Application

/**
 * A custom search engine.
 */
class CustomSearch(queryUrl: String, application: Application?) : BaseSearchEngine(
    "file:///android_asset/a5gfastbrowser.png",
    queryUrl,
    R.string.search_engine_custom, application
)
