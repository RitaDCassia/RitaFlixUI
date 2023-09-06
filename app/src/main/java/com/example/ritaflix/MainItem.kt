package com.example.ritaflix

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class MainItem(
    val id: Int,
    @DrawableRes val drawableID: Int,
    @StringRes val textNameFilme: Int,
    @StringRes val textNameDirector: Int,
    @StringRes val textTimeFilme: Int,
    @StringRes val textImb: Int
)
