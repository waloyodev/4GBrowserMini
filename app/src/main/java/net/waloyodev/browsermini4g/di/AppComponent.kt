package net.waloyodev.browsermini4g.di

import net.waloyodev.browsermini4g.BrowserApp
import net.waloyodev.browsermini4g.adblock.AssetsAdBlocker
import net.waloyodev.browsermini4g.adblock.NoOpAdBlocker
import net.waloyodev.browsermini4g.browser.SearchBoxModel
import net.waloyodev.browsermini4g.browser.activity.BrowserActivity
import net.waloyodev.browsermini4g.browser.activity.ThemableBrowserActivity
import net.waloyodev.browsermini4g.browser.fragment.BookmarksFragment
import net.waloyodev.browsermini4g.browser.fragment.TabsFragment
import net.waloyodev.browsermini4g.dialog.LightningDialogBuilder
import net.waloyodev.browsermini4g.download.DownloadHandler
import net.waloyodev.browsermini4g.download.LightningDownloadListener
import net.waloyodev.browsermini4g.reading.activity.ReadingActivity
import net.waloyodev.browsermini4g.search.SuggestionsAdapter
import net.waloyodev.browsermini4g.settings.activity.SettingsActivity
import net.waloyodev.browsermini4g.settings.activity.ThemableSettingsActivity
import net.waloyodev.browsermini4g.settings.fragment.*
import net.waloyodev.browsermini4g.utils.ProxyUtils
import net.waloyodev.browsermini4g.view.LightningChromeClient
import net.waloyodev.browsermini4g.view.LightningView
import net.waloyodev.browsermini4g.view.LightningWebClient
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(AppModule::class), (AppBindsModule::class)])
interface AppComponent {

    fun inject(activity: BrowserActivity)

    fun inject(fragment: BookmarksFragment)

    fun inject(fragment: BookmarkSettingsFragment)

    fun inject(builder: LightningDialogBuilder)

    fun inject(fragment: TabsFragment)

    fun inject(lightningView: LightningView)

    fun inject(activity: ThemableBrowserActivity)

    fun inject(advancedSettingsFragment: AdvancedSettingsFragment)

    fun inject(app: BrowserApp)

    fun inject(proxyUtils: ProxyUtils)

    fun inject(activity: ReadingActivity)

    fun inject(webClient: LightningWebClient)

    fun inject(activity: SettingsActivity)

    fun inject(activity: ThemableSettingsActivity)

    fun inject(listener: LightningDownloadListener)

    fun inject(fragment: PrivacySettingsFragment)

    fun inject(fragment: DebugSettingsFragment)

    fun inject(suggestionsAdapter: SuggestionsAdapter)

    fun inject(chromeClient: LightningChromeClient)

    fun inject(downloadHandler: DownloadHandler)

    fun inject(searchBoxModel: SearchBoxModel)

    fun inject(generalSettingsFragment: GeneralSettingsFragment)

    fun inject(displaySettingsFragment: DisplaySettingsFragment)

    fun provideAssetsAdBlocker(): AssetsAdBlocker

    fun provideNoOpAdBlocker(): NoOpAdBlocker

}
