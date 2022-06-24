package com.example.lint.checks.issue

import com.android.tools.lint.detector.api.*
import com.example.lint.checks.detector.TextViewIDDetector

internal object IDNamingIssue {
    private const val ID = "MissingIDNamingPattern"
    private const val DESCRIPTION = "id naming is not correct"
    const val EXPLANATION =
        "Please use the correct ID Naming Pattern that define on the wiki"
    private val CATEGORY: Category = Category.CUSTOM_LINT_CHECKS
    private const val PRIORITY = 5
    private val SEVERITY: Severity = Severity.WARNING
    val ISSUE: Issue = Issue.create(
        ID,
        DESCRIPTION,
        EXPLANATION,
        CATEGORY,
        PRIORITY,
        SEVERITY,
        Implementation(
            TextViewIDDetector::class.java,
            Scope.RESOURCE_FILE_SCOPE
        )
    )
}