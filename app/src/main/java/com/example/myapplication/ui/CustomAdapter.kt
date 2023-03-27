package com.example.myapplication.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.model.AdapterEntity
import com.example.myapplication.R

/*
* 列表数据
*/
class CustomAdapter(private val data: List<AdapterEntity>) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
         val tvName: TextView
         val tvFeeCny: TextView
         val tvFeeUsd: TextView
         val tvDate: TextView

        init {
            tvName = view.findViewById(R.id.tv_project_name)
            tvFeeCny = view.findViewById(R.id.tv_fee_cny)
            tvFeeUsd = view.findViewById(R.id.tv_fee_usd)
            tvDate = view.findViewById(R.id.tv_date)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_custom_adapter, viewGroup, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.tvName.text = data[position].name
        viewHolder.tvFeeCny.text = "${data[position].feeCny} CNY"
        viewHolder.tvFeeUsd.text = "${data[position].feeUsd} USD"
        viewHolder.tvDate.text = data[position].date
    }


    override fun getItemCount() = data.size

}