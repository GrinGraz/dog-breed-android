package cl.getapps.dogbreed.feature.breeddetail.di

import cl.getapps.dogbreed.feature.breeddetail.data.repository.BreedDetailDataRepository
import cl.getapps.dogbreed.feature.breeddetail.data.source.local.BreedDetailLocalDataSource
import cl.getapps.dogbreed.feature.breeddetail.data.source.local.LocalDataSource
import cl.getapps.dogbreed.feature.breeddetail.data.source.remote.BreedDetailRemoteDataSource
import cl.getapps.dogbreed.feature.breeddetail.data.source.remote.Creator
import cl.getapps.dogbreed.feature.breeddetail.data.source.remote.RemoteDataSource
import cl.getapps.dogbreed.feature.breeddetail.domain.repository.BreedDetailRepository
import cl.getapps.dogbreed.feature.breeddetail.domain.usecase.GetBreedDetail
import cl.getapps.dogbreed.feature.breeddetail.presentation.BreedDetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val breedDetailModule = module {

    single { Creator.createService() }

    factory<RemoteDataSource> { BreedDetailRemoteDataSource(get()) }
    factory<LocalDataSource> { BreedDetailLocalDataSource() }

    single<BreedDetailRepository> { BreedDetailDataRepository(get(), get()) }

    factory { GetBreedDetail(get(), get(), get()) }

    viewModel { BreedDetailViewModel(get()) }
}
