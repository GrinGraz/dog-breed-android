package cl.getapps.dogbreed.feature.breeds.data.remote

import cl.getapps.dogbreed.feature.breeddetail.data.entity.BreedDetail
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path


const val BREED_DETAIL = "breed/{breed_name}/images"
const val BREED_NAME = "breed_name"

interface BreedDetailAPI {
    @GET(BREED_DETAIL)
    fun getBreedDetail(@Path(BREED_NAME) breedName: String): Single<BreedDetail>
}
