package com.shubhamahirwar.addpayapp.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.shubhamahirwar.addpayapp.R
import com.shubhamahirwar.addpayapp.viewModels.activity.LauncherViewModel

class LauncherActivity : AppCompatActivity() {
    private lateinit var viewModel: LauncherViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)

        viewModel = ViewModelProvider(this)[LauncherViewModel::class.java]
        viewModel.startSplashCountdown(this)
    }
}