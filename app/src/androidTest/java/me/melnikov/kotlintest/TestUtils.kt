package me.melnikov.kotlintest

import android.app.Application
import android.os.Build
import android.support.test.InstrumentationRegistry
import me.melnikov.kotlintest.dagger.component.DaggerAppComponent
import me.melnikov.kotlintest.mock.AppModuleMock
import me.melnikov.kotlintest.mock.ContentModuleMock


/**
 * Created by melniqw on 22.08.2018.
 */
object TestUtils {

    fun initMockedApplication() : Application {
        val app = ApplicationLoader.get(InstrumentationRegistry.getInstrumentation().targetContext)
        val appComponent = DaggerAppComponent.builder()
                .appModule(AppModuleMock(app))
                .contentModule(ContentModuleMock())
                .build()
        app.appComponent = appComponent
        return app
    }

    /**
     * @param permission is an android permission to grant access to @see [android.permission]
     * for example it could be @see [android.permission.CALL_PHONE]
     */
    fun grantPermission(permission: String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            InstrumentationRegistry.getInstrumentation().getUiAutomation()
                    .executeShellCommand("pm grant " + InstrumentationRegistry.getTargetContext().getPackageName()
                            + " " + permission);
        }
    }

    fun getResourceId(s: String) : Int {
        val targetContext = InstrumentationRegistry.getInstrumentation().targetContext
        val packageName = targetContext.packageName
        return targetContext.resources.getIdentifier(s, "id", packageName)
    }
}