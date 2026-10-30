package com.sovereign.solo

import android.app.Activity
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView

class BlockActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            setBackgroundColor(Color.parseColor("#F5030914"))
            setPadding(32, 32, 32, 32)
        }
        val alert = TextView(this).apply {
            text = "[!] PENALTY ZONE : GATE ACTIVE [!]"
            textSize = 16f
            setTextColor(Color.parseColor("#FF1744"))
            typeface = Typeface.MONOSPACE
            gravity = Gravity.CENTER
        }
        val sub = TextView(this).apply {
            text = "\nAccess to entertainment apps is sealed until your study gate is cleared.\nReturn to your books, Hunter."
            textSize = 13f
            setTextColor(Color.WHITE)
            typeface = Typeface.MONOSPACE
            gravity = Gravity.CENTER
        }
        root.addView(alert)
        root.addView(sub)
        setContentView(root)
    }
    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {}
}
