package com.example.lint.checks.detector

import com.android.annotations.Nullable
import com.android.tools.lint.detector.api.Implementation
import com.android.tools.lint.detector.api.Issue
import com.android.tools.lint.detector.api.ResourceXmlDetector
import com.android.tools.lint.detector.api.Scope
import com.android.tools.lint.detector.api.XmlContext
import com.example.lint.checks.Constants.ATTRIBUTE_NAME
import com.example.lint.checks.Constants.DESCRIPTION
import com.example.lint.checks.Constants.EXPLANATION
import com.example.lint.checks.Constants.ID
import com.example.lint.checks.Constants.SCHEMA
import com.example.lint.checks.Constants.category
import com.example.lint.checks.Constants.priority
import com.example.lint.checks.Constants.severity
import org.w3c.dom.Element

class ConstraintLayoutIDDetector : ResourceXmlDetector() {

    companion object {
        private const val VIEW = "androidx.appcompat.widget.LinearLayoutCompat"
        private const val PATTERN = "_layout"

        /**
         * Issue describing the problem and pointing to the detector
         * implementation.
         */
        @JvmField
        val ISSUE: Issue = Issue.create(
            id = ID,
            briefDescription = DESCRIPTION,
            explanation = EXPLANATION,
            category = category,
            priority = priority,
            severity = severity,
            implementation = Implementation(
                ConstraintLayoutIDDetector::class.java,
                Scope.RESOURCE_FILE_SCOPE
            )
        )
    }

    @Nullable
    override fun getApplicableElements(): Collection<String>? {
        return listOf(VIEW)
    }

    override fun visitElement(context: XmlContext, element: Element) {
        if (element.hasAttributeNS(SCHEMA, ATTRIBUTE_NAME)) {
            val idAttribute =
                element.getAttributeNS(SCHEMA, ATTRIBUTE_NAME)
            if (idAttribute.split("/").lastOrNull() == PATTERN) {
                reportIssue(context, element)
            }
            if (idAttribute.takeLast(PATTERN.length).contains(PATTERN).not()) {
                reportIssue(context, element)
            }
        }
    }

    private fun reportIssue(
        context: XmlContext,
        element: Element
    ) {
        context.report(
            issue = ISSUE,
            location = context.getLocation(element),
            message = "$DESCRIPTION $EXPLANATION"
        )
    }

}
