package com.interswitchng.dailypulse2

import kotlinx.coroutines.CoroutineScope

expect open class BaseViewModel() {
    val scope : CoroutineScope
}