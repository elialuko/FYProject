package com.example.fypkotlin.ui.fixture

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.fypkotlin.R
import com.example.fypkotlin.databinding.ItemFixtureBinding
import com.example.fypkotlin.model.fixture.Fixture

class FixtureAdapter(val fixtureList:List<Fixture>, val onItemClick:(Fixture)->Unit):RecyclerView.Adapter<FixtureAdapter.FixtureViewHolder>() {
    class FixtureViewHolder(var view:ItemFixtureBinding):RecyclerView.ViewHolder(view.root) {
        fun bind(fixture: Fixture, onItemClick: (Fixture) -> Unit){
            itemView.setOnClickListener {
                onItemClick(fixture)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FixtureViewHolder {
        val inflate = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<ItemFixtureBinding>(inflate, R.layout.item_fixture,parent,false)
        return FixtureViewHolder(view)
    }

    override fun getItemCount(): Int = fixtureList.size

    override fun onBindViewHolder(holder: FixtureViewHolder, position: Int) {
        holder.view.fixture = fixtureList[position]
        holder.bind(fixtureList[position], onItemClick)
    }
}