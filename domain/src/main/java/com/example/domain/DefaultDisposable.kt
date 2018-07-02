package com.example.domain

import io.reactivex.observers.DisposableObserver

/**
 * Created by lilei on 2018/7/2.
 */
open class DefaultDisposable<T>:DisposableObserver<T>() {
    override fun onNext(t: T) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onError(e: Throwable) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onComplete() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}