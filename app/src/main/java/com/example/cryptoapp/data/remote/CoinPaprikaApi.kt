package com.example.cryptoapp.data.remote

import com.example.cryptoapp.data.remote.dto.CoinDetailDto
import com.example.cryptoapp.data.remote.dto.CoinDto

interface CoinPaprikaApi {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(
    coinId: String
    ): CoinDetailDto
}