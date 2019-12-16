package kek.foundation.terrorhistory.presentation

import kek.foundation.terrorhistory.ui.BaseView
import java.lang.ref.WeakReference

abstract class BasePresenter<View: BaseView> {

    private var viewRef: WeakReference<View>? = null

    protected val view: View?
        get() = viewRef?.get()

    fun attachView(view: View) {
        viewRef = WeakReference(view)
        onFirstViewAttach()
    }

    fun detachView() {
        viewRef = null
    }

    abstract fun onFirstViewAttach()
}