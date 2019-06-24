package cl.getapps.dogbreed.feature.breeds.data.source.remote

import cl.getapps.dogbreed.feature.breeds.data.entity.BreedsEntity
import com.google.gson.Gson
import io.reactivex.Single
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


const val DOG_BREEDS = "breeds/list"

interface BreedsAPI {
    @GET(DOG_BREEDS)
    fun getDogBreeds(): Single<BreedsEntity>
}

object Creator {

    const val BASE_URL = "https://dog.ceo/api/"

    fun createService(): BreedsAPI {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)).build())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .build()
        return retrofit.create(BreedsAPI::class.java)
    }
}
