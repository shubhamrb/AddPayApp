package com.shubhamahirwar.addpayapp.di

import com.shubhamahirwar.addpayapp.ui.fragment.BusinessFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface BusinessComponent {
    fun inject(businessFragment: BusinessFragment)
}