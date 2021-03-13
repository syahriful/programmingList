package com.dicoding.programminglist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    private var list: ArrayList<Lang> = arrayListOf()
    private var title: String = "Programming List"
    private lateinit var rviewProglang: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setActionBarTitle(title)

        rviewProglang = findViewById(R.id.rView_ProgLang)
        rviewProglang.setHasFixedSize(true)

        list.addAll(LangData.listData)
        showRecyclerCardView()
    }

    private fun setActionBarTitle(title: String) {
        if(supportActionBar != null) {
            (supportActionBar as ActionBar).title = title
        }
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

    override fun onCreateOptionsMenu(menu: Menu): Boolean{
        menuInflater.inflate(R.menu.menu_layout, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when(selectedMode){
            R.id.action_card -> {
                title = "About"
                showRecyclerCardView()
            }
            R.id.action_about -> {
                title = "About"
                showAbout()
            }
        }
        setActionBarTitle(title)
    }

    private fun showAbout() {
        val moveIntent = Intent(this@MainActivity, AboutActivity::class.java)
        startActivity(moveIntent)
    }


}