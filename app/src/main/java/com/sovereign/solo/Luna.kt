package com.sovereign.solo

import android.content.Context
import android.content.Intent

object Luna {
    var openPkg: String? = null
    fun next(c: Context) = if (Store.gateOn(c)) "Gate running. Maintain focus." else "Next quest: Complete homework."
    fun status(c: Context) = "Level ${Store.level(Store.xp(c))}, Tokens ${Store.tokens(c)}."
    fun ask(c: Context, raw: String): String {
        val t = raw.lowercase()
        if ("status" in t) return status(c)
        return "Command received. Say help for list."
    }
}
