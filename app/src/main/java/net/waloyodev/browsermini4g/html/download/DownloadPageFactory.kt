package net.waloyodev.browsermini4g.html.download

import net.waloyodev.browsermini4g.R
import net.waloyodev.browsermini4g.constant.FILE
import net.waloyodev.browsermini4g.database.downloads.DownloadEntry
import net.waloyodev.browsermini4g.database.downloads.DownloadsRepository
import net.waloyodev.browsermini4g.html.HtmlPageFactory
import net.waloyodev.browsermini4g.html.ListPageReader
import net.waloyodev.browsermini4g.html.jsoup.*
import net.waloyodev.browsermini4g.preference.UserPreferences
import android.app.Application
import io.reactivex.Single
import java.io.File
import java.io.FileWriter
import javax.inject.Inject

/**
 * The factory for the downloads page.
 */
class DownloadPageFactory @Inject constructor(
    private val application: Application,
    private val userPreferences: UserPreferences,
    private val manager: DownloadsRepository,
    private val listPageReader: ListPageReader
) : HtmlPageFactory {

    override fun buildPage(): Single<String> = manager
        .getAllDownloads()
        .map { list ->
            parse(listPageReader.provideHtml()) andBuild {
                title { application.getString(R.string.action_downloads) }
                body {
                    val repeatableElement = id("repeated").removeElement()
                    id("content") {
                        list.forEach {
                            appendChild(repeatableElement.clone {
                                tag("a") { attr("href", createFileUrl(it.title)) }
                                id("title") { text(createFileTitle(it)) }
                                id("url") { text(it.url) }
                            })
                        }
                    }
                }
            }
        }
        .map { content -> Pair(createDownloadsPageFile(), content) }
        .doOnSuccess { (page, content) ->
            FileWriter(page, false).use { it.write(content) }
        }
        .map { (page, _) -> "$FILE$page" }


    private fun createDownloadsPageFile(): File = File(application.filesDir, FILENAME)

    private fun createFileUrl(fileName: String): String = "$FILE${userPreferences.downloadDirectory}/$fileName"

    private fun createFileTitle(downloadItem: DownloadEntry): String {
        val contentSize = if (downloadItem.contentSize.isNotBlank()) {
            "[${downloadItem.contentSize}]"
        } else {
            ""
        }

        return "${downloadItem.title} $contentSize"
    }

    companion object {

        const val FILENAME = "downloads.html"

    }

}
