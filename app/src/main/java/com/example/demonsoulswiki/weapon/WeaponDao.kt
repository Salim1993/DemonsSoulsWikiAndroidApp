package com.example.demonsoulswiki.weapon

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface WeaponDao {

    @Query("SELECT * FROM weapon")
    fun getAllWeapons(): Flow<List<Weapon>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWeaponList(list: List<Weapon>)
}