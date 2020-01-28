@file:Suppress("NOTHING_TO_INLINE")

package net.waloyodev.browsermini4g

/**
 * Use to implement an unimplemented method.
 */
inline fun unimplemented(): Nothing {
    throw NotImplementedError("Not implemented")
}
