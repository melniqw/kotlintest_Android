package me.melnikov.kotlintest.presentation.main

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import me.melnikov.kotlintest.ApplicationLoader
import me.melnikov.kotlintest.analytics.Analytics
import me.melnikov.kotlintest.model.Human
import me.melnikov.kotlintest.model.Speed
import me.melnikov.kotlintest.model.User
import me.melnikov.kotlintest.ui.main.MainView
import javax.inject.Inject

/**
 * Created by melniqw on 01.08.2018.
 */
@InjectViewState
class MainPresenter : MvpPresenter<MainView>() {

    init {
        ApplicationLoader.appComponent.inject(this)
    }

    @Inject
    lateinit var analytics: Analytics

    private lateinit var users : ArrayList<Human>

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        var mainUser = User("Ivan", "Blazhevich", 36, Speed.LOW, 0L)

        users = arrayListOf(
            User( "Ivan", "Blazhevich", 36, Speed.LOW, 0L),
            User("Alexey", "Melnikov", 27, Speed.MEDIUM, 0L)
        )

        analytics.logEvent(Analytics.Event.UNKNOWN)
    }

    fun showUsers() {
        for (user in users) {
            viewState.showMessage(user.toString())
        }
    }

    fun showDashboard() {
        viewState.showDashboard()
    }
}