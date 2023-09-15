package com.example.cryptoapp.data.remote

import com.example.cryptoapp.common.CoinPaprikaRoutes
import com.example.cryptoapp.data.remote.dto.CoinDetailDto
import com.example.cryptoapp.data.remote.dto.CoinDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.RedirectResponseException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.client.request.get
import io.ktor.client.request.url

class CoinPaprikaApiImpl(
    private val client: HttpClient
): CoinPaprikaApi {
    override suspend fun getCoins(): List<CoinDto> {
        return try {
            client.get { url(CoinPaprikaRoutes.GET_COINS) }.body()
        }catch(e: RedirectResponseException) {
            // 3xx - responses
            println("Error: ${e.response.status.description}")
            emptyList()
        } catch(e: ClientRequestException) {
            // 4xx - responses
            println("Error: ${e.response.status.description}")
            emptyList()
        } catch(e: ServerResponseException) {
            // 5xx - responses
            println("Error: ${e.response.status.description}")
            emptyList()
        } catch(e: Exception) {
            println("Error: ${e.message}")
            emptyList()
        }
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return client.get { url(CoinPaprikaRoutes.GET_COINS + "/${coinId}") }.body()
    }

}