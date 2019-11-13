package com.tj.a20191113_02_practicepizzastore.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.tj.a20191113_02_practicepizzastore.DetailActivity
import com.tj.a20191113_02_practicepizzastore.R
import com.tj.a20191113_02_practicepizzastore.datas.PizzaStoreData
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.pizza_store_item.*

class PizzaStoreAdapter(context: Context, res:Int, list: ArrayList<PizzaStoreData>) : ArrayAdapter<PizzaStoreData>(context, res, list) {
    var mContext = context
    var mList = list
    var inf = LayoutInflater.from(mContext)

    constructor(context: Context, list: ArrayList<PizzaStoreData>) : this(context, R.layout.pizza_store_item, list)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView

        if (tempRow == null) {
            tempRow = inf.inflate(R.layout.pizza_store_item, null)
        }

        var row = tempRow!!

        var record = mList.get(position)

        var pizzaStoreNameTxt = row.findViewById<TextView>(R.id.pizzaStoreNameTxt)
        var pizzaStoreLogoImg = row.findViewById<CircleImageView>(R.id.pizzaStoreLogoImg)
        var showDetailTxt = row.findViewById<TextView>(R.id.showDetailTxt)
        var pizzaStoreItem = row.findViewById<LinearLayout>(R.id.pizzaStoreItem)

        pizzaStoreNameTxt.text = record.name
        Glide.with(mContext).load(record.logoUrl).into(pizzaStoreLogoImg)


//        pizzaStoreItem.setOnClickListener {
//            var intent = Intent(mContext, DetailActivity::class.java)
//
//            intent.putExtra("name", record.name)
//            intent.putExtra("phoneNum", record.phoneNum)
//            intent.putExtra("logoUrl", record.logoUrl)
//
//            ContextCompat.startActivity(mContext, intent, null)
//        }
//
//        showDetailTxt.setOnClickListener {
//            var intent = Intent(mContext, DetailActivity::class.java)
//
//            intent.putExtra("name", record.name)
//            intent.putExtra("phoneNum", record.phoneNum)
//            intent.putExtra("logoUrl", record.logoUrl)
//
//            ContextCompat.startActivity(mContext, intent, null)
//        }

        return row
    }
}