package me.melnikov.kotlintest.presentation.dashboard

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import me.melnikov.kotlintest.ApplicationLoader
import me.melnikov.kotlintest.ui.dashboard.DashboardView

/**
 * Created by melniqw on 10.08.2018.
 */
@InjectViewState
class DashboardPresenter : MvpPresenter<DashboardView>() {

    init {
        ApplicationLoader.appComponent.inject(this)
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
    }

}