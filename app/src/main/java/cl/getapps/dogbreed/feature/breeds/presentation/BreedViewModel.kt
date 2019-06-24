package cl.getapps.dogbreed.feature.breeds.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import cl.getapps.dogbreed.core.data.Error
import cl.getapps.dogbreed.core.data.Loading
import cl.getapps.dogbreed.core.data.StateData
import cl.getapps.dogbreed.core.data.Success
import cl.getapps.dogbreed.core.domain.usecase.None
import cl.getapps.dogbreed.feature.breeds.domain.usecase.GetBreeds
import io.reactivex.disposables.Disposable

class BreedViewModel(private val getBreeds: GetBreeds) : ViewModel() {

    var breeds: MutableLiveData<StateData> = MutableLiveData()
    private var disposable: Disposable? = null

    fun fetchBreeds() {
        disposable = getBreeds.execute(None())
            .doOnSubscribe { breeds.value = Loading }
            .subscribe(
                { breeds.value = Success(it.breedDetail) },
                { breeds.value = Error(it) }
            )
    }

    override fun onCleared() {
        disposable?.dispose()
        super.onCleared()
    }
}
