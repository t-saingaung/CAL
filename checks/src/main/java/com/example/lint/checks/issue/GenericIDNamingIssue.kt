package com.example.lint.checks.issue

import com.android.tools.lint.detector.api.*

abstract class GenericIDNamingIssue {

    protected companion object {
        const val ID = "MissingIDNamingPattern"
        const val DESCRIPTION = "id naming is not correct"
        const val EXPLANATION =
            "Please use the correct ID Naming Pattern that define on the wiki"
    }

    protected val category: Category = Category.CUSTOM_LINT_CHECKS
    protected val priority = 5
    protected val severity: Severity = Severity.WARNING
    abstract var issue: Issue
}