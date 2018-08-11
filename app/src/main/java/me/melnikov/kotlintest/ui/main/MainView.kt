package me.melnikov.kotlintest.ui.main

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

/**
 * Created by melniqw on 01.08.2018.
 */
interface MainView : MvpView {

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showMessage(message : String)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showDashboard()
}