package com.example.lint.checks

import com.android.tools.lint.client.api.IssueRegistry
import com.android.tools.lint.client.api.Vendor
import com.android.tools.lint.detector.api.CURRENT_API
import com.example.lint.checks.issue.ButtonIDIssue
import com.example.lint.checks.issue.TextViewIDIssue


class CustomLintRegistry : IssueRegistry() {
    //        override val issues = listOf(IDNamingIssue.ISSUE)
    override val issues = listOf(
        TextViewIDIssue().issue,
        ButtonIDIssue().issue
    )

    override val api: Int
        get() = CURRENT_API

    override val minApi: Int
        get() = 8 // works with Studio 4.1 or later; see com.android.tools.lint.detector.api.Api / ApiKt

    // Requires lint API 30.0+; if you're still building for something
    // older, just remove this property.
    override val vendor: Vendor = Vendor(
        vendorName = "Android Open Source Project",
        feedbackUrl = "https://github.com/googlesamples/android-custom-lint-rules/issues",
        contact = "https://github.com/googlesamples/android-custom-lint-rules"
    )
}