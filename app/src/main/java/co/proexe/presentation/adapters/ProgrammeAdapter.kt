package co.proexe.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import co.proexe.R
import co.proexe.data.infrastructure.convertToString
import co.proexe.data.infrastructure.loadImage
import co.proexe.domain.model.TvProgramme

class ProgrammeAdapter :
    ListAdapter<TvProgramme, ProgrammeAdapter.ItemViewHolder>(ItemDiffCallback()) {

    private var onLongClickListener: ((TvProgramme) -> Unit)? = null

    fun setOnLongClickListener(listener: (TvProgramme) -> Unit) {
        onLongClickListener = listener
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.programme_item, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        init {
            itemView.setOnLongClickListener {
                onLongClickListener?.invoke(getItem(adapterPosition))
                true
            }
        }

        fun bind(item: TvProgramme) {
            val programmeName = itemView.findViewById<TextView>(R.id.txtName)
            val programmeTime = itemView.findViewById<TextView>(R.id.txtTime)
            val programmeImage = itemView.findViewById<ImageView>(R.id.imageLogo)
            val progressBar = itemView.findViewById<ProgressBar>(R.id.progressBar)

            programmeName.text = item.title
            programmeImage.loadImage(item.imageUrl)
            progressBar.setProgress(item.progressPercent, true)
            programmeTime.text =
                item.startTime.convertToString() + " - " + item.endTime.convertToString() + " | " + item.type
        }
    }

    class ItemDiffCallback : DiffUtil.ItemCallback<TvProgramme>() {
        override fun areItemsTheSame(oldItem: TvProgramme, newItem: TvProgramme): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: TvProgramme, newItem: TvProgramme): Boolean {
            return oldItem == newItem
        }
    }
}