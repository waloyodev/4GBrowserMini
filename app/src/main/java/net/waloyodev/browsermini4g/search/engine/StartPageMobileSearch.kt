package net.waloyodev.browsermini4g.search.engine

import net.waloyodev.browsermini4g.R
import android.app.Application

/**
 * The StartPage mobile search engine.
 */
class StartPageMobileSearch(application: Application?) : BaseSearchEngine(
    "file:///android_asset/startpage.png",
    "https://startpage.com/do/m/mobilesearch?language=english&query=",
    R.string.search_engine_startpage_mobile, application
)
