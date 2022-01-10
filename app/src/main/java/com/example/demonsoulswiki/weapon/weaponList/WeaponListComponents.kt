package com.example.demonsoulswiki.weapon.weaponList

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.demonsoulswiki.weapon.Weapon

object WeaponListComponents {

    @Composable
    fun WeaponListScreen(
        weaponListViewModel: WeaponListViewModel,
        onWeaponClick: (String) -> Unit
    ) {

        val list: List<Weapon> by weaponListViewModel.weaponListFlow.collectAsState(initial = listOf())
        WeaponList(
            list = list,
            onWeaponClick = onWeaponClick
        )
    }

    @Composable
    fun WeaponList(list: List<Weapon>,
                   onWeaponClick: (String) -> Unit = {}) {
        LazyColumn {
            items(items = list) { weapon ->
                WeaponRow(weapon = weapon, onWeaponClick = onWeaponClick)
                Divider(color = Color.Gray)
            }
        }
    }

    @Composable
    fun WeaponRow(weapon: Weapon, onWeaponClick: (String) -> Unit) {
        Row(modifier =
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .clickable { onWeaponClick(weapon.name) }
        ) {
            Text(text = weapon.name)
            Text(
                text = weapon.weaponType,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.End
            )
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
fun PreviewWeaponList() = WeaponListComponents.WeaponList(list = listOf(PREVIEW_WEAPON))