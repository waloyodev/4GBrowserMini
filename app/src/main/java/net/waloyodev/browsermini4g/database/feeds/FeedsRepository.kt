package net.waloyodev.browsermini4g.database.feeds

import net.waloyodev.browsermini4g.database.FeedsModel

interface FeedsRepository {

    fun clearFeeds()
    fun feedEntry(item: FeedsModel)
    fun allEntries(): List<FeedsModel>

}