package com.example.livedata.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.livedata.databinding.ItemRvBinding
import com.example.livedata.models.MyCurrency

class MyRvAdapter(val list: ArrayList<MyCurrency>):RecyclerView.Adapter<MyRvAdapter.Vh>() {

    inner class Vh(val itemRvBinding: ItemRvBinding):RecyclerView.ViewHolder(itemRvBinding.root){
        fun onBind(myCurrency: MyCurrency,position:Int){
            itemRvBinding.tvName.text = myCurrency.CcyNm_UZC
            itemRvBinding.tvRate.text = myCurrency.Rate
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemRvBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int=list.size

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position],position)
    }
}