package cl.getapps.dogbreed.feature.breeddetail.data.source.local

import cl.getapps.dogbreed.core.data.LocalSource
import cl.getapps.dogbreed.feature.breeddetail.data.entity.BreedDetailEntity
import io.reactivex.Single

interface LocalDataSource: LocalSource {
    fun getBreedDetail(breedName: String): Single<BreedDetailEntity>
}
