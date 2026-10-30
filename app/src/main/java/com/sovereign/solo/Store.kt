package com.sovereign.solo

import android.content.Context
import android.content.pm.ApplicationInfo

object Store {
    val ENT = setOf("com.google.android.youtube", "com.zhiliaoapp.musically", "com.instagram.android", "com.netflix.mediaclient", "com.facebook.katana")
    val ALLOW = setOf("com.android.chrome", "com.chrome.beta", "org.mozilla.firefox", "com.google.android.dialer", "com.android.calculator2")

    private fun p(c: Context) = c.getSharedPreferences("solo3", Context.MODE_PRIVATE)
    private fun n(c: Context, k: String) = p(c).getInt(k, 0)
    fun now() = System.currentTimeMillis()

    fun xp(c: Context) = n(c, "xp")
    fun tokens(c: Context) = n(c, "tokens")
    fun gateEnd(c: Context) = p(c).getLong("gateEnd", 0L)
    fun gateOn(c: Context) = now() < gateEnd(c)

    fun level(xp: Int): Int { var x = xp; var l = 1; while (x >= 100 + 25 * (l - 1)) { x -= 100 + 25 * (l - 1); l++ }; return l }
    fun rank(l: Int) = when { l >= 30 -> "S"; l >= 20 -> "A"; l >= 15 -> "B"; l >= 10 -> "C"; l >= 5 -> "D"; else -> "E" }
    
    fun isHazard(c: Context, pkg: String): Boolean {
        if (pkg == c.packageName || pkg in ALLOW) return false
        if (pkg in ENT) return true
        return try { c.packageManager.getApplicationInfo(pkg, 0).category == ApplicationInfo.CATEGORY_GAME } catch (e: Exception) { false }
    }
    fun blocked(c: Context, pkg: String) = isHazard(c, pkg) && gateOn(c)
}
