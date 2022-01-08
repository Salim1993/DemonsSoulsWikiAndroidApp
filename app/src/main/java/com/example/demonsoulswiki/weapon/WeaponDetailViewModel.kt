package com.example.demonsoulswiki.weapon

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.demonsoulswiki.weapon.GetWeaponUseCase
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

class WeaponDetailViewModel @AssistedInject constructor(
    val weaponDao: WeaponDao,
    @Assisted private val weaponName: String
) : ViewModel() {

    var weaponDetailFlow = weaponDao.getSingleWeapon(weaponName)

    fun updateWeaponDetails(weaponName: String) {
        weaponDetailFlow = weaponDao.getSingleWeapon(weaponName)
    }

    class Factory(
        private val assistedFactory: WeaponDetailViewModelAssistedFactory,
        private val name: String,
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return assistedFactory.create(name) as T
        }
    }
}