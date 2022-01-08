package com.example.demonsoulswiki.weapon

import dagger.assisted.AssistedFactory

@AssistedFactory
interface WeaponDetailViewModelAssistedFactory {

    fun create(name: String): WeaponDetailViewModel
}