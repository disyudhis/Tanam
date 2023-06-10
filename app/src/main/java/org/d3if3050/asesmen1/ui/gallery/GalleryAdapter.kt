package org.d3if3050.asesmen1.ui.gallery

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.d3if3050.asesmen1.R
import org.d3if3050.asesmen1.databinding.GalleryListBinding
import org.d3if3050.asesmen1.model.Galeri
import org.d3if3050.asesmen1.network.TanamanApi

class GalleryAdapter : RecyclerView.Adapter<GalleryAdapter.ViewHolder>() {

    private val data = mutableListOf<Galeri>()

    fun updateData(newData: List<Galeri>) {
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }

    class ViewHolder(
        private val binding: GalleryListBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(galeri: Galeri) = with(binding) {
            namaTextView.text = galeri.nama
            latinTextView.text = galeri.namaLatin
            Glide.with(imageView.context)
                .load(TanamanApi.getTanamanUrl(galeri.imageRes))
                .error(R.drawable.ic_broken_image)
                .into(imageView)

            root.setOnClickListener {
                val message = root.context.getString(R.string.message, galeri.nama)
                Toast.makeText(root.context, message, Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = GalleryListBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }


}