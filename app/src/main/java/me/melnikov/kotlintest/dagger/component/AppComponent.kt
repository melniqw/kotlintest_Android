package me.melnikov.kotlintest.dagger.component

import dagger.Component
import me.melnikov.kotlintest.ApplicationLoader
import me.melnikov.kotlintest.dagger.module.AppModule
import me.melnikov.kotlintest.presentation.main.MainPresenter
import me.melnikov.kotlintest.presentation.dashboard.DashboardPresenter
import javax.inject.Singleton

/**
 * Created by melniqw on 10.08.2018.
 */
@Singleton
@Component(modules = arrayOf(
    AppModule::class
))
interface AppComponent {

    fun inject(applicationLoader: ApplicationLoader)

    fun inject(mainPresenter: MainPresenter)
    fun inject(dashboardPresenter: DashboardPresenter)
}