package cl.getapps.dogbreed.feature.breeddetail.data.source.remote

import cl.getapps.dogbreed.core.data.RemoteSource
import cl.getapps.dogbreed.feature.breeddetail.data.entity.BreedDetailEntity
import io.reactivex.Single

interface RemoteDataSource: RemoteSource {
    fun getBreedDetail(breedName: String): Single<BreedDetailEntity>
}
