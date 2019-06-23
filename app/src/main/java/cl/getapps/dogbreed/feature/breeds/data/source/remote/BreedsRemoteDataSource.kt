package cl.getapps.dogbreed.feature.breeds.data.source.remote

import cl.getapps.dogbreed.feature.breeds.data.entity.BreedsEntity
import io.reactivex.Single

class BreedsRemoteDataSource(private val breedsAPI: BreedsAPI) :
    RemoteDataSource {
    override fun getBreeds(): Single<BreedsEntity> = breedsAPI.getDogBreeds()
}
