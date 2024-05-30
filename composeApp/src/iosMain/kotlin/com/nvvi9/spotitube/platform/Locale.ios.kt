package com.nvvi9.spotitube.platform

import platform.Foundation.NSLocale
import platform.Foundation.countryCode
import platform.Foundation.currentLocale
import platform.Foundation.languageCode

actual val defaultCountry: String?
    get() = NSLocale.currentLocale.countryCode

actual val defaultLanguageTag: String?
    get() = NSLocale.currentLocale.languageCode