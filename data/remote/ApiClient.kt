package com.example.fypkotlin.data.remote

import com.example.fypkotlin.model.fixture.FixtureResponse
import com.example.fypkotlin.model.h2h.H2HResponse
import com.example.fypkotlin.model.leaguetable.LeagueTableResponse
import com.example.fypkotlin.model.player.PlayerResponse
import com.example.fypkotlin.model.statistic.StatisticsResponse
import com.example.fypkotlin.model.team.TeamResponse
import com.example.fypkotlin.model.topscorer.TopScorerResponse
import com.example.fypkotlin.model.transfer.TransferResponse
import com.example.fypkotlin.util.Constant
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class ApiClient {

    private val api = Retrofit.Builder()
        .baseUrl(Constant.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(ApiService::class.java)

    fun getLeagueTable(leagueId: Int):Single<LeagueTableResponse> = api.getLeagueTable(leagueId)
    fun getTopScorers(leagueId: Int):Single<TopScorerResponse> = api.getTopScorers(leagueId)
    fun getAllTeamsOfLeague(leagueId: Int):Single<TeamResponse> = api.getAllTeamsOfLeague(leagueId)
    fun getAllPlayersOfTeam(teamId: Int):Single<PlayerResponse> = api.getAllPlayersOfTeam(teamId)
    fun getAllTransfersOfTeam(teamId: Int):Single<TransferResponse> = api.getAllTransfersOfTeam(teamId)
    fun getAllFixtureOfLeague(leagueId: Int):Single<FixtureResponse> = api.getAllFixtureOfLeague(leagueId)
    fun getAllH2hItems(homeTeamId: Int, awayTeamId:Int):Single<H2HResponse> = api.getAllH2hItems(homeTeamId, awayTeamId)
    fun getFixtureStatistics(fixtureId:Int):Single<StatisticsResponse> = api.getFixtureStatistics(fixtureId)
}