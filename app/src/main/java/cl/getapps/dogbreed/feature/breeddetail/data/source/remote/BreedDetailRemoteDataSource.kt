package cl.getapps.dogbreed.feature.breeddetail.data.source.remote

import cl.getapps.dogbreed.feature.breeddetail.data.entity.BreedDetailEntity
import cl.getapps.dogbreed.feature.breeds.data.source.remote.BreedDetailAPI
import io.reactivex.Single

class BreedDetailRemoteDataSource(private val breedDetailAPI: BreedDetailAPI) :
    RemoteDataSource {
    override fun getBreedDetail(breedName: String): Single<BreedDetailEntity> = breedDetailAPI.getBreedDetail(breedName)
}
