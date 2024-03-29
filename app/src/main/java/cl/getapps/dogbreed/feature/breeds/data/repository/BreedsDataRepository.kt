package cl.getapps.dogbreed.feature.breeds.data.repository

import cl.getapps.dogbreed.feature.breeds.data.entity.BreedsEntity
import cl.getapps.dogbreed.feature.breeds.data.entity.toModel
import cl.getapps.dogbreed.feature.breeds.data.source.local.LocalDataSource
import cl.getapps.dogbreed.feature.breeds.data.source.remote.RemoteDataSource
import cl.getapps.dogbreed.feature.breeds.domain.model.Breeds
import cl.getapps.dogbreed.feature.breeds.domain.repository.BreedsRepository
import io.reactivex.Completable
import io.reactivex.Single

class BreedsDataRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : BreedsRepository {

    override fun getBreeds(): Single<Breeds> {
        return localDataSource.isCached()
            .flatMap { isCached ->
                if (isCached) localDataSource.getBreeds()
                else remoteDataSource.getBreeds()
            }
            .flatMap { breedsEntity ->
                save(breedsEntity).toSingle { breedsEntity.toModel() }
            }
    }

    override fun save(items: BreedsEntity): Completable = localDataSource.save(items)


    override fun clear(): Completable = localDataSource.clear()
}
