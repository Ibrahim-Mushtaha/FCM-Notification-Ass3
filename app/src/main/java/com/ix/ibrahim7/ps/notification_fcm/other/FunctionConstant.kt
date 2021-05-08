package com.ix.ibrahim7.ps.notification_fcm.other

import android.app.*
import androidx.core.view.isVisible
import com.ix.ibrahim7.ps.notification_fcm.databinding.ToolbarLayoutBinding


fun Activity.setToolbarView(
    view: ToolbarLayoutBinding,
    title: String,
    main: Boolean,
    hasMenu: Boolean = false,
    menuIcon: Int = 0,
    onComplete: () -> Unit
): ToolbarLayoutBinding {

    view.tvTitle.text = title

    when (main) {
        true -> {
            view.btnBack.isVisible = false
        }
        else -> {
            view.btnBack.apply {
                isVisible = true
                setOnClickListener {
                    onComplete()
                }
            }
        }
    }
    return view
}




