package com.example.androiddagger2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.Component
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var info: Info
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DaggerMagicBox.create().poke(this)
        text_view.text = info.text
    }
}

class Info @Inject constructor() {
    val text = "Hello Dagger 2"
}

@Component
interface MagicBox {
    fun poke(app: MainActivity)
}
