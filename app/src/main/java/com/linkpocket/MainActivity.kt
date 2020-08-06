package com.linkpocket

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val previewSet = mutableSetOf(
        Preview("Bar Do Chucrutes", "picapau", R.drawable.ic_launcher_background),
        Preview("Rafinhas", "chaves", R.drawable.ic_launcher_background),
        Preview("Samuquinha", "samurai", R.drawable.ic_launcher_background),
        Preview("Fêzinho", "pensando no frango", R.drawable.ic_launcher_background),
        Preview("Charleston", "10", R.drawable.ic_launcher_background)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler_cards_links.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            setup<LinkKeeperAdapter>(previewSet)
        }
    }
}