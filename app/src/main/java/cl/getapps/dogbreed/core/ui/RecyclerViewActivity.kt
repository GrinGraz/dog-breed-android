package cl.getapps.dogbreed.core.ui

import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cl.getapps.dogbreed.R
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.item_list.*

abstract class RecyclerViewActivity<Adapter : BaseRecyclerViewAdapter<Model>, Model>(private val asGrid: Boolean) :
    BaseActivity() {

    open lateinit var layoutManager: RecyclerView.LayoutManager
    open lateinit var recyclerViewAdapter: Adapter

    var loadingFromServer: Boolean = false

    var pageParam: Int = 1

    private var snackBar: Snackbar? = null

    override fun getLayoutId(): Int = R.layout.activity_scrolling

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        makeSnackBar()

        setupRecyclerView()

        if (this is FeatureView.Pageable) addPagination()
    }

    override fun makeSnackBar() {
        snackBar = Snackbar.make(item_list, "", Snackbar.LENGTH_INDEFINITE)
    }

    private fun setupRecyclerView() {
        if (asGrid) layoutManager = GridLayoutManager(this, 2)
        else layoutManager = LinearLayoutManager(this)
        item_list.layoutManager = layoutManager

        val itemDividerDecoration = resources.getDimension(R.dimen.item_separator_height).toInt()
        if (asGrid) item_list.addItemDecoration(GridItemDecoration(itemDividerDecoration))
        else item_list.addItemDecoration(ListItemDecoration(itemDividerDecoration))
        item_list.adapter = recyclerViewAdapter
    }

    private fun addPagination() {

        fun isLastItemVisible() =
            if (asGrid) (layoutManager as GridLayoutManager).findLastCompletelyVisibleItemPosition() == recyclerViewAdapter.itemCount - 1
            else (layoutManager as LinearLayoutManager).findLastCompletelyVisibleItemPosition() == recyclerViewAdapter.itemCount - 1

        item_list.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                if (isLastItemVisible()) loadItems()
            }
        })
    }

    fun showSnackBar(message: String, isError: Boolean = false) {
        snackBar?.setText(message)?.setDuration(BaseTransientBottomBar.LENGTH_INDEFINITE)?.run {
            if (isError) setAction("Retry") {
                loadingFromServer = false
                loadItems()
            }.show() else show()
        }
    }

    @CallSuper
    open fun loadItems() {
        if (loadingFromServer) return else loadingFromServer = true
    }

    fun setItems(items: List<Model>) {
        recyclerViewAdapter.values.addAll(items)
        recyclerViewAdapter.notifyItemRangeInserted(recyclerViewAdapter.itemCount, items.size)
        loadingFromServer = false
        pageParam++
        snackBar?.dismiss()
    }
}
