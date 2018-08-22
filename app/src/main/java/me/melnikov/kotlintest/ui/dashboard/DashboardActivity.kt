package me.melnikov.kotlintest.ui.dashboard

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.activity_dashboard.*
import me.melnikov.kotlintest.R
import me.melnikov.kotlintest.presentation.dashboard.DashboardPresenter

/**
 * Created by melniqw on 10.08.2018.
 */
class DashboardActivity : MvpAppCompatActivity(), DashboardView {

    companion object {
        fun newIntent(context: Context) : Intent = Intent(context, DashboardActivity::class.java)
    }

    @InjectPresenter
    lateinit var presenter: DashboardPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        button1.setOnClickListener { presenter.onButton1Click() }
        button2.setOnClickListener { presenter.onButton2Click() }
    }

    override fun setText(text: String) {
        etText.setText(text)
    }
}