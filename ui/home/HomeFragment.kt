package com.example.fypkotlin.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.fypkotlin.R
import com.example.fypkotlin.ui.home.leaguetable.LeagueTableFragment
import com.example.fypkotlin.ui.home.topscorer.TopScorerFragment
import com.example.fypkotlin.util.CustomSharedPreferences
import kotlinx.android.synthetic.main.fragment_home.tabLayout
import kotlinx.android.synthetic.main.fragment_home.viewPager


class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        var customPreferences = CustomSharedPreferences(activity?.applicationContext!!)

        val a = customPreferences.getCountryId()

        Toast.makeText(requireContext(), " id : "+a, Toast.LENGTH_SHORT).show()
        setupUI()

    }

    private fun setupUI(){
        setupViewpager()
        tabLayout.setupWithViewPager(viewPager)
    }

    private fun setupViewpager() {
        val adapter = fragmentManager?.let { ViewPagerAdapter(it) }
        adapter?.apply {
            addFragment(LeagueTableFragment(), "League Table")
            addFragment(TopScorerFragment(), "Top Scorers")
        }
        viewPager.adapter = adapter
//        viewPager.offscreenPageLimit = 2
    }

}
