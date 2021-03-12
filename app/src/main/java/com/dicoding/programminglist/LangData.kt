package com.dicoding.programminglist

object LangData {
    private val langNames = arrayOf("Kotlin",
        "Java",
        "C",
        "C++",
        "C#",
        "Python",
        "Visual Basic.NET",
        "PHP",
        "Swift",
        "TypeScript",
        "Scala",
        "JavaScript")

    private val langImages = intArrayOf(R.drawable.kotlin_icon,
        R.drawable.java_icon,
        R.drawable.c_icon,
        R.drawable.cpp_icon,
        R.drawable.csharp_icon,
        R.drawable.python_icon,
        R.drawable.vbnet_icon,
        R.drawable.php_icon,
        R.drawable.swift_icon,
        R.drawable.typescript_icon,
        R.drawable.scala_icon,
        R.drawable.javascript_icon)

    private val langRecommend = arrayOf("Mobile App & Android Development",
        "Mobile App & Android Development, Desktop App",
        "Embedded System, Hardware Drivers",
        "Game Development, Desktop App, Embedded Software",
        "Game Development, Desktop App",
        "Artificial Intelligence, Website ( using web framework )",
        "Desktop App",
        "Website ( best for Back-End Website )",
        "Apple Mobile and Desktop app",
        "Website",
        "Software FrameWork, Website",
        "Website ( best for Front-End Website )")
    // private val langDetails = arrayOf("")


    val listData: ArrayList<Lang>
        get() {
            val list = arrayListOf<Lang>()
            for (position in langNames.indices) {
                val lang = Lang()
                lang.name = langNames[position]
                lang.recommend = langRecommend[position]
                lang.photo = langImages[position]
                list.add(lang)
            }
            return list
        }
}