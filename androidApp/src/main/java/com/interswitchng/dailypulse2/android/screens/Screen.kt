package com.interswitchng.dailypulse2.android.screens

import kotlinx.serialization.Serializable

sealed class Screens{
    @Serializable
    data object Articles: Screens()
    @Serializable
    data object AboutDevice: Screens()
    @Serializable
    data object Sources: Screens()
}