package com.example.domain.useCase

import com.example.domain.DefaultDisposable
import com.example.domain.repositories.DataRepositor
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by lilei on 2018/6/29.
 */
abstract class BaseUseCase<T> {

    var compositedisable: CompositeDisposable = CompositeDisposable()

    var dataRepositor:DataRepositor = DataRepositor()

    abstract fun getBuildObservable(): Observable<T>

    fun execute(observer: DefaultDisposable<T>) {
        compositedisable.add(observer)
        getBuildObservable().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer)
    }

    fun unSubscribe() {
        compositedisable.dispose()
    }

}