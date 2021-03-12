package com.dicoding.programminglist

object LangData {
    private val langNames = arrayOf("Kotlin",
        "Python")
    private val langDetails = arrayOf("Kotlin adalah blablablabla blablablabla blablablabla",
        "Python adalah bla bla bla")
    private val langImages = intArrayOf(R.drawable.kotlin_icon,
        R.drawable.python_icon
        )

    val listData: ArrayList<Lang>
        get() {
            val list = arrayListOf<Lang>()
            for (position in langNames.indices) {
                val lang = Lang()
                lang.name = langNames[position]
                lang.detail = langDetails[position]
                lang.photo = langImages[position]
                list.add(lang)
            }
            return list
        }
}