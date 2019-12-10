package com.example.zooapp

import android.content.Context
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
        animalList.add(Animal("Baboon","Baboon is the animal that took care of Simba", R.drawable.baboon))
        animalList.add(Animal("Bulldog","Spike from Tom&Jerry is a Bulldog", R.drawable.bulldog))
        animalList.add(Animal("Panda","Pandas are the Cutest Bears ever!", R.drawable.panda))
        animalList.add(Animal("Swallow-Bird","The swallows, martins and saw-wings, or Hirundinidae", R.drawable.swallow_bird))
        animalList.add(Animal("White Tiger","White Tigers are the rarest animals", R.drawable.white_tiger))
        animalList.add(Animal("Zebra","Zebras are the old-fashioned donkeys", R.drawable.zebra))
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
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        val animal = animalList[position]
        var inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        var myView = inflater.inflate(R.layout.animal_ticket,null)
        myView.tvName.text=animal.name!!
        myView.ivAnimal.setImageResource(animal.image!!)
        myView.tvDescription.text = animal.des!!
        return myView
    }

    override fun getItem(position: Int): Any {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return animalList[position]
    }

    override fun getItemId(position: Int): Long {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return position.toLong()
    }

    override fun getCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return animalList.size
    }

}
}
