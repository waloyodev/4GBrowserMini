package net.waloyodev.browsermini4g.extensions

import net.waloyodev.browsermini4g.BuildConfig
import net.waloyodev.browsermini4g.SDK_VERSION
import net.waloyodev.browsermini4g.TestApplication
import org.assertj.core.api.Assertions.assertThat
import org.json.JSONArray
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

/**
 * Unit tests for JSONArrayExtensions.kt
 */
@RunWith(RobolectricTestRunner::class)
@Config(constants = BuildConfig::class, application = TestApplication::class, sdk = [SDK_VERSION])
class JSONArrayExtensionsTest {

    @Test
    fun `map functions correctly`() {
        val numberList = listOf(1, 2, 3, 4, 5, 6, 7)
        val mockJsonArray = JSONArray(numberList)

        assertThat(numberList).isEqualTo(mockJsonArray.map { it as Int })
    }
}