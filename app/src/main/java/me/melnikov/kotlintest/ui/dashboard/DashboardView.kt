package me.melnikov.kotlintest.ui.dashboard

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

/**
 * Created by melniqw on 10.08.2018.
 */
interface DashboardView : MvpView {

    @StateStrategyType(value = AddToEndSingleStrategy::class)
    fun setText(text: String)
}