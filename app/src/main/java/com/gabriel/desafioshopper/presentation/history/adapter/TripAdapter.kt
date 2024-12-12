package com.gabriel.desafioshopper.presentation.history.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gabriel.desafioshopper.databinding.HistoryItemBinding
import com.gabriel.desafioshopper.domain.model.Ride

class TripAdapter(
    private var item: List<Ride>,
    ) : RecyclerView.Adapter<TripAdapter.MyViewHolder>() {

    class MyViewHolder(val binding: HistoryItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            HistoryItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = item.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val items = item[position]

        holder.binding.textDriverName.text = items.driver.toString()
        holder.binding.textDate.text = items.date
        holder.binding.textOrigin.text = items.origin
        holder.binding.textDestination.text = items.destination
        holder.binding.textDistance.text = items.distance
        holder.binding.textTime.text = items.duration.toString()
        holder.binding.textPrice.text = items.value.toString()
    }
}
