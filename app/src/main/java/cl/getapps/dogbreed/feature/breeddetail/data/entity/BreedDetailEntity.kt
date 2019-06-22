package cl.getapps.dogbreed.feature.breeddetail.data.entity

import com.google.gson.annotations.SerializedName

data class BreedDetail(
    @SerializedName("message") val message : List<String>?,
    @SerializedName("status") val status : String?
)

fun BreedDetail.toModel(): Nothing = TODO()
