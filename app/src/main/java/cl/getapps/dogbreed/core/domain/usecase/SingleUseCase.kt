package cl.getapps.dogbreed.core.domain.usecase

import cl.getapps.dogbreed.core.thread.PostExecutionThread
import cl.getapps.dogbreed.core.thread.ThreadExecutor
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

abstract class SingleUseCase<T, in Params>(
    private val threadExecutor: ThreadExecutor,
    private val postExecutionThread: PostExecutionThread
) {
    protected abstract fun buildUseCaseObservable(params: Params): Single<T>

    open fun execute(params: Params): Single<T> {
        return this.buildUseCaseObservable(params)
            .subscribeOn(Schedulers.from(threadExecutor))
            .observeOn(postExecutionThread.scheduler)

    }
}

class None
