package com.example.zooapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.animal_ticket.view.*

class MainActivity : AppCompatActivity() {
    var animalList = ArrayList<Animal>()
    var adapter:AnimalAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
            //TODO load animals
        animalList.add(Animal("Baboon","Baboon is the animal that took care of Simba", R.drawable.baboon,true))
        animalList.add(Animal("Bulldog","Spike from Tom&Jerry is a Bulldog", R.drawable.bulldog,false))
        animalList.add(Animal("Panda","Pandas are the Cutest Bears ever!", R.drawable.panda,false))
        animalList.add(Animal("Swallow-Bird","The swallows, martins and saw-wings, or Hirundinidae", R.drawable.swallow_bird,false))
        animalList.add(Animal("White Tiger","White Tigers are the rarest animals", R.drawable.white_tiger,true))
        animalList.add(Animal("Zebra","Zebras are the old-fashioned donkeys", R.drawable.zebra,false))
        adapter = AnimalAdapter(this,animalList)
        tvAnimalList.adapter = adapter

    }
class AnimalAdapter: BaseAdapter{
    var animalList = ArrayList<Animal>()
    var context:Context?= null
    constructor(context: Context, animalList :ArrayList<Animal>):super(){
        this.animalList=animalList
        this.context = context
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val animal = animalList[position]
        var inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        if(animal.isKiller==true){
            var myView = inflater.inflate(R.layout.animal_killer_ticket,null)
            myView.tvNamee.text=animal.name!!
            myView.ivAnimal.setImageResource(animal.image!!)
            myView.tvDescription.text = animal.des!!
            myView.ivAnimal.setOnClickListener{
                val intent = Intent(context, Main2Activity::class.java)
                intent.putExtra("name",animal.name!!)
                intent.putExtra("des",animal.des!!)
                intent.putExtra("image",animal.image!!)
                context!!.startActivity(intent)
            }
            return myView

        }else{
            var myView = inflater.inflate(R.layout.animal_ticket,null)
            myView.tvNamee.text=animal.name!!
            myView.ivAnimal.setImageResource(animal.image!!)
            myView.tvDescription.text = animal.des!!
            myView.ivAnimal.setOnClickListener{
                val intent = Intent(context, Main2Activity::class.java)
                intent.putExtra("name",animal.name!!)
                intent.putExtra("des",animal.des!!)
                intent.putExtra("image",animal.image!!)
                context!!.startActivity(intent)
            }
            return myView
        }

    }

    override fun getItem(position: Int): Any {
        return animalList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return animalList.size
    }

}
}
