package me.melnikov.kotlintest.ui.gallery

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.SingleStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import me.melnikov.kotlintest.data.content.MediaFile
import me.melnikov.kotlintest.ui.MvpViewErrorable

/**
 * Created by melniqw on 18.08.2018.
 */
interface GalleryView : MvpViewErrorable {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showProgress()

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showEmpty()

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showImages(images: List<MediaFile>)

    @StateStrategyType(SingleStateStrategy::class)
    fun clearImages()
}