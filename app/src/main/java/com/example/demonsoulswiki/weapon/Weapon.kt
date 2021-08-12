package com.example.demonsoulswiki.weapon


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
@Entity(tableName = "Weapon")
data class Weapon(
    @Json(name = "auxDamage")
    val auxDamage: String,
    @Json(name = "auxType")
    val auxType: String,
    @Json(name = "criticalDamage")
    val criticalDamage: Int,
    @Json(name = "dexBonus")
    val dexBonus: String,
    @Json(name = "dexReq")
    val dexReq: Int,
    @Json(name = "durability")
    val durability: Int,
    @Json(name = "faithBonus")
    val faithBonus: String,
    @Json(name = "faithReq")
    val faithReq: Int,
    @Json(name = "fireAtk")
    val fireAtk: Int,
    @Json(name = "fireDef")
    val fireDef: Int,
    @Json(name = "guardBreakReduction")
    val guardBreakReduction: Int,
    @Json(name = "location")
    val location: String,
    @Json(name = "magAtk")
    val magAtk: Int,
    @Json(name = "magDef")
    val magDef: Int,
    @Json(name = "name")
    @PrimaryKey
    val name: String,
    @Json(name = "physAtk")
    val physAtk: Int,
    @Json(name = "physDef")
    val physDef: Int,
    @Json(name = "strBonus")
    val strBonus: String,
    @Json(name = "strReq")
    val strReq: Int,
    @Json(name = "typesString")
    val typesString: String,
    @Json(name = "weaponType")
    val weaponType: String,
    @Json(name = "weight")
    val weight: Double
)