package com.example.demonsoulswiki.networking

import com.example.demonsoulswiki.weapon.Weapon
import retrofit2.http.GET

interface DarkSoulsApiService {

    @GET("/weapon")
    suspend fun getWeapons(): List<Weapon>
}