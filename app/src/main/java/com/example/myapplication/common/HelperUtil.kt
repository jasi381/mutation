package com.example.myapplication.common

object HelperUtil {

    fun extractCodeFromQueryString(queryString: String): String? {
        val regex = Regex("""code":"([^"]*)"""")
        val matchResult = regex.find(queryString)
        return matchResult?.groupValues?.get(1)
    }
}