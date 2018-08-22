package me.melnikov.kotlintest.mock

import dagger.Module
import me.melnikov.kotlintest.ApplicationLoader
import me.melnikov.kotlintest.dagger.module.AppModule

/**
 * Created by melniqw on 21.08.2018.
 */
@Module
class AppModuleMock(app: ApplicationLoader) : AppModule(app) {

}