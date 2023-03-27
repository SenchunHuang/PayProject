package com.example.myapplication

import android.app.Application

class MyApplication : Application() {

    companion object{
        private lateinit var application: MyApplication

        fun getApp(): MyApplication {
            return application
        }
    }

    override fun onCreate() {
        super.onCreate()
        application = this
    }

}