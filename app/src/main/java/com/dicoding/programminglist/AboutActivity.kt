package com.dicoding.programminglist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import mehdi.sakout.aboutpage.AboutPage
import mehdi.sakout.aboutpage.Element


class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val adsElement = Element()
        adsElement.title = "Bangkit 2021 Student"
        val aboutPage = AboutPage(this)
            .isRTL(false)
            .enableDarkMode(false)
            .setImage(R.drawable.my_image)
            .addItem(Element().setTitle("Version 6.2"))
            .addItem(adsElement)
            .addGroup("MD-13")
            .addEmail("a2672484@bangkit.academy")
            .addPlayStore("com.ideashower.readitlater.pro")
            .addInstagram("SyahrifulH")
            .addGitHub("Dyne2014")
            .create()
        setContentView(aboutPage)
    }
}