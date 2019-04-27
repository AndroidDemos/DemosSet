package com.kky.example.mview


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.kky.example.R
import com.kky.example.NavItemFragment.OnListFragmentInteractionListener
import kotlinx.android.synthetic.main.fragment_activity_list.view.*

/**
 * [RecyclerView.Adapter] that can display a [DummyItem] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 */
class MyFragmetRecyclerViewAdapter(
        private val mTabs: Int,
        private val mValues: MutableList<Map<String, Any>>,
        private val mListener: OnListFragmentInteractionListener?)
    : RecyclerView.Adapter<MyFragmetRecyclerViewAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_activity_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues.get(position)
        holder.mContentView.text = item.get("title").toString()
        //TODO 从sparseArray中获取对应的值
        with(holder.mView) {
            tag = position
            setOnClickListener({
                mListener?.onListFragmentInteraction(item)
            })
        }
    }

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {

        val mContentView: TextView = mView.content
        override fun toString(): String {
            return super.toString() + " '" + mContentView.text + "'"
        }
    }
}
