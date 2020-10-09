package com.oscar.malllibrary.ui.loader

import android.content.Context
import android.support.v7.app.AppCompatDialog
import android.view.Gravity
import com.blankj.utilcode.util.ScreenUtils
import com.oscar.malllibrary.R
import com.wang.avi.AVLoadingIndicatorView
import com.wang.avi.Indicator
import com.wang.avi.indicators.BallClipRotateMultipleIndicator

/**
 * @author Oscar  time：2020/10/8 12:37 AM
 * Class Comment：
 */
object MallLoader {
    private val LOAD_SIZE_SCALE = 8
    private val LOAD_OFFSET_SCALE = 10

    private val LOADERS = ArrayList<AppCompatDialog>()
    private val DEFAULT_LOADER = BallClipRotateMultipleIndicator()

    private fun createDialog(context: Context?, avLoadingIndicatorView: AVLoadingIndicatorView): AppCompatDialog {
        val dialog = AppCompatDialog(context, R.style.dialog)
        val deviceWidth = ScreenUtils.getScreenWidth()
        val deviceHeight = ScreenUtils.getScreenHeight()
        val dialogWindow = dialog.window
        dialog.setContentView(avLoadingIndicatorView)

        if (dialogWindow != null) {
            val lp = dialogWindow.attributes
            lp.width = deviceWidth / LOAD_SIZE_SCALE
            lp.height = deviceHeight / LOAD_OFFSET_SCALE
            lp.height = lp.height + deviceHeight / LOAD_OFFSET_SCALE
            lp.gravity = Gravity.CENTER
        }

        LOADERS.add(dialog)
        return dialog
    }

    fun showLoading(context: Context?, type: Enum<LoaderStyles>) {
        showLoading(context, type.name)
    }

    private fun showLoading(context: Context?, type: String) {
        val avLoadingIndicatorView =  AVLoadingIndicatorView(context)
        avLoadingIndicatorView.setIndicator(type)
        createDialog(context, avLoadingIndicatorView).show()
    }

    @JvmOverloads
    fun showLoading(context: Context?, indicator: Indicator = DEFAULT_LOADER) {
        val avLoadingIndicatorView =  AVLoadingIndicatorView(context)
        avLoadingIndicatorView.indicator = indicator
        createDialog(context, avLoadingIndicatorView).show()
    }

    fun stopLoading() {
        for (dialog in LOADERS) {
            if (dialog.isShowing) {
                dialog.cancel()
            }
        }
        LOADERS.clear()
    }
}