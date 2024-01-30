package com.shubhamahirwar.addpayapp

import android.app.Application
import com.shubhamahirwar.addpayapp.di.ApplicationComponent
import com.shubhamahirwar.addpayapp.di.DaggerApplicationComponent

class AddPayApplication : Application() {
    private lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.builder().build()

    }
}