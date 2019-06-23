package cl.getapps.dogbreed.feature.breeddetail.data.remote

import cl.getapps.dogbreed.feature.breeds.data.entity.BreedsEntity
import io.reactivex.Single
import retrofit2.http.GET


const val DOG_BREEDS = "breeds/list"

interface DogBreedsAPI {
    @GET(DOG_BREEDS)
    fun getDogBreeds() : Single<BreedsEntity>
}
