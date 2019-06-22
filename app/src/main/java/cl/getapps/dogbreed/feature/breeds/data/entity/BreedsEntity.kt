package cl.getapps.dogbreed.feature.breeds.data.entity

import com.google.gson.annotations.SerializedName

data class BreedsEntity(
    @SerializedName("message") val message : List<String>?,
    @SerializedName("status") val status : String?
)

fun BreedsEntity.toModel(): Nothing = TODO()
