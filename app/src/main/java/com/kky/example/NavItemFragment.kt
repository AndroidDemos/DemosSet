package com.kky.example

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.kky.example.R.id.list
import com.kky.example.mview.MyFragmetRecyclerViewAdapter
import com.kky.example.util.ActivityHelp
import kotlinx.android.synthetic.main.fragment_navitem.*

/**
 * A fragmentArray representing a list of Items.
 * Activities containing this fragmentArray MUST implement the
 * [NavItemFragment.OnListFragmentInteractionListener] interface.
 */
class NavItemFragment : Fragment() {

    private var listener: OnListFragmentInteractionListener? = null
    private var mTabIndex: Int = 0
    var myData = mutableListOf<Map<String, Any>>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            mTabIndex = it.getInt(ARG_TAB_INDEX)
            myData = ActivityHelp.setList(mTabIndex,activity)
//            myData = ActivitiesUtil.getData(mPrefix, activity)
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_navitem, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(list) {
            layoutManager = LinearLayoutManager(context)
            adapter = MyFragmetRecyclerViewAdapter(mTabIndex, myData, listener)
        }

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
        fun onListFragmentInteraction(item: Map<String, Any>?)
    }

    companion object {
        const val ARG_TAB_INDEX = "tab-index"

        fun newInstance(tab_index: Int): NavItemFragment {
            val fragment = NavItemFragment()
            var args = Bundle().apply {
                putInt(ARG_TAB_INDEX, tab_index)
            }
            fragment.arguments = args
            return fragment
        }
    }

}
