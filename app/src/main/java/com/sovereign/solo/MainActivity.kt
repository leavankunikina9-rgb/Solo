package com.sovereign.solo

import android.app.Activity
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : Activity() {
    private val ui = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(Color.parseColor("#EE030914"))
            setPadding(32, 64, 32, 32)
        }
        val title = TextView(this).apply {
            text = "[!] SOLO LAUNCHER : MONARCH SYSTEM"
            textSize = 14f
            setTextColor(Color.parseColor("#00E5FF"))
            typeface = Typeface.MONOSPACE
        }
        val stats = TextView(this).apply {
            text = "LEVEL: ${Store.level(Store.xp(this@MainActivity))} | TOKENS: ${Store.tokens(this@MainActivity)}"
            textSize = 16f
            setTextColor(Color.WHITE)
            typeface = Typeface.MONOSPACE
        }
        root.addView(title)
        root.addView(stats)
        setContentView(root)
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {}
}
