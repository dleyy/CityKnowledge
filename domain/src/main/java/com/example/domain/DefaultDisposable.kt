package com.example.domain

import io.reactivex.observers.DisposableObserver

/**
 * Created by lilei on 2018/7/2.
 */
open class DefaultDisposable<T>:DisposableObserver<T>() {
    override fun onNext(t: T) {
    }

    override fun onError(e: Throwable) {
    }

    override fun onComplete() {
    }
}