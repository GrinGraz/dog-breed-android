package cl.getapps.dogbreed.feature.breeds.data.source.remote

import cl.getapps.dogbreed.core.data.RemoteSource
import cl.getapps.dogbreed.feature.breeds.data.entity.BreedsEntity
import io.reactivex.Single

interface RemoteDataSource : RemoteSource {
    fun getBreeds(): Single<BreedsEntity>
}
