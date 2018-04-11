package com.kky.example

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kky.example.base.fragment.BaseFragment
import com.kky.example.mview.MyFragmetRecyclerViewAdapter

/**
 * A fragment representing a list of Items.
 * Activities containing this fragment MUST implement the
 * [NavItemFragment.OnListFragmentInteractionListener] interface.
 */
class NavItemFragment : Fragment() {


    private var listener: OnListFragmentInteractionListener? = null
    private var mTabIndex: Int = 0
    private var mItemCount: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            mTabIndex = it.getInt(ARG_TAB_INDEX)
            mItemCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_fragmet_list, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = LinearLayoutManager(context)
                adapter = MyFragmetRecyclerViewAdapter(mTabIndex, mItemCount, listener)
            }
        }
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnListFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnListFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onListFragmentInteraction(item: Int?)
    }

    companion object {
        const val ARG_COLUMN_COUNT = "column-count"
        const val ARG_TAB_INDEX = "tab-index"
        const val NAV_TAB_VIEW = 1
        const val NAV_TAB_UI = 2
        const val NAV_TAB_EVENT = 3

        fun newInstance(tab_index: Int, columnCount: Int) =
                NavItemFragment().apply {
                    arguments = Bundle().apply {
                        putInt(ARG_TAB_INDEX, tab_index)
                        putInt(ARG_COLUMN_COUNT, columnCount)
                    }
                }
    }
}
