package com.example.lint.checks.issue

import com.android.tools.lint.detector.api.Implementation
import com.android.tools.lint.detector.api.Issue
import com.android.tools.lint.detector.api.Scope
import com.example.lint.checks.detector.ButtonIDDetector

class ButtonIDIssue : GenericIDNamingIssue() {
    override var issue = Issue.create(
        ID,
        DESCRIPTION,
        EXPLANATION,
        category,
        priority,
        severity,
        Implementation(
            ButtonIDDetector::class.java,
            Scope.RESOURCE_FILE_SCOPE
        )
    )
}