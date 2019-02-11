package com.app.redes.turismorr

import android.os.Bundle
import android.os.Parcelable
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v4.app.FragmentTransaction
import android.util.Log
import kotlinx.android.synthetic.main.activity_tips.*

class TipsActivity : AppCompatActivity() {
    private var tips: Tips? = null
    override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_tips)
        if (intent != null && intent.extras != null && intent.extras!!.getParcelable<Parcelable>("tips") != null) {
            tips = intent.extras!!.getParcelable<Tips>("tips")
        }
        titulo.setText(tips!!.getNome())
        descricao.setText(tips!!.getDescricao())
        avatar.setImageResource(tips!!.getPhoto()!!)

   }

    override fun onResume() {
        super.onResume()

    }


}
