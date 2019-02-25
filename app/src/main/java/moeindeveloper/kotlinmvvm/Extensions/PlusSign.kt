package moeindeveloper.kotlinmvvm.Extensions

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
//adding += sign to CompositeDisposable:
operator fun CompositeDisposable.plusAssign(disposable: Disposable) {
    add(disposable)
}