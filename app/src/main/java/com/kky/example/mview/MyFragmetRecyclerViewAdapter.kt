package com.kky.example.mview


import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.kky.example.MainActivity
import com.kky.example.NavItemFragment
import com.kky.example.R
import com.kky.example.base.fragment.BaseFragment
import com.kky.example.NavItemFragment.OnListFragmentInteractionListener
import kotlinx.android.synthetic.main.fragment_fragmet.view.*

/**
 * [RecyclerView.Adapter] that can display a [DummyItem] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 * TODO: Replace the implementation with code for your data type.
 */
class MyFragmetRecyclerViewAdapter(
        private val mTabs: Int,
        private val mValues: Int,
        private val mListener: OnListFragmentInteractionListener?)
    : RecyclerView.Adapter<MyFragmetRecyclerViewAdapter.ViewHolder>() {

    private val mOnClickListener: View.OnClickListener


    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as Int
            // Notify the active callbacks interface (the activity, if the fragment is attached to
            // one) that an item has been selected.
            mListener?.onListFragmentInteraction(item)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_fragmet, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues
        holder.mIdView.text = "" + position + 1

        //TODO 从sparseArray中获取对应的值
        when(mTabs){
            NavItemFragment.Companion.NAV_TAB_VIEW -> holder.mContentView.text = MainActivity.getSpArray(0)[position]
            NavItemFragment.Companion.NAV_TAB_UI -> holder.mContentView.text = MainActivity.getSpArray(1)[position]
            NavItemFragment.Companion.NAV_TAB_EVENT -> holder.mContentView.text = MainActivity.getSpArray(2)[position]
        }
        with(holder.mView) {
            tag = position
            setOnClickListener(mOnClickListener)
        }
    }

    override fun getItemCount(): Int = mValues

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mIdView: TextView = mView.item_number
        val mContentView: TextView = mView.content

        override fun toString(): String {
            return super.toString() + " '" + mContentView.text + "'"
        }
    }
}
