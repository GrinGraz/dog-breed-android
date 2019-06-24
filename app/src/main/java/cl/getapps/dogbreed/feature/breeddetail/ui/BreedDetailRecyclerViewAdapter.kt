package cl.getapps.dogbreed.feature.breeddetail.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import cl.getapps.dogbreed.R
import cl.getapps.dogbreed.core.ui.BaseRecyclerViewAdapter
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.image_content.view.*

class BreedDetailRecyclerViewAdapter : BaseRecyclerViewAdapter<String>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.image_content, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = values.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = values[position]
        holder as ViewHolder
        Picasso.get().load(item).fit().centerCrop().into(holder.breedName)
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val breedName: ImageView = view.breed_image
    }
}
