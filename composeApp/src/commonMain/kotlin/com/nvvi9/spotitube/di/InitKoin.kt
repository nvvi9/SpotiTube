package com.nvvi9.spotitube.di

import com.nvvi9.spotitube.data.di.repositoriesModule
import com.nvvi9.spotitube.database.di.databaseModule
import com.nvvi9.spotitube.domain.di.useCasesModule
import com.nvvi9.spotitube.feature.di.viewModelsModule
import com.nvvi9.spotitube.network.di.networkModule
import org.koin.core.Koin
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(appDeclaration: KoinAppDeclaration = {}): Koin = startKoin {
    modules(databaseModule(), networkModule(), repositoriesModule(), useCasesModule(), viewModelsModule())
    appDeclaration()
}.koin
