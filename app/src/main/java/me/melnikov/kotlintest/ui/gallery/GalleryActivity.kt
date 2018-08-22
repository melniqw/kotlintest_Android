package me.melnikov.kotlintest.ui.gallery

import android.Manifest
import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.tbruyelle.rxpermissions2.RxPermissions
import me.melnikov.kotlintest.R
import me.melnikov.kotlintest.data.content.MediaFile
import me.melnikov.kotlintest.presentation.gallery.GalleryPresenter

/**
 * Created by melniqw on 18.08.2018.
 */
class GalleryActivity : MvpAppCompatActivity(), GalleryView {

    companion object {
        fun newIntent(context: Context) : Intent = Intent(context, GalleryActivity::class.java)
    }

    @InjectPresenter
    lateinit var presenter: GalleryPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)

        RxPermissions(this)
                .request(Manifest.permission.READ_EXTERNAL_STORAGE)
                .subscribe{
                    granted -> if (granted) initMediaAlbums()
                }
    }

    private fun initMediaAlbums() {
        presenter.loadMediaAlbums()
    }

    override fun showProgress() {
        // todo
    }

    override fun showEmpty() {
        // todo
    }

    override fun showImages(images: List<MediaFile>) {
        // todo
    }

    override fun clearImages() {
        // todo
    }

    override fun showError(message: String) {
        // todo
    }
}