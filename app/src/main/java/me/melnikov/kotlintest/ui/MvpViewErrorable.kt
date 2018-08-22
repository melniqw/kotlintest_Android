package me.melnikov.kotlintest.ui

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

/**
 * Created by melniqw on 18.08.2018.
 */
interface MvpViewErrorable : MvpView {

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showError(message: String)
}