package cl.getapps.dogbreed.feature.breeddetail.data.entity

import cl.getapps.dogbreed.feature.breeddetail.domain.model.BreedDetail
import com.google.gson.annotations.SerializedName

data class BreedDetailEntity(
    @SerializedName("message") val message : List<String>?,
    @SerializedName("status") val status : String?
)

fun BreedDetailEntity.toModel() = BreedDetail(breeds = message, status = status)
