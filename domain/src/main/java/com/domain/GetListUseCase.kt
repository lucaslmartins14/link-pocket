package com.domain

import com.domain.model.Preview
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class GetListUseCase {

    private val previewSet = listOf(
        Preview("Bar Do Chucrutes", "picapau", "https://api.adorable.io/avatars/285/abott@adorable.png"),
        Preview("Rafinhas", "chaves", "https://api.adorable.io/avatars/285/abott@adorable.png"),
        Preview("Samuquinha", "samurai", "https://api.adorable.io/avatars/285/abott@adorable.png"),
        Preview("Fêzinho", "pensando no frango", "https://api.adorable.io/avatars/285/abott@adorable.png"),
        Preview("Charleston", "10", "https://api.adorable.io/avatars/285/abott@adorable.png")
    )

    fun execute(): Observable<List<Preview>> {
        return Observable.create { emitter ->
            if (previewSet.isEmpty()) emitter.onError(Throwable())
            else emitter.onNext(previewSet)
        }
    }

    fun executeJust(): Observable<List<Preview>> {
        return Observable.just(previewSet)
            .delay(3, TimeUnit.SECONDS)
            .subscribeOn(Schedulers.io())
    }
}