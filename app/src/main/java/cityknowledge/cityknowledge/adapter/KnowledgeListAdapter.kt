package cityknowledge.cityknowledge.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import cityknowledge.cityknowledge.R
import com.example.domain.modle.Article

/**
 * Created by lilei on 2018/6/27.
 */
class KnowledgeListAdapter(var context: Context,
                           var onClick:(con:Article)->Unit) :
        RecyclerView.Adapter<KnowledgeListAdapter.ViewHolder>() {

    var list = ArrayList<Article>()

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.view_knowledge_item,
                parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        with(holder?.itemView!!) {
            holder.textView.text = list[position].name
            holder.textView.setOnClickListener {
                onClick(list[position])
            }
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textView: TextView = itemView.findViewById(R.id.message)
    }

    fun setData(list: ArrayList<Article>) {
        this.list = list
        notifyDataSetChanged()
    }

    fun addData(list: ArrayList<Article>) {
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    fun cleanAllData(){
        this.list.clear()
        notifyDataSetChanged()
    }
}
