package cl.getapps.dogbreed.core.ui

import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerViewAdapter<T> : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var values = mutableListOf<T>()
}
