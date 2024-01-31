package com.example.fypkotlin.ui.home.leaguetable

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.fypkotlin.R
import com.example.fypkotlin.databinding.ItemLeagueTableBinding
import com.example.fypkotlin.model.leaguetable.Standing
import com.google.gson.Gson

class LeagueTableAdapter(val leagueTableList: List<List<Standing>>, val onItemClick:(Standing) -> Unit):RecyclerView.Adapter<LeagueTableAdapter.LeagueTableViewHolder>() {
    class LeagueTableViewHolder(var view : ItemLeagueTableBinding):RecyclerView.ViewHolder(view.root) {
        fun bind(standing: Standing, onItemClick: (Standing) -> Unit){
            itemView.setOnClickListener {
                onItemClick(standing)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeagueTableViewHolder {
        val inflate = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<ItemLeagueTableBinding>(inflate, R.layout.item_league_table, parent, false)
        return LeagueTableViewHolder(view)
    }

    override fun getItemCount(): Int = leagueTableList[0].size

    override fun onBindViewHolder(holder: LeagueTableViewHolder, position: Int) {
        val gs = Gson()
        val js = gs.toJson(leagueTableList[0][position])
        val standing = gs.fromJson(js, Standing::class.java)
        holder.view.table = standing
        holder.bind(standing,onItemClick)
    }


}