package cl.getapps.dogbreed.feature.breeddetail.data.repository

import cl.getapps.dogbreed.core.data.DataSourceFactory
import cl.getapps.dogbreed.feature.breeddetail.data.source.remote.BreedDetailRemoteDataSource
import cl.getapps.dogbreed.feature.breeddetail.domain.repository.BreedDetailRepository
import io.reactivex.Completable

class BreedDetailDataRepository(private val dataSourceFactory: DataSourceFactory) : BreedDetailRepository{

    override fun fetchBreedDetail(breedName: String): Nothing {
        return dataSourceFactory.retrieveLocalDataSource().isCached()
            .flatMap {
                dataSourceFactory.retrieveDataSource<BreedDetailRemoteDataSource>(it).getBreedDetail(breedName)
            }
            .flatMap {
                save(it).toSingle { it }
            }
    }

    override fun save(items: Nothing): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun clear(): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
