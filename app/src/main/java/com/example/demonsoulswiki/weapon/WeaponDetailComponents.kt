package com.example.demonsoulswiki.weapon


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.demonsoulswiki.R

object WeaponDetailComponents {

    @Composable
    fun WeaponDetail(weapon: Weapon) {
        val rowPadding = PaddingValues(0.dp, 8.dp)
        val startTextPadding = PaddingValues(0.dp, 0.dp, 8.dp, 0.dp)
        Column(modifier = Modifier.padding(16.dp, 0.dp)) {
            Row {
                Text(text = stringResource(id = R.string.weapon_name), modifier = Modifier.padding(startTextPadding))
                Text(text = weapon.name)
            }

            Row {
                Text(text = stringResource(id = R.string.weapon_type), modifier = Modifier.padding(startTextPadding))
                Text(text = weapon.weaponType)
            }

            Row {
                Text(text = stringResource(id = R.string.weapon_physical_attack), modifier = Modifier.padding(startTextPadding))
                Text(text = weapon.physAtk.toString())
            }

            Row {
                Text(text = stringResource(id = R.string.weapon_physical_defense), modifier = Modifier.padding(startTextPadding))
                Text(text = weapon.physDef.toString())
            }

            Row {
                Text(text = stringResource(id = R.string.weapon_magic_attack), modifier = Modifier.padding(startTextPadding))
                Text(text = weapon.magAtk.toString())
            }

            Row {
                Text(text = stringResource(id = R.string.weapon_magic_defense), modifier = Modifier.padding(startTextPadding))
                Text(text = weapon.magDef.toString())
            }

            Row {
                Text(text = stringResource(id = R.string.weapon_fire_attack), modifier = Modifier.padding(startTextPadding))
                Text(text = weapon.fireAtk.toString())
            }

            Row {
                Text(text = stringResource(id = R.string.weapon_fire_defense), modifier = Modifier.padding(startTextPadding))
                Text(text = weapon.fireDef.toString())
            }

            Row {
                Text(text = stringResource(id = R.string.weapon_aux_damage), modifier = Modifier.padding(startTextPadding))
                Text(text = weapon.auxDamage)
            }

            Row {
                Text(text = stringResource(id = R.string.weapon_str_req), modifier = Modifier.padding(startTextPadding))
                Text(text = weapon.strReq.toString())
            }

            Row {
                Text(text = stringResource(id = R.string.weapon_str_bonus), modifier = Modifier.padding(startTextPadding))
                Text(text = weapon.strBonus)
            }

            Row {
                Text(text = stringResource(id = R.string.weapon_dex_req), modifier = Modifier.padding(startTextPadding))
                Text(text = weapon.dexReq.toString())
            }

            Row {
                Text(text = stringResource(id = R.string.weapon_dex_bonus), modifier = Modifier.padding(startTextPadding))
                Text(text = weapon.dexBonus)
            }

            Row {
                Text(text = stringResource(id = R.string.weapon_dex_req), modifier = Modifier.padding(startTextPadding))
                Text(text = weapon.dexReq.toString())
            }

            Row {
                Text(text = stringResource(id = R.string.weapon_dex_bonus), modifier = Modifier.padding(startTextPadding))
                Text(text = weapon.dexBonus)
            }

            Row {
                Text(text = stringResource(id = R.string.weapon_faith_req), modifier = Modifier.padding(startTextPadding))
                Text(text = weapon.faithReq.toString())
            }

            Row {
                Text(text = stringResource(id = R.string.weapon_faith_bonus), modifier = Modifier.padding(startTextPadding))
                Text(text = weapon.faithBonus)
            }

            Row {
                Text(text = stringResource(id = R.string.weapon_crit_dam), modifier = Modifier.padding(startTextPadding))
                Text(text = weapon.criticalDamage.toString())
            }

            Row {
                Text(text = stringResource(id = R.string.weapon_guard_break_dam), modifier = Modifier.padding(startTextPadding))
                Text(text = weapon.guardBreakReduction.toString())
            }

            Row {
                Text(text = stringResource(id = R.string.weapon_weight), modifier = Modifier.padding(startTextPadding))
                Text(text = weapon.weight.toString())
            }

            Row {
                Text(text = stringResource(id = R.string.weapon_durability), modifier = Modifier.padding(startTextPadding))
                Text(text = weapon.durability.toString())
            }

            Text(text = stringResource(id = R.string.weapon_location))
            Text(text = weapon.location)
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

@Preview
@Composable
fun PreviewWeaponDetail() = WeaponDetailComponents.WeaponDetail(PREVIEW_WEAPON)