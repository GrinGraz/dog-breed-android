package cl.getapps.dogbreed.feature.breeddetail.domain.repository

import cl.getapps.dogbreed.core.data.Repository

interface BreedDetailRepository : Repository<Nothing>{
    fun fetchBreedDetail(breedName: String): Nothing = TODO()
}
