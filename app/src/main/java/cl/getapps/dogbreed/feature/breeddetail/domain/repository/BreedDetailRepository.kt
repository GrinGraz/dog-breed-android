package cl.getapps.dogbreed.feature.breeddetail.domain.repository

import cl.getapps.dogbreed.core.data.Repository
import cl.getapps.dogbreed.feature.breeddetail.data.entity.BreedDetailEntity
import cl.getapps.dogbreed.feature.breeddetail.domain.model.BreedDetail
import io.reactivex.Single

interface BreedDetailRepository : Repository<BreedDetailEntity>{
    fun fetchBreedDetail(breedName: String): Single<BreedDetail>
}
