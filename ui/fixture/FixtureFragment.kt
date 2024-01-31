package com.example.fypkotlin.ui.fixture

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fypkotlin.R
import com.example.fypkotlin.base.BaseVMFragment
import com.example.fypkotlin.util.Constant
import com.example.fypkotlin.util.CustomSharedPreferences
import kotlinx.android.synthetic.main.fragment_fixture.progressFixture
import kotlinx.android.synthetic.main.fragment_fixture.rvFixture


class FixtureFragment : BaseVMFragment<FixtureViewModel>() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fixture, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var customPreferences = CustomSharedPreferences(activity?.applicationContext!!)
        val leagueId = customPreferences.getCountryId()

        viewModel.getAllFixtureOfLeague(leagueId!!)
        viewModel.fixtureList.observe(viewLifecycleOwner, Observer {
            it?.let {
                rvFixture.layoutManager = LinearLayoutManager(context)
                rvFixture.adapter = FixtureAdapter(it){
                    val bundle = bundleOf(Constant.FIXTURE_TEAM_IDS to it)
                    Navigation.findNavController(view).navigate(R.id.action_fixtureFragment_to_fixtureDetailFragment, bundle)
                }
            }
        })

        viewModel.loadinFixture.observe(viewLifecycleOwner, Observer {
            it?.let {
                if (it){
                    rvFixture.visibility = View.GONE
                    progressFixture.visibility = View.VISIBLE
                }else{
                    rvFixture.visibility = View.VISIBLE
                    progressFixture.visibility = View.GONE
                }
            }
        })
    }

    override fun getViewModel(): Class<FixtureViewModel> = FixtureViewModel::class.java

}
