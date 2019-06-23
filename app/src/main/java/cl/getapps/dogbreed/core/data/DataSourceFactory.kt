package cl.getapps.dogbreed.core.data

class DataSourceFactory(
    val remoteDataSource: RemoteSource,
    val localDataSource: LocalSource
) {

    inline fun <reified A> retrieveDataSource(isCached: Boolean): A {
        if (isCached && !localDataSource.isExpired()) {
            return retrieveLocalDataSource() as A
        }
        return retrieveRemoteDataSource() as A
    }

    fun retrieveLocalDataSource(): LocalSource = localDataSource

    fun retrieveRemoteDataSource(): RemoteSource = remoteDataSource
}
