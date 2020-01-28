package net.waloyodev.browsermini4g.browser

import net.waloyodev.browsermini4g.database.Bookmark

interface BookmarksView {

    fun navigateBack()

    fun handleUpdatedUrl(url: String)

    fun handleBookmarkDeleted(bookmark: Bookmark)

}
