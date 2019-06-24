package cl.getapps.dogbreed.feature.breeddetail.ui

import android.os.Bundle
import android.view.MenuItem
import androidx.lifecycle.Observer
import cl.getapps.dogbreed.R
import cl.getapps.dogbreed.core.data.Error
import cl.getapps.dogbreed.core.data.Loading
import cl.getapps.dogbreed.core.data.StateData
import cl.getapps.dogbreed.core.data.Success
import cl.getapps.dogbreed.core.ui.FeatureView
import cl.getapps.dogbreed.core.ui.RecyclerViewActivity
import cl.getapps.dogbreed.feature.breeddetail.presentation.BreedDetailViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class BreedDetailActivity : RecyclerViewActivity<BreedDetailRecyclerViewAdapter, String>(asGrid = true), FeatureView {

    override var recyclerViewAdapter = BreedDetailRecyclerViewAdapter()
    private val breedDetailViewModel: BreedDetailViewModel by viewModel()
    private val breedName by lazy { intent.getStringExtra(ARGS.BREED_NAME) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = breedName
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setupViewModel()
        loadItems()
    }

    private fun setupViewModel() {
        breedDetailViewModel.breedDetail.observe(this, Observer(::render))
    }

    override fun loadItems() {
        super.loadItems()
        breedDetailViewModel.fetchBreedDetail(breedName)
    }

    override fun render(stateData: StateData) = when (stateData) {
        is Loading -> showSnackBar(getString(R.string.msg_loading_items))
        is Success<*> -> setItems(stateData.data as MutableList<String>)
        is Error -> showSnackBar(getString(R.string.msg_error_loading_items), isError = true)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        android.R.id.home -> {
            onBackPressed()
            true
        }
        else -> super.onOptionsItemSelected(item)
    }

    object ARGS {
        const val BREED_NAME = "breed_name"
    }
}
