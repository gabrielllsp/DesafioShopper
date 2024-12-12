package com.gabriel.desafioshopper.presentation.ride_options.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gabriel.desafioshopper.databinding.DriverItemBinding
import com.gabriel.desafioshopper.domain.model.RideOption

class DriverOptionsAdapter(
    private var drivers: List<RideOption>,
    private val onDriverSelected: (RideOption) -> Unit
) : RecyclerView.Adapter<DriverOptionsAdapter.MyViewHolder>() {

    class MyViewHolder(val binding: DriverItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            DriverItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = drivers.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = drivers[position]

        holder.binding.textDriverName.text = item.name
        holder.binding.textVehicle.text = item.vehicle ?: "N/A"
        holder.binding.textPrice.text = item.value.toString()
        holder.binding.rating.text = item.reviewResponse?.toString() ?: "0"

        holder.binding.btnChoose.setOnClickListener {
            onDriverSelected(item)
        }
    }
}
