package me.melnikov.kotlintest.ui.main

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.design.widget.Snackbar
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.activity_main.*
import me.melnikov.kotlintest.Cleanable
import me.melnikov.kotlintest.R
import me.melnikov.kotlintest.presentation.main.MainPresenter
import me.melnikov.kotlintest.ui.dashboard.DashboardActivity

class MainActivity : MvpAppCompatActivity(), MainView, Cleanable {

    @InjectPresenter
    lateinit var presenter: MainPresenter

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        presenter.showUsers()

        when (item.itemId) {
            R.id.navigation_home -> {
                message.setText(R.string.title_home)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                presenter.showDashboard()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                message.setText(R.string.title_notifications)
                return@OnNavigationItemSelectedListener true
            }
            else -> {
                return@OnNavigationItemSelectedListener false
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    override fun showMessage(message: String) {
        Snackbar.make(container, message, Snackbar.LENGTH_LONG).show()
    }

    override fun showDashboard() {
        startActivity(DashboardActivity.newIntent(this))
    }

    override fun clean() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
