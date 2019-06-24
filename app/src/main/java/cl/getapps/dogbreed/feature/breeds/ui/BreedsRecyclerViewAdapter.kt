package cl.getapps.dogbreed.feature.breeds.ui

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cl.getapps.dogbreed.R
import cl.getapps.dogbreed.core.ui.BaseRecyclerViewAdapter
import cl.getapps.dogbreed.feature.breeddetail.ui.BreedDetailActivity
import kotlinx.android.synthetic.main.item_content.view.*

class BreedsRecyclerViewAdapter : BaseRecyclerViewAdapter<String>() {

    private val onClickListener: View.OnClickListener

    init {
        onClickListener = View.OnClickListener { v ->
            val item = v.tag as String
            val intent = Intent(v.context, BreedDetailActivity::class.java).apply {
                putExtra(BreedDetailActivity.ARGS.BREED_NAME, item)
            }
            v.context.startActivity(intent)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_content, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = values.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = values[position]
        holder as ViewHolder
        holder.breedName.text = item

        with(holder.itemView) {
            tag = item
            setOnClickListener(onClickListener)
        }
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val breedName: TextView = view.breed_name
    }
}
