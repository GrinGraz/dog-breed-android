package cl.getapps.dogbreed.feature.breeds.domain.usecase

import cl.getapps.dogbreed.core.domain.usecase.None
import cl.getapps.dogbreed.core.domain.usecase.SingleUseCase
import cl.getapps.dogbreed.core.thread.PostExecutionThread
import cl.getapps.dogbreed.core.thread.ThreadExecutor
import cl.getapps.dogbreed.feature.breeds.domain.model.Breeds
import cl.getapps.dogbreed.feature.breeds.domain.repository.BreedsRepository
import io.reactivex.Single

class GetBreeds(
    private val breedsRepository: BreedsRepository,
    threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread
) : SingleUseCase<Breeds, None>(threadExecutor, postExecutionThread) {

    override fun buildUseCaseObservable(params: None): Single<Breeds> = breedsRepository.getBreeds()
}
