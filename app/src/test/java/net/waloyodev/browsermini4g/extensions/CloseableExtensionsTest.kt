package net.waloyodev.browsermini4g.extensions

import net.waloyodev.browsermini4g.BuildConfig
import net.waloyodev.browsermini4g.SDK_VERSION
import net.waloyodev.browsermini4g.TestApplication
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.verifyNoMoreInteractions
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import java.io.Closeable


/**
 * Unit tests for [Closeable] extensions.
 */
@RunWith(RobolectricTestRunner::class)
@Config(constants = BuildConfig::class, application = TestApplication::class, sdk = [SDK_VERSION])
class CloseableExtensionsTest {

    @Rule
    @JvmField
    val exception: ExpectedException = ExpectedException.none()

    @Test
    fun `safeUse swallows exception`() {
        val closeable = mock<Closeable>()

        // Exception swallowed
        closeable.safeUse {
            throw Exception("test exception")
        }

        verify(closeable).close()
        verifyNoMoreInteractions(closeable)

        exception.expect(Exception::class.java)
        exception.expectMessage("test exception")

        closeable.use {
            throw Exception("test exception")
        }
    }
}