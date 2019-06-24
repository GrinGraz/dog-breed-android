package cl.getapps.dogbreed.feature.breeddetail.data.source.remote

import cl.getapps.dogbreed.feature.breeddetail.data.entity.BreedDetailEntity
import com.google.gson.Gson
import io.reactivex.Single
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path


const val BREED_DETAIL = "breed/{breed_name}/images"
const val BREED_NAME = "breed_name"

interface BreedDetailAPI {
    @GET(BREED_DETAIL)
    fun getBreedDetail(@Path(BREED_NAME) breedName: String): Single<BreedDetailEntity>
}

object Creator {

    private const val BASE_URL = "https://dog.ceo/api/"

    fun createService(): BreedDetailAPI {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)).build())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .build()
        return retrofit.create(BreedDetailAPI::class.java)
    }
}
