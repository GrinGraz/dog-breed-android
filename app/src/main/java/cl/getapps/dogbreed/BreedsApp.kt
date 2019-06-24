package cl.getapps.dogbreed

import android.app.Application
import cl.getapps.dogbreed.core.di.threadModule
import cl.getapps.dogbreed.feature.breeddetail.di.breedDetailModule
import cl.getapps.dogbreed.feature.breeds.di.breedsModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class BreedsApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@BreedsApp)
            modules(listOf(threadModule, breedDetailModule, breedsModule))
        }
    }
}
