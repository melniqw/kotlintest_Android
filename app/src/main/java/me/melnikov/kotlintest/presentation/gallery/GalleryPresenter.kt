package me.melnikov.kotlintest.presentation.gallery

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import dagger.android.AndroidInjection
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import me.melnikov.kotlintest.ApplicationLoader
import me.melnikov.kotlintest.data.content.ContentManager
import me.melnikov.kotlintest.data.content.MediaAlbum
import me.melnikov.kotlintest.data.content.MediaFile
import me.melnikov.kotlintest.ui.gallery.GalleryView
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by melniqw on 18.08.2018.
 */
@InjectViewState
class GalleryPresenter : MvpPresenter<GalleryView>() {

    init {
        ApplicationLoader.instance.appComponent.inject(this)
    }

    @Inject
    lateinit var contentManager: ContentManager

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
    }

    fun loadMediaAlbums() {
        compositeDisposable.add(contentManager.getMediaAlbums()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    handleLoadMediaAlbums(it)
                }, {
                    handleLoadMediaAlbumsError(it)
                }))
    }

    private fun handleLoadMediaAlbums(albums: Set<MediaAlbum>) {
        var triggered = false
        for (album in albums) {
            if (!triggered) {
                loadMediaFiles(album.id)
                triggered = true
            }
        }
    }

    private fun handleLoadMediaAlbumsError(throwable: Throwable) {
        viewState.showError(throwable.toString())
    }

    fun loadMediaFiles(albumId: Int) {
        viewState.clearImages()
        viewState.showProgress()

        compositeDisposable.add(contentManager.getMediaFiles(albumId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    handleLoadMediaFiles(it)
                }, {
                    handleLoadMediaFilesError(it)
                }))
    }

    private fun handleLoadMediaFiles(mediaFiles: List<MediaFile>) {
        if (mediaFiles.isEmpty()) {
            viewState.showEmpty()
        } else {
            viewState.showImages(mediaFiles)
        }
    }

    private fun handleLoadMediaFilesError(throwable: Throwable) {
        viewState.showError(throwable.toString())
    }

}