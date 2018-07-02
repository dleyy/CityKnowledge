package cityknowledge.cityknowledge.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import cityknowledge.cityknowledge.R
import kotlinx.android.synthetic.main.view_knowledge_item.view.*

/**
 * Created by lilei on 2018/6/27.
 */
class KnowledgeListAdapter(var context: Context):
        RecyclerView.Adapter<KnowledgeListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view:View = LayoutInflater.from(context).inflate(R.layout.view_knowledge_item,
                parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        with(holder?.itemView!!){
            holder.textView.text = position.toString()
        }
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var textView:TextView = itemView.findViewById(R.id.message)
    }
}
