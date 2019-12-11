package com.example.zooapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.animal_ticket.ivAnimal

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

    val bundle: Bundle? = intent.extras
        val name = bundle!!.getString("name")
        val des = bundle!!.getString("des")
        val image = bundle.getInt("image")
        ivAnimal.setImageResource(image)
        tvNamee.text = name
        tvDese.text = des
    }
}
