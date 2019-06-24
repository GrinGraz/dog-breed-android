package cl.getapps.dogbreed.feature.breeddetail.data.source.local

import cl.getapps.dogbreed.feature.breeddetail.data.entity.BreedDetailEntity
import io.reactivex.Completable
import io.reactivex.Single

class BreedDetailLocalDataSource: LocalDataSource {
    override fun getBreedDetail(breedName: String): Single<BreedDetailEntity> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isCached(): Single<Boolean> {
        return Single.just(false)
    }

    override fun setLastCacheTime(lastCache: Long) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isExpired(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <T> save(items: T): Completable {
        return Completable.complete()
    }

    override fun clear(): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
