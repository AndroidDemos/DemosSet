package com.eus.flex

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.google.android.flexbox.*
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    var adapter: Adapter? = null
    var flexboxLayoutManager: FlexboxLayoutManager? = null
    var pos = 11
    val mutableList = mutableListOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        if (pos == 0) {

        } else if (pos == 11) {
            Log.e("tag-first 11--", "tags$pos")
        } else if (pos == 11) {
            Log.e("tag-second 11--", "tags$pos")
        }
        adapter = Adapter()
        flexboxLayoutManager = FlexboxLayoutManager(this)
//        flexboxLayoutManager?.justifyContent = JustifyContent.SPACE_EVENLY
        flexboxLayoutManager?.justifyContent = JustifyContent.FLEX_START
        flexboxLayoutManager?.flexWrap = FlexWrap.WRAP
        flexboxLayoutManager?.flexDirection = FlexDirection.ROW
        recyclerview.layoutManager = flexboxLayoutManager
        recyclerview.adapter = adapter
        radio_group.setOnCheckedChangeListener(object : RadioGroup.OnCheckedChangeListener {
            override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
                when (checkedId) {
                    R.id.rb_around -> {
                        flexboxLayoutManager?.justifyContent = JustifyContent.SPACE_AROUND
                    }
                    R.id.rb_between -> {
                        flexboxLayoutManager?.justifyContent = JustifyContent.SPACE_BETWEEN
                    }
                    R.id.rb_center -> {
                        flexboxLayoutManager?.justifyContent = JustifyContent.CENTER
                    }
                    R.id.rb_evenly -> {
                        flexboxLayoutManager?.justifyContent = JustifyContent.SPACE_EVENLY
                    }
                    R.id.rb_start -> {
                        flexboxLayoutManager?.justifyContent = JustifyContent.FLEX_START
                    }
                    R.id.rb_end -> {
                        flexboxLayoutManager?.justifyContent = JustifyContent.FLEX_END
                    }
                }
            }
        })
    }

    inner class Adapter : RecyclerView.Adapter<VH>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
            val inflate = layoutInflater.inflate(R.layout.item_flex, parent, false)
            return VH(inflate)
        }

        override fun getItemCount(): Int {
            return mutableList.size
        }

        override fun onBindViewHolder(holder: VH, position: Int) {
            var itemView = holder.itemView as TextView
            itemView.text = "--0----$position---123"
        }


    }

    open class VH(view: View) : ViewHolder(view) {
        var tv1 = view as TextView
    }

}
