package com.example.demonsoulswiki.weapon.weaponDetail


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.demonsoulswiki.R
import com.example.demonsoulswiki.weapon.Weapon
import dagger.hilt.android.AndroidEntryPoint

object WeaponDetailComponents {

    @Composable
    fun WeaponDetailsScreen(weaponName: String, weaponDetailViewModel: WeaponDetailViewModel) {
        val weapon: Weapon by weaponDetailViewModel.getWeaponDetails(weaponName).collectAsState(initial = DEFAULT_WEAPON)

        WeaponDetail(
            weapon = weapon
        )
    }

    @Composable
    fun WeaponDetail(weapon: Weapon) {
        Column(modifier = Modifier
            .padding(16.dp, 0.dp)
            .verticalScroll(rememberScrollState()))
        {
            WeaponDetailsRow(headerStringId = R.string.weapon_name,
                weaponText = weapon.name)

            WeaponDetailsRow(headerStringId = R.string.weapon_type,
                weaponText = weapon.weaponType)

            WeaponDetailsRow(headerStringId = R.string.weapon_physical_attack,
                weaponText = weapon.physAtk.toString())

            WeaponDetailsRow(headerStringId = R.string.weapon_physical_defense,
                weaponText = weapon.physDef.toString())

            WeaponDetailsRow(headerStringId = R.string.weapon_magic_attack,
                weaponText = weapon.magAtk.toString())

            WeaponDetailsRow(headerStringId = R.string.weapon_magic_defense,
                weaponText = weapon.magDef.toString())

            WeaponDetailsRow(headerStringId = R.string.weapon_fire_attack,
                weaponText = weapon.fireAtk.toString())

            WeaponDetailsRow(headerStringId = R.string.weapon_fire_defense,
                weaponText = weapon.fireDef.toString())

            WeaponDetailsRow(headerStringId = R.string.weapon_aux_damage,
                weaponText = weapon.auxDamage)

            WeaponDetailsRow(headerStringId = R.string.weapon_str_req,
                weaponText = weapon.strReq.toString())

            WeaponDetailsRow(headerStringId = R.string.weapon_str_bonus,
                weaponText = weapon.strBonus)

            WeaponDetailsRow(headerStringId = R.string.weapon_dex_req,
                weaponText = weapon.dexReq.toString())

            WeaponDetailsRow(headerStringId = R.string.weapon_dex_bonus,
                weaponText = weapon.dexBonus)

            WeaponDetailsRow(headerStringId = R.string.weapon_faith_req,
                weaponText = weapon.faithReq.toString())

            WeaponDetailsRow(headerStringId = R.string.weapon_faith_bonus,
                weaponText = weapon.faithBonus)

            WeaponDetailsRow(headerStringId = R.string.weapon_crit_dam,
                weaponText = weapon.criticalDamage.toString())

            WeaponDetailsRow(headerStringId = R.string.weapon_guard_break_dam,
                weaponText = weapon.guardBreakReduction.toString())

            WeaponDetailsRow(headerStringId = R.string.weapon_weight,
                weaponText = weapon.weight.toString())

            WeaponDetailsRow(headerStringId = R.string.weapon_durability,
                weaponText = weapon.durability.toString())

            Text(text = stringResource(id = R.string.weapon_location))
            Text(modifier = Modifier.padding(0.dp, 8.dp, 0.dp, 24.dp), text = weapon.location)
        }
    }

    @Composable
    fun WeaponDetailsRow(headerStringId: Int, weaponText: String) {
        val rowPadding = PaddingValues(0.dp, 8.dp)
        val startTextPadding = PaddingValues(0.dp, 0.dp, 8.dp, 0.dp)

        return Row(modifier = Modifier.padding(rowPadding)) {
            Text(text = stringResource(id = headerStringId), modifier = Modifier.padding(startTextPadding))
            Text(text = weaponText)
        }
    }
}

private val PREVIEW_WEAPON = Weapon("",
    "",
    0,
    "",
    0,
    0,
    "",
    0,
    0,
    0,
    0,
    "",
    0,
    0,
    "Test",
    0,
    0,
    "",
    0,
    "",
    "LMAO",
    0.0
)

private val DEFAULT_WEAPON = Weapon("",
    "",
    0,
    "",
    0,
    0,
    "",
    0,
    0,
    0,
    0,
    "",
    0,
    0,
    "",
    0,
    0,
    "",
    0,
    "",
    "",
    0.0
)

@Preview
@Composable
fun PreviewWeaponDetail() = WeaponDetailComponents.WeaponDetail(PREVIEW_WEAPON)