package layout

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.example.typesofadapter.R

class CustomBaseAdapter(val imagedata:Array<Int>,val contextloc: Context) :BaseAdapter() {
    private val colorlist = colors()

    override fun getItem(position: Int): Any {
        return colorlist[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return imagedata.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val inflater = parent?.context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val view = inflater.inflate(R.layout.item_array_row,null)
        val clickebtn = view.findViewById<Button>(R.id.click_btn)
        val imageview = view.findViewById<ImageView>(R.id.imagveiewl_list)
        clickebtn.text = colorlist[position].first
        imageview.setImageResource(imagedata[position])

        clickebtn.setOnClickListener {
            Toast.makeText(contextloc,"color: ${colorlist[position].first}",Toast.LENGTH_SHORT).show();


            val activity  = parent.context as Activity


            val viewGroup = activity.findViewById<ViewGroup>(android.R.id.content)
                .getChildAt(0)


            viewGroup.setBackgroundColor(colorlist[position].second)

        }
        return view
    }



    // Custom method to generate list of color name value pair
    private fun colors():MutableList<Pair<String,Int>>{
        return mutableListOf(
            Pair("INDIANRED", Color.parseColor("#CD5C5C")),
            Pair("LIGHTCORAL", Color.parseColor("#F08080")),
            Pair("SALMON", Color.parseColor("#FA8072")),
            Pair("DARKSALMON", Color.parseColor("#E9967A")),
            Pair("LIGHTSALMON", Color.parseColor("#FFA07A")),
            Pair("CRIMSON", Color.parseColor("#DC143C")),
            Pair("RED", Color.parseColor("#FF0000"))

        )
    }
}