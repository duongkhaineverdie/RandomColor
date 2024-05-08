package com.smarttech.randomcolor.di

import com.smarttech.randomcolor.presentation.MainViewModel
import com.smarttech.randomcolor.presentation.ui.home.HomeViewModel
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val viewModelModule = module {
    single { MainViewModel() }
    single { HomeViewModel() }
}

val dispatcherModule = module {
    factory { Dispatchers.Default }
}