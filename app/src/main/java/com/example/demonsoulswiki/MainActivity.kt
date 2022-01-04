package com.example.demonsoulswiki

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.demonsoulswiki.weapon.Weapon
import com.example.demonsoulswiki.weapon.WeaponListComponents
import com.example.demonsoulswiki.weapon.weaponList.WeaponListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val WEAPON_ROUTE = "weapon"

    val weaponListViewModel by viewModels<WeaponListViewModel>()


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
                WeaponListScreen(weaponListViewModel = weaponListViewModel, navController = navController)
            }

            composable(
                route = "$WEAPON_ROUTE/{weaponName}",
                arguments = listOf(
                    navArgument("weaponName") {
                        type = NavType.StringType
                    }
                )) { entry ->
                    val weaponName = entry.arguments!!.getString("weaponName", "Default")
                    SingleWeapon(weapon = weaponName)
                }
        }
    }

    @Composable
    fun SingleWeapon(weapon: String) {
        Text(text = weapon)
    }

    @Composable
    private fun WeaponListScreen(weaponListViewModel: WeaponListViewModel, navController: NavHostController) {
        val list: List<Weapon> by weaponListViewModel.weaponListFlow.collectAsState(initial = listOf())
        WeaponListComponents.WeaponList(
            list = list,
            onWeaponClick = { weaponName ->
                navigateToSingleWeapon(navController = navController, weaponName = weaponName)
            }
        )
    }

    private fun navigateToSingleWeapon(navController: NavHostController, weaponName: String) {
        navController.navigate("$WEAPON_ROUTE/$weaponName")
    }
}