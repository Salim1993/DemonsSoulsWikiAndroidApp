package com.example.demonsoulswiki.weapon.weaponDetail

import androidx.lifecycle.ViewModel
import com.example.demonsoulswiki.weapon.Weapon
import com.example.demonsoulswiki.weapon.WeaponDao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class WeaponDetailViewModel @Inject constructor(
    private val weaponDao: WeaponDao
) : ViewModel() {

    fun getWeaponDetails(weaponName: String): Flow<Weapon> {
        return weaponDao.getSingleWeapon(weaponName)
    }
}