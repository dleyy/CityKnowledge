package cityknowledge.cityknowledge.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import cityknowledge.cityknowledge.R
import com.bumptech.glide.Glide
import com.example.domain.modle.ItemDetailRank
import com.jude.easyrecyclerview.adapter.BaseViewHolder
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter

/**
 * Created by lilei on 2018/7/16.
 */
class ItemDetailAdapter(var context1: Context) : RecyclerArrayAdapter<ItemDetailRank>(context1) {
    override fun OnCreateViewHolder(parent: ViewGroup?, viewType: Int): BaseViewHolder<*> {
        var view = LayoutInflater.from(context1)
                .inflate(R.layout.view_item_detail, parent, false)
        return MyHolder(view)
    }

    class MyHolder(view: View) : BaseViewHolder<ItemDetailRank>(view) {

        var userIcon: ImageView = view.findViewById(R.id.item_icon)
        var title: TextView = view.findViewById(R.id.item_title)

        override fun setData(data: ItemDetailRank?) {
            Glide.with(context).load(data?.icon).into(userIcon)
            title.text = data?.title
        }
    }
}