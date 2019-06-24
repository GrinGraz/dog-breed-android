package cl.getapps.dogbreed.feature.breeddetail.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import cl.getapps.dogbreed.core.data.Error
import cl.getapps.dogbreed.core.data.Loading
import cl.getapps.dogbreed.core.data.StateData
import cl.getapps.dogbreed.core.data.Success
import cl.getapps.dogbreed.feature.breeddetail.domain.usecase.GetBreedDetail
import io.reactivex.disposables.Disposable

class BreedDetailViewModel(private val getBreedDetail: GetBreedDetail) : ViewModel() {

    var breedDetail: MutableLiveData<StateData> = MutableLiveData()
    private var disposable: Disposable? = null

    fun fetchBreedDetail(breedName: String) {
        disposable = getBreedDetail.execute(breedName)
            .doOnSubscribe { breedDetail.value = Loading }
            .subscribe(
                { breedDetail.value = Success(it.breeds) },
                { breedDetail.value = Error(it) }
            )
    }

    override fun onCleared() {
        disposable?.dispose()
        super.onCleared()
    }
}
