package com.example.myapplication.helpers

object HelperFunctions {
    fun extractErrorCodeFromMessage(message: String): String? {
        val regex = """code=(\w+)""".toRegex()
        val matchResult = regex.find(message)
        return matchResult?.groupValues?.get(1)
    }

    fun extractErrorCode(response: String): String? {
        val regex = """\{code=(\w+)\}""".toRegex()
        val matchResult = regex.find(response)
        return matchResult?.groupValues?.get(1)
    }

}