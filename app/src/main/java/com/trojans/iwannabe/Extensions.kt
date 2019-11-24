package com.trojans.iwannabe

import android.content.Context

const val APP_KEY = "abc"

// get a String value by key
fun getString(ctx: Context, key: String): String {
    val sharedPreferences = ctx.getSharedPreferences(
        APP_KEY,
        Context.MODE_PRIVATE
    )
    return sharedPreferences.getString(key, "") ?: ""
}

// save a String value by key
fun setString(ctx: Context, key: String, value: String) {
    val sharedPreferences = ctx.getSharedPreferences(
        APP_KEY,
        Context.MODE_PRIVATE
    )
    val editor = sharedPreferences.edit()
    editor.putString(key, value)
    editor.apply()
}