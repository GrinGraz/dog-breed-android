package cl.getapps.dogbreed.feature.breeddetail.domain.usecase

import cl.getapps.dogbreed.core.domain.usecase.SingleUseCase
import cl.getapps.dogbreed.core.thread.PostExecutionThread
import cl.getapps.dogbreed.core.thread.ThreadExecutor
import cl.getapps.dogbreed.feature.breeddetail.domain.model.BreedDetail
import cl.getapps.dogbreed.feature.breeddetail.domain.repository.BreedDetailRepository
import io.reactivex.Single

class GetBreedDetail(
    private val breedDetailRepository: BreedDetailRepository,
    threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread
) : SingleUseCase<BreedDetail, String>(threadExecutor, postExecutionThread) {

    override fun buildUseCaseObservable(params: String): Single<BreedDetail> =
        breedDetailRepository.fetchBreedDetail(params)
}
