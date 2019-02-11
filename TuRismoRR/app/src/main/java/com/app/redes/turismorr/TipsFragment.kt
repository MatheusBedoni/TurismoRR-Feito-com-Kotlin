package com.app.redes.turismorr

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.redes.turismorr.auxiliares.RecyclerViewOnClickListenerHack

/**
 * Created by Matt on 06/02/2019.
 */
class TipsFragment : Fragment(), RecyclerViewOnClickListenerHack {

    private var recyclerView: RecyclerView? = null
    private var list: List<Tips>? = null
    private var adapter: TipsAdapter? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_tips, container, false)
        //O app cria as listas usando o Recycler View
        recyclerView = view.findViewById(R.id.rv_list)
        recyclerView!!.setHasFixedSize(true)
        recyclerView!!.setOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
            }

            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
            }
        })

        list = (activity as MainActivity).pedidos()
        adapter = TipsAdapter(activity, list)
        val llm = LinearLayoutManager(activity)
        llm.orientation = LinearLayoutManager.VERTICAL

        recyclerView!!.layoutManager = llm
        adapter!!.setRecyclerViewOnClickListenerHack(this)
        recyclerView!!.adapter = adapter
        return view
    }


    override fun onClickListener(view: View, position: Int) {
        //O app usa o Parcelable para passar os dados dos objetos de uma tela pra outra
        //Economizando a internet do usuario e deixando o app mais rapido e eficiente
        val intent = Intent(activity, TipsActivity::class.java)
        intent.putExtra("tips", list!!.get(position))
        activity.startActivity(intent)
    }
}
