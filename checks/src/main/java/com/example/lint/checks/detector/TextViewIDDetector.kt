package com.example.lint.checks.detector

import com.android.annotations.Nullable
import com.android.tools.lint.detector.api.ResourceXmlDetector
import com.android.tools.lint.detector.api.XmlContext
import com.example.lint.checks.issue.IDNamingIssue
import org.w3c.dom.Element
import java.util.*

class TextViewIDDetector : ResourceXmlDetector() {

    companion object {
        private const val SCHEMA = "http://schemas.android.com/apk/res/android"
        private const val VIEW = "TextView"
        private const val ATTRIBUTE_NAME = "id"
        private const val PATTERN = "_text_view"
    }

    @Nullable
    override fun getApplicableElements(): Collection<String>? {
        return Collections.singletonList(VIEW)
    }

    override fun visitElement(context: XmlContext, element: Element) {
        if (element.hasAttributeNS(SCHEMA, ATTRIBUTE_NAME)) {
            val idAttribute = element.getAttributeNS(SCHEMA, ATTRIBUTE_NAME)
            if (idAttribute.split("/").lastOrNull() == PATTERN)
                context.report(
                    IDNamingIssue.ISSUE,
                    context.getLocation(element),
                    IDNamingIssue.EXPLANATION
                )
            if (idAttribute.takeLast(PATTERN.length).contains(PATTERN).not()) {
                context.report(
                    IDNamingIssue.ISSUE,
                    context.getLocation(element),
                    IDNamingIssue.EXPLANATION
                )
            }
        }
    }
}
