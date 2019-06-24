package cl.getapps.dogbreed.feature.breeds.ui

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import cl.getapps.dogbreed.R
import cl.getapps.dogbreed.core.data.Error
import cl.getapps.dogbreed.core.data.Loading
import cl.getapps.dogbreed.core.data.StateData
import cl.getapps.dogbreed.core.data.Success
import cl.getapps.dogbreed.core.ui.FeatureView
import cl.getapps.dogbreed.core.ui.RecyclerViewActivity
import cl.getapps.dogbreed.feature.breeds.presentation.BreedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class BreedsActivity : RecyclerViewActivity<BreedsRecyclerViewAdapter, String>(asGrid = false), FeatureView {

    override var recyclerViewAdapter = BreedsRecyclerViewAdapter()
    private val breedViewModel: BreedViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupViewModel()
        loadItems()
    }

    private fun setupViewModel() {
        breedViewModel.breeds
            .observe(this, Observer(::render))
    }

    override fun loadItems() {
        super.loadItems()
        breedViewModel.fetchBreeds()
    }

    override fun render(stateData: StateData) = when (stateData) {
        is Loading -> showSnackBar(getString(R.string.msg_loading_items))
        is Success<*> -> setItems(stateData.data as MutableList<String>)
        is Error -> showSnackBar(getString(R.string.msg_error_loading_items), isError = true)
    }
}
