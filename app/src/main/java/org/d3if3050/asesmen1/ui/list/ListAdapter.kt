package org.d3if3050.asesmen1.ui.list

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import org.d3if3050.asesmen1.R
import org.d3if3050.asesmen1.databinding.ItemListBinding
import org.d3if3050.asesmen1.db.TanamEntity
import org.d3if3050.asesmen1.model.simpanData
import java.text.SimpleDateFormat
import java.util.*

class ListAdapter :
    androidx.recyclerview.widget.ListAdapter<TanamEntity, ListAdapter.ViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK =
            object : DiffUtil.ItemCallback<TanamEntity>() {
                override fun areItemsTheSame(oldItem: TanamEntity, newItem: TanamEntity): Boolean {
                    return oldItem.id == newItem.id
                }

                override fun areContentsTheSame(
                    oldItem: TanamEntity,
                    newItem: TanamEntity
                ): Boolean {
                    return oldItem == newItem
                }
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemListBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(
        private val binding: ItemListBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        private val dateFormatter = SimpleDateFormat("dd MMMM yyyy", Locale("id", "ID"))

        fun bind(item: TanamEntity) = with(binding) {
            val hasilTanam = item.simpanData()
            judul.text = hasilTanam.nama
            latin.text = hasilTanam.namaLatin
            desc.text = root.context.getString(
                R.string.deskripsi_x, hasilTanam.deskripsi.substring(0, 20)
            )
            tanggal.text = dateFormatter.format(Date(item.tanggal))
        }
    }
}



