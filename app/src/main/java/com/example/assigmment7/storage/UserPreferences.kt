package com.example.assigmment7.storage

import android.content.Context
import com.example.assigmment7.model.UserProfile

object UserPreferences {

    private const val PREF_NAME = "user_profile"
    private const val KEY_NAME = "name"
    private const val KEY_EMAIL = "email"
    private const val KEY_AGE = "age"

    fun save(context: Context, profile: UserProfile) {
        val prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        prefs.edit()
            .putString(KEY_NAME, profile.name)
            .putString(KEY_EMAIL, profile.email)
            .putInt(KEY_AGE, profile.age)
            .apply()
    }

    fun load(context: Context): UserProfile? {
        val prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val name = prefs.getString(KEY_NAME, null) ?: return null
        val email = prefs.getString(KEY_EMAIL, null) ?: return null
        val age = prefs.getInt(KEY_AGE, -1)
        if (age == -1) return null

        return UserProfile(name, email, age)
    }
}
