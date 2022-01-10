package com.example.demonsoulswiki

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.demonsoulswiki.weapon.weaponDetail.WeaponDetailComponents.WeaponDetailsScreen
import com.example.demonsoulswiki.weapon.weaponDetail.WeaponDetailViewModel
import com.example.demonsoulswiki.weapon.weaponList.WeaponListComponents
import com.example.demonsoulswiki.weapon.weaponList.WeaponListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface {
                DarkSoulsApp()
            }
        }
    }

    @Composable
    fun DarkSoulsApp(){
        val navController = rememberNavController()

        Scaffold { innerPadding ->
            MyNavHost(navController = navController, modifier = Modifier.padding(innerPadding))
        }
    }

    @Composable
    fun MyNavHost(navController: NavHostController, modifier: Modifier = Modifier) {
        NavHost(navController = navController, modifier = modifier, startDestination = "List") {
            composable("List") {
                val weaponListViewModel by viewModels<WeaponListViewModel>()

                WeaponListComponents.WeaponListScreen(
                    weaponListViewModel = weaponListViewModel
                ) { weaponName ->
                    navigateToSingleWeapon(navController, weaponName)
                }
            }

            composable(
                route = "$WEAPON_ROUTE/{weaponName}",
                arguments = listOf(
                    navArgument("weaponName") {
                        type = NavType.StringType
                    }
                )) { entry ->
                    val weaponName = entry.arguments!!.getString("weaponName", "Default")
                    val weaponDetailViewModel by viewModels<WeaponDetailViewModel>()
                    WeaponDetailsScreen(weaponName = weaponName, weaponDetailViewModel = weaponDetailViewModel)
                }
        }
    }

    private fun navigateToSingleWeapon(navController: NavHostController, weaponName: String) {
        navController.navigate("$WEAPON_ROUTE/$weaponName")
    }

    companion object {
        private const val WEAPON_ROUTE = "weapon"
    }
}