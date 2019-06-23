package cl.getapps.dogbreed.feature.breeds.data.source.local

import cl.getapps.dogbreed.core.data.LocalSource
import cl.getapps.dogbreed.feature.breeds.data.entity.BreedsEntity
import io.reactivex.Single

interface LocalDataSource: LocalSource {
    fun getBreeds(): Single<BreedsEntity>
}
