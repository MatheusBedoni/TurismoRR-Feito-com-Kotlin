package com.app.redes.turismorr
import android.content.Intent
import android.net.Uri
import kotlinx.android.synthetic.main.activity_main.*
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import java.util.ArrayList

class MainActivity : AppCompatActivity() {


    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)


    }

    override fun onResume() {
        super.onResume()
        var frag: TipsFragment? = supportFragmentManager.findFragmentByTag("mainFrag") as? TipsFragment
        if (frag == null) {
            frag = TipsFragment()
            Log.i("TAG", "fragment")
            val ft = supportFragmentManager.beginTransaction()
            ft.replace(R.id.rl_fragment_container, frag, "mainFrag")
            ft.commit()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == android.R.id.home) {
            finish()
        }
        if (id == R.id.maps) {
//            val intent = Intent(baseContext, MapsActivity::class.java)
//            startActivity(intent)
//            finish()
        }
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_perfil, menu)
        return true
    }

    fun pedidos(): List<Tips> {
        val listAux = ArrayList<Tips>()
        val tips = Tips()
        tips.setNome("Parque Nacional do Monte Roraima")
        tips.setPhoto(R.drawable.monte_roraima)
        tips.setDescricao("O Parque Nacional do Monte Roraima foi criado em 28 de junho de 1989 pelo então presidente da república do Brasil José Sarney, através do Decreto nº 97.887. Lá se encontram belíssimas savanas, muitas florestas de altitude e rios de correnteza forte. Também se localizam no Parque algumas das mais antigas montanhas da terra, destacando-se aí o Monte Roraima. É um costume se dizer que quem vai ao Monte Roraima não se arrepende. Isso dizem os próprios roraimenses. Aventureiros abrem a imaginação, pelo fato de o Monte possuir uma forma estranha de mesa, denominada pelos índios de \"Tepuí\". Na região existem muitas espécies de samambaias e bromélias")
        listAux.add(tips)
        val tips2 = Tips()
        tips2.setNome("Parque Nacional do Viruá")
        tips2.setDescricao("O Parque Nacional do Viruá é um parque nacional brasileiro localizado em Roraima. Constitui um grande mosaico de campinaranas, alternando formações abertas e florestais, marcado por enorme heterogeneidade ambiental, resultando em uma elevada biodiversidade, e tem se tornado referência no estudo desse tipo de ecossistema na Amazônia. ")
        tips2.setPhoto(R.drawable.parque_nacional_virua)
        listAux.add(tips2)
        val tips3 = Tips()
        tips3.setNome("Tepequém")
        tips3.setDescricao("A serra do Tepequém é um acidente geográfico localizado no município brasileiro de Amajari, estado de Roraima. Situa-se a 210 km da capital, Boa Vista, e apresenta atrativos como o platô da serra do Tepequém, que chega a 1.022m de altitude. A economia baseia-se no turismo e no artesanato.")
        tips3.setPhoto(R.drawable.tepequem)
        listAux.add(tips3)
        val tips4 = Tips()
        tips4.setNome("Pedra Pintada")
        tips4.setDescricao("A Pedra Pintada é uma formação rochosa considerada um sítio arqueológico encontrada no estado de Roraima. Tem mais de 35 metros de altura, numa altitude de 83 metros em relação ao nível do mar. ")
        tips4.setPhoto(R.drawable.pedra_pintada)
        listAux.add(tips4)

        return listAux
    }


}
