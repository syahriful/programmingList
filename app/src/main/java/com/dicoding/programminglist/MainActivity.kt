package com.dicoding.programminglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    private var list: ArrayList<Lang> = arrayListOf()
    private var title: String = ""
    private lateinit var rviewProglang: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rviewProglang = findViewById(R.id.rView_ProgLang)
        rviewProglang.setHasFixedSize(true)

        list.addAll(LangData.listData)
        showRecyclerCardView()
    }

    private fun showRecyclerCardView() {
        rviewProglang.layoutManager = GridLayoutManager(this, 2)
        val cardViewHeroAdapter = CardHeroAdapter(list)
        rviewProglang.adapter = cardViewHeroAdapter

        cardViewHeroAdapter.setOnItemClickCallback(object : CardHeroAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Lang) {
                showSelectedLang(data)
            }
        })
    }

    private fun showSelectedLang(lang: Lang) {
        Toast.makeText(this, lang.name, Toast.LENGTH_SHORT).show()
    }


}