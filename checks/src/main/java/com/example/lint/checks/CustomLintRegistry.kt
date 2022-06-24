package com.example.lint.checks

import com.android.tools.lint.client.api.IssueRegistry
import com.android.tools.lint.detector.api.CURRENT_API
import com.example.lint.checks.detector.ConstraintLayoutIDDetector
import com.example.lint.checks.detector.TextViewIDDetector


class CustomLintRegistry : IssueRegistry() {
    override val issues = listOf(
        TextViewIDDetector.ISSUE,
        ConstraintLayoutIDDetector.ISSUE
    )

    override val api: Int
        get() = CURRENT_API

    override val minApi: Int
        get() = 8 // works with Studio 4.1 or later; see com.android.tools.lint.detector.api.Api / ApiKt

}