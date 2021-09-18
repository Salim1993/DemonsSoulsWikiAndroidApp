package com.example.demonsoulswiki

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import com.example.demonsoulswiki.weapon.Weapon
import com.example.demonsoulswiki.weapon.WeaponListComponents
import com.example.demonsoulswiki.weapon.weaponList.WeaponListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    val weaponListViewModel by viewModels<WeaponListViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface() {
                WeaponListScreen(weaponListViewModel = weaponListViewModel)
            }
        }
    }

    @Composable
    private fun WeaponListScreen(weaponListViewModel: WeaponListViewModel) {
        val list: List<Weapon> by weaponListViewModel.weaponListFlow.collectAsState(initial = listOf())
        WeaponListComponents.WeaponList(
            list = list
        )
    }
}