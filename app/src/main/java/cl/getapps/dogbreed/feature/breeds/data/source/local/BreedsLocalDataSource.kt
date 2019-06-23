package cl.getapps.dogbreed.feature.breeds.data.source.local

import cl.getapps.dogbreed.core.data.LocalSource
import cl.getapps.dogbreed.feature.breeds.data.entity.BreedsEntity
import io.reactivex.Completable
import io.reactivex.Single

class BreedsLocalDataSource: LocalDataSource {
    override fun getBreeds(): Single<BreedsEntity> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isCached(): Single<Boolean> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setLastCacheTime(lastCache: Long) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isExpired(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <T> save(items: T): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun clear(): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
