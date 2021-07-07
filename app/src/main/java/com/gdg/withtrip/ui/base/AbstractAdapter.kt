package com.gdg.withtrip.ui.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

abstract class AbstractAdapter<T> : RecyclerView.Adapter<ViewHolder>() {

    protected val array: ArrayList<T> = arrayListOf()

    override fun getItemCount(): Int = array.count()

    abstract fun getViewHolder(viewType: Int, view: View): ViewHolder

    fun submit(array: List<T>) {
        this.array.addAll(array)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(viewType, parent, false)
        return getViewHolder(viewType, view)
    }
}