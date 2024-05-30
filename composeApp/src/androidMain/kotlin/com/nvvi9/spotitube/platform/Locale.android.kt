package com.nvvi9.spotitube.platform

import java.util.Locale

actual val defaultCountry: String?
    get() = Locale.getDefault().country

actual val defaultLanguageTag: String?
    get() = Locale.getDefault().toLanguageTag()