package com.example.hilttutorial.utils

import android.content.Context
import android.preference.PreferenceManager
import android.text.TextUtils
import android.util.Log
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SharedPreferenceHelper @Inject constructor(@ApplicationContext private val context: Context){
    private val mContext: Context?
    /**
     * Helper method to retrieve a String value from [SharedPreferences].
     *
     * @param key
     * @return The value from shared preferences, or null if the value could not be read.
     */
    fun getStringPreference(key: String?): String? {
        var value: String? = null
        val preferences =
            androidx.preference.PreferenceManager.getDefaultSharedPreferences(mContext)
        if (preferences != null) {
            value = preferences.getString(key, null)
        }
        Log.d(TAG, "$value gotten")
        return value
    }

    /**
     * Helper method to write a String value to [SharedPreferences].
     *
     * @param key
     * @param value
     * @return true if the new value was successfully written to persistent storage.
     */
    fun setStringPreference(key: String?, value: String) {
        val preferences =
            PreferenceManager.getDefaultSharedPreferences(mContext)
        if (preferences != null && !TextUtils.isEmpty(key)) {
            val editor = preferences.edit()
            Log.d(TAG, "$value added")
            editor.putString(key, value)
            editor.apply()
        }
    }

    /**
     * Helper method to retrieve a float value from [SharedPreferences].
     *
     * @param key
     * @param defaultValue A default to return if the value could not be read.
     * @return The value from shared preferences, or the provided default.
     */
    fun getFloatPreference(key: String?, defaultValue: Float): Float {
        var value = defaultValue
        val preferences =
            PreferenceManager.getDefaultSharedPreferences(mContext)
        if (preferences != null) {
            value = preferences.getFloat(key, defaultValue)
        }
        return value
    }

    /**
     * Helper method to write a float value to [SharedPreferences].
     *
     * @param key
     * @param value
     * @return true if the new value was successfully written to persistent storage.
     */
    fun setFloatPreference(key: String?, value: Float) {
        val preferences =
            PreferenceManager.getDefaultSharedPreferences(mContext)
        if (preferences != null) {
            val editor = preferences.edit()
            editor.putFloat(key, value)
            editor.apply()
        }
    }

    /**
     * Helper method to retrieve a long value from [SharedPreferences].
     *
     * @param key
     * @param defaultValue A default to return if the value could not be read.
     * @return The value from shared preferences, or the provided default.
     */
    fun getLongPreference(key: String?, defaultValue: Long): Long {
        var value = defaultValue
        val preferences =
            PreferenceManager.getDefaultSharedPreferences(mContext)
        if (preferences != null) {
            value = preferences.getLong(key, defaultValue)
        }
        return value
    }

    /**
     * Helper method to write a long value to [SharedPreferences].
     *
     * @param key
     * @param value
     * @return true if the new value was successfully written to persistent storage.
     */
    fun setLongPreference(key: String?, value: Long) {
        val preferences =
            PreferenceManager.getDefaultSharedPreferences(mContext)
        if (preferences != null) {
            val editor = preferences.edit()
            editor.putLong(key, value)
            editor.apply()
        }
    }

    /**
     * Helper method to retrieve an integer value from [SharedPreferences].
     *
     * @param key
     * @param defaultValue A default to return if the value could not be read.
     * @return The value from shared preferences, or the provided default.
     */
    fun getIntegerPreference(key: String?, defaultValue: Int): Int {
        var value = defaultValue
        val preferences =
            PreferenceManager.getDefaultSharedPreferences(mContext)
        if (preferences != null) {
            value = preferences.getInt(key, defaultValue)
        }
        return value
    }

    /**
     * Helper method to write an integer value to [SharedPreferences].
     *
     * @param key
     * @param value
     * @return true if the new value was successfully written to persistent storage.
     */
    fun setIntegerPreference(key: String?, value: Int) {
        val preferences =
            PreferenceManager.getDefaultSharedPreferences(mContext)
        if (preferences != null) {
            val editor = preferences.edit()
            editor.putInt(key, value)
            editor.apply()
        }
    }

    /**
     * Helper method to retrieve a boolean value from [SharedPreferences].
     *
     * @param key
     * @param defaultValue A default to return if the value could not be read.
     * @return The value from shared preferences, or the provided default.
     */
    fun getBooleanPreference(key: String?, defaultValue: Boolean): Boolean {
        var value = defaultValue
        val preferences =
            PreferenceManager.getDefaultSharedPreferences(mContext)
        if (preferences != null) {
            value = preferences.getBoolean(key, defaultValue)
        }
        return value
    }

    /**
     * Helper method to write a boolean value to [SharedPreferences].
     *
     * @param key
     * @param value
     * @return true if the new value was successfully written to persistent storage.
     */
    fun setBooleanPreference(key: String?, value: Boolean) {
        val preferences =
            PreferenceManager.getDefaultSharedPreferences(mContext)
        if (preferences != null) {
            val editor = preferences.edit()
            editor.putBoolean(key, value)
            editor.apply()
        }
    }

    /**
     * Helper method to remove a key from [SharedPreferences].
     *
     * @param key
     * @return true if the new value was successfully written to persistent storage.
     */
    fun clearPreference(key: String) {
        val preferences =
            PreferenceManager.getDefaultSharedPreferences(mContext)
        if (preferences != null && !TextUtils.isEmpty(key)) {
            val editor = preferences.edit()
            editor.remove(key)
            editor.apply()
            Log.d(TAG, "$key has been removed")
        }
    }

    fun clear() {
        val preferences =
            PreferenceManager.getDefaultSharedPreferences(mContext)
        if (preferences != null) {
            val editor = preferences.edit()
            editor.clear()
            editor.apply()
        }
    }

    companion object {
        private const val TAG = "SharedPreferenceTAG"
    }

    init {
        mContext = context
    }
}