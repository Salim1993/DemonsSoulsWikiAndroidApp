package com.example.demonsoulswiki.weapon

import com.example.demonsoulswiki.networking.DarkSoulsApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import timber.log.Timber
import java.lang.Exception
import javax.inject.Inject

class GetWeaponUseCase @Inject constructor(
    val service: DarkSoulsApiService,
    val weaponDao: WeaponDao) {

    val weaponListFlow = weaponDao.getAllWeapons()

    suspend fun getWeaponInfo() {
        try {
            withContext(Dispatchers.IO) {
                val weaponList = service.getWeapons()
                weaponDao.insertWeaponList(weaponList)
            }
        } catch (e: HttpException) {
            e.printStackTrace()
        } catch (e: Exception) {
            Timber.e(e)
        }
    }
}