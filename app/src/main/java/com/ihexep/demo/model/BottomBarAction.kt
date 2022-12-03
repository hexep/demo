package com.ihexep.demo.model

import com.ihexep.demo.R

data class BottomBarAction(
    val iconId: Int,
    val isMain: Boolean = false
)

val BottomBarActions = listOf(
    BottomBarAction(R.drawable.ic_all),
    BottomBarAction(R.drawable.ic_repeat),
    BottomBarAction(R.drawable.ic_home, isMain = true),
    BottomBarAction(R.drawable.ic_messages),
    BottomBarAction(R.drawable.ic_more)
)
