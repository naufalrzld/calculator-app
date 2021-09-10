package com.example.calculatorapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HistoryAdapter : RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {

    var histories = listOf<HistoryData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_history,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(histories[position])
    }

    override fun getItemCount() = histories.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val tvBilangan = view.findViewById<TextView>(R.id.tv_bilangan)
        private val tvHasil = view.findViewById<TextView>(R.id.tv_hasil)

        fun bind(history: HistoryData) {
            tvBilangan.text = history.bilangan
            tvHasil.text = history.hasil
        }
    }
}