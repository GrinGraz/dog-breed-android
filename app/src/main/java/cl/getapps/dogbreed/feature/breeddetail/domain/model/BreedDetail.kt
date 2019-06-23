package cl.getapps.dogbreed.feature.breeddetail.domain.model

data class BreedDetail(val breeds: List<String>? = listOf(),
                       val status: String? = "empty")
