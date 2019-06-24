package cl.getapps.dogbreed.feature.breeddetail.data.repository

import cl.getapps.dogbreed.feature.breeddetail.data.entity.BreedDetailEntity
import cl.getapps.dogbreed.feature.breeddetail.data.entity.toModel
import cl.getapps.dogbreed.feature.breeddetail.data.source.local.LocalDataSource
import cl.getapps.dogbreed.feature.breeddetail.data.source.remote.BreedDetailRemoteDataSource
import cl.getapps.dogbreed.feature.breeddetail.data.source.remote.RemoteDataSource
import cl.getapps.dogbreed.feature.breeddetail.domain.model.BreedDetail
import cl.getapps.dogbreed.feature.breeddetail.domain.repository.BreedDetailRepository
import io.reactivex.Completable
import io.reactivex.Single

class BreedDetailDataRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : BreedDetailRepository {

    override fun fetchBreedDetail(breedName: String): Single<BreedDetail> {
        return localDataSource.isCached()
            .flatMap { isCached ->
                if (isCached) localDataSource.getBreedDetail(breedName)
                else remoteDataSource.getBreedDetail(breedName)
            }
            .flatMap { breedDetailEntity ->
                save(breedDetailEntity).toSingle { breedDetailEntity.toModel() }
            }
    }

    override fun save(items: BreedDetailEntity): Completable = localDataSource.save(items)

    override fun clear(): Completable = localDataSource.clear()
}
