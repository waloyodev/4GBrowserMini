package net.waloyodev.browsermini4g.search.engine

import net.waloyodev.browsermini4g.R
import android.app.Application

/**
 * The Baidu search engine.
 *
 * See http://www.baidu.com/img/bdlogo.gif for the icon.
 */
class BaiduSearch(application: Application?) : BaseSearchEngine(
    "file:///android_asset/baidu.png",
    "https://www.baidu.com/s?wd=",
    R.string.search_engine_baidu, application
)
