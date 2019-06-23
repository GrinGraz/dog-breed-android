package cl.getapps.dogbreed.feature.breeds.domain.repository

import cl.getapps.dogbreed.core.data.Repository
import cl.getapps.dogbreed.feature.breeds.data.entity.BreedsEntity
import cl.getapps.dogbreed.feature.breeds.domain.model.Breeds
import io.reactivex.Single

interface BreedsRepository : Repository<BreedsEntity> {
    fun getBreeds(): Single<Breeds>
}
