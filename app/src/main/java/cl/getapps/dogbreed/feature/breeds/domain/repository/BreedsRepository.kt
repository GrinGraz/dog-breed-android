package cl.getapps.dogbreed.feature.breeds.domain.repository

import cl.getapps.dogbreed.core.data.Repository

interface BreedsRepository: Repository<Nothing> {
    fun getBreeds(): Nothing = TODO()
}
