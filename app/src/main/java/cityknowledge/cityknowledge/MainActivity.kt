package cityknowledge.cityknowledge

import android.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import cityknowledge.cityknowledge.adapter.KnowledgeListAdapter
import cityknowledge.cityknowledge.widget.CommonDialog
import com.example.data.net.response.GetReadingListsResponse
import com.example.domain.useCase.GetReadingListUseCase
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    var getReadingListUseCase: GetReadingListUseCase = GetReadingListUseCase()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        my_recycle.layoutManager = LinearLayoutManager(this)

        my_recycle.adapter = KnowledgeListAdapter(this)

        var list: ArrayList<String> = ArrayList()
        for (i in 1..5) {
            list.add(i.toString())
        }

        val mapp = mapOf("key" to 24, "name" to "zhangsan", "age" to 25)

        Log.e("haha", mapp["name"] as String)

        getReadingListUseCase.execute(object : DisposableObserver<GetReadingListsResponse>() {
            override fun onNext(t: GetReadingListsResponse) {
                Log.e("haha",t.list[0].name+"\n"+t.list[0].toString())
                Log.e("haha",t.message)
            }


            override fun onComplete() {
            }

            override fun onError(e: Throwable) {
                Log.e("haha",e.message)
            }

        })
    }


}
