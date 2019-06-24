package cl.getapps.dogbreed.feature.breeds.data.entity

import cl.getapps.dogbreed.feature.breeds.domain.model.Breeds
import com.google.gson.annotations.SerializedName

data class BreedsEntity(
    @SerializedName("message") val message : List<String>?,
    @SerializedName("status") val status : String?
)

fun BreedsEntity.toModel() = Breeds(breeds = message, status = status)
