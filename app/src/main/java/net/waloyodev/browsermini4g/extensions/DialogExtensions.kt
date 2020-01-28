@file:Suppress("NOTHING_TO_INLINE")

package net.waloyodev.browsermini4g.extensions

import net.waloyodev.browsermini4g.dialog.BrowserDialog
import androidx.appcompat.app.AlertDialog

/**
 * Ensures that the dialog is appropriately sized and displays it.
 */
inline fun AlertDialog.Builder.resizeAndShow() = BrowserDialog.setDialogSize(context, this.show())
