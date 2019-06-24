package cl.getapps.dogbreed.feature.breeddetail.ui

import android.os.Bundle
import androidx.lifecycle.Observer
import cl.getapps.dogbreed.core.data.Error
import cl.getapps.dogbreed.core.data.Loading
import cl.getapps.dogbreed.core.data.StateData
import cl.getapps.dogbreed.core.data.Success
import cl.getapps.dogbreed.core.ui.FeatureView
import cl.getapps.dogbreed.core.ui.RecyclerViewActivity
import cl.getapps.dogbreed.feature.breeddetail.domain.model.BreedDetail
import cl.getapps.dogbreed.feature.breeddetail.presentation.BreedDetailViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class BreedDetailActivity : RecyclerViewActivity<BreedDetailRecyclerViewAdapter, String>(), FeatureView {

    override var recyclerViewAdapter = BreedDetailRecyclerViewAdapter()
    private val breedDetailViewModel: BreedDetailViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //bindScope(getOrCreateScope("Repos"))
        setupViewModel()
        loadItems()
    }

    private fun setupViewModel() = breedDetailViewModel.breedDetail.observe(this, Observer(::render))

    override fun loadItems() {
        super.loadItems()
        breedDetailViewModel.fetchBreedDetail("")
    }

    override fun render(stateData: StateData) = when (stateData) {
        is Loading -> showSnackBar("Loading items...")
        is Success<*> -> setItems(stateData.data as MutableList<String>)
        is Error -> showSnackBar("Error loading items :(", isError = true)
    }

    object ARGS {
        const val BREED_NAME = "breed_name"
    }
}
