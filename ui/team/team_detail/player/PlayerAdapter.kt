package com.example.fypkotlin.ui.team.team_detail.player

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.fypkotlin.R
import com.example.fypkotlin.databinding.ItemPlayerBinding
import com.example.fypkotlin.model.player.Player

class PlayerAdapter(val playerList: List<Player>, val onItemClick: (Player)->Unit):RecyclerView.Adapter<PlayerAdapter.PlayerViewHolder>() {
    class PlayerViewHolder(var view: ItemPlayerBinding):RecyclerView.ViewHolder(view.root) {
        fun bind(player : Player, onItemClick: (Player) -> Unit){
            itemView.setOnClickListener {
                onItemClick(player)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        val inflate = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<ItemPlayerBinding>(inflate, R.layout.item_player, parent,false)
        return PlayerViewHolder(view)
    }

    override fun getItemCount(): Int =playerList.size

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        holder.view.player = playerList[position]
        holder.bind(playerList[position],onItemClick)
    }
}