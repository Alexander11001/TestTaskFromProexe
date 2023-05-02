package co.proexe.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import co.proexe.R

class DateAdapter(private val dateList: List<String>) :
    RecyclerView.Adapter<DateAdapter.DateViewHolder>() {



    inner class DateViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val date = item.findViewById<TextView>(R.id.textDate)

        fun bind(item: String, position: Int) {
            date.text = item
            if (position == 2 ){
                date.setTextColor(itemView.resources.getColor(R.color.colorAccent))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DateViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.date_item, parent, false)
        return DateViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dateList.size
    }

    override fun onBindViewHolder(holder: DateViewHolder, position: Int) {
            holder.bind(dateList[position], position)
    }
}