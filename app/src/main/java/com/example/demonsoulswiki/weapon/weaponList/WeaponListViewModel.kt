package com.example.demonsoulswiki.weapon.weaponList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demonsoulswiki.weapon.GetWeaponUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeaponListViewModel @Inject constructor(
    private val getWeaponUseCase: GetWeaponUseCase
) : ViewModel() {

    val weaponListFlow = getWeaponUseCase.weaponListFlow

    init {
        getWeaponList()
    }

    private fun getWeaponList() = viewModelScope.launch {
        getWeaponUseCase.getWeaponInfo()
    }
}