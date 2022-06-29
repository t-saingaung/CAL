package com.example.lint.checks

import com.android.tools.lint.detector.api.Category
import com.android.tools.lint.detector.api.Severity

object Constants {
    const val ID = "MissingIDNamingPattern"
    const val DESCRIPTION = "Naming for id attribute is not correct."
    const val EXPLANATION =
        "Please use the correct ID Naming Pattern that define on the wiki"
    const val SCHEMA = "http://schemas.android.com/apk/res/android"
    const val ATTRIBUTE_NAME = "id"

    val category = Category.CORRECTNESS
    const val priority = 5
    val severity = Severity.ERROR
}