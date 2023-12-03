package com.atilsamancioglu.besinlerkitabigradlework.util

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import androidx.preference.PreferenceManager

class PrivateSharedPreferences {

    //singleton
    companion object{
        private val timeString = "time"
        private var sharedPreferences: SharedPreferences ?= null

        @Volatile private var instance : PrivateSharedPreferences ?= null
        private val lock = Any()
        operator fun invoke(context:Context) : PrivateSharedPreferences =  instance ?: synchronized(lock){
            instance ?: buildPrivateSharedPreferences(context).also{
                instance = it
            }
        }
        fun buildPrivateSharedPreferences(context:Context):PrivateSharedPreferences{
            sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
            return PrivateSharedPreferences()
        }
    }
    fun saveTime(time:Long){
        sharedPreferences?.edit(commit = true){
            putLong(timeString,time)
        }
    }
}