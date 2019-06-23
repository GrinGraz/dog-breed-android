package cl.getapps.dogbreed.feature.breeds.data.repository

import cl.getapps.dogbreed.core.data.DataSourceFactory
import cl.getapps.dogbreed.feature.breeds.data.source.remote.BreedsRemoteDataSource
import cl.getapps.dogbreed.feature.breeds.domain.repository.BreedsRepository
import io.reactivex.Completable

class BreedsDataRepository(private val dataSourceFactory: DataSourceFactory): BreedsRepository {

    override fun getBreeds(): Nothing {
        return dataSourceFactory.retrieveLocalDataSource().isCached()
            .flatMap {
                dataSourceFactory.retrieveDataSource<BreedsRemoteDataSource>(it).getBreeds()
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
