package com.qifan.leboncoin.core.di

import com.qifan.leboncoin.feature.list.ListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Qifan on 2019-07-13.
 */
val viewModelModule = module {
    viewModel {
        ListViewModel(get(), get())
    }
}