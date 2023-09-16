package com.carry.slideconflict.utils

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json

/**
 * Create by SunnyDay /09/16 12:34:06
 */
object KtsClient {
    @OptIn(ExperimentalSerializationApi::class)
    val serialization = Json {
        prettyPrint = true
        encodeDefaults = true
        ignoreUnknownKeys = true
        isLenient = true
        allowStructuredMapKeys = true
        useAlternativeNames = false
        explicitNulls = false
    }
}