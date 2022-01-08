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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.demonsoulswiki.weapon.*
import com.example.demonsoulswiki.weapon.weaponList.WeaponListViewModel
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val WEAPON_ROUTE = "weapon"

    //val weaponListViewModel by viewModels<WeaponListViewModel>()

    @Inject
    lateinit var assistedFactory: WeaponDetailViewModelAssistedFactory


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
                WeaponListScreen(navController = navController)
            }

            composable(
                route = "$WEAPON_ROUTE/{weaponName}",
                arguments = listOf(
                    navArgument("weaponName") {
                        type = NavType.StringType
                    }
                )) { entry ->
                    val weaponName = entry.arguments!!.getString("weaponName", "Default")
                    WeaponDetailsScreen(navController = navController, weaponName = weaponName)
                }
        }
    }

    @Composable
    private fun WeaponListScreen(navController: NavHostController) {

        val weaponListViewModel by viewModels<WeaponListViewModel>()

        val list: List<Weapon> by weaponListViewModel.weaponListFlow.collectAsState(initial = listOf())
        WeaponListComponents.WeaponList(
            list = list,
            onWeaponClick = { weaponName ->
                navigateToSingleWeapon(navController = navController, weaponName = weaponName)
            }
        )
    }

    @Composable
    private fun WeaponDetailsScreen(navController: NavHostController, weaponName: String) {

        val weaponDetailViewModel: WeaponDetailViewModel by viewModels {
            WeaponDetailViewModel.Factory(assistedFactory, weaponName)
        }

        //have to call this since view model does not refresh on new detail navigation. Wondering how I can
        // alternatively do this
        weaponDetailViewModel.updateWeaponDetails(weaponName)

        val weapon: Weapon by weaponDetailViewModel.weaponDetailFlow.collectAsState(initial = DEFAULT_WEAPON)

        Timber.d("Going to weapon: ${weapon.name}")

        WeaponDetailComponents.WeaponDetail(
            weapon = weapon
        )
    }

    private fun navigateToSingleWeapon(navController: NavHostController, weaponName: String) {
        navController.navigate("$WEAPON_ROUTE/$weaponName")
    }

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
}