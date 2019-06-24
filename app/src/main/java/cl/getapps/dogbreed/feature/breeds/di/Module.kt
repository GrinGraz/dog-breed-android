package cl.getapps.dogbreed.feature.breeds.di

import cl.getapps.dogbreed.feature.breeds.data.repository.BreedsDataRepository
import cl.getapps.dogbreed.feature.breeds.data.source.local.BreedsLocalDataSource
import cl.getapps.dogbreed.feature.breeds.data.source.local.LocalDataSource
import cl.getapps.dogbreed.feature.breeds.data.source.remote.BreedsRemoteDataSource
import cl.getapps.dogbreed.feature.breeds.data.source.remote.Creator
import cl.getapps.dogbreed.feature.breeds.data.source.remote.RemoteDataSource
import cl.getapps.dogbreed.feature.breeds.domain.repository.BreedsRepository
import cl.getapps.dogbreed.feature.breeds.domain.usecase.GetBreeds
import cl.getapps.dogbreed.feature.breeds.presentation.BreedViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val breedsModule = module {

    single { Creator.createService() }

    factory<RemoteDataSource> { BreedsRemoteDataSource(get()) }
    factory<LocalDataSource> { BreedsLocalDataSource() }

    single<BreedsRepository> { BreedsDataRepository(get(), get()) }

    viewModel { BreedViewModel(get()) }

    factory { GetBreeds(get(), get(), get()) }
}
