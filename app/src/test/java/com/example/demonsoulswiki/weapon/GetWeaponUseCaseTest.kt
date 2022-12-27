package com.example.demonsoulswiki.weapon

import com.example.demonsoulswiki.networking.DarkSoulsApiService
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class GetWeaponUseCaseTest {

    //mocks
    @MockK
    lateinit var service: DarkSoulsApiService

    @RelaxedMockK
    lateinit var weaponDao: WeaponDao

    //System to test
    lateinit var getWeaponUseCase: GetWeaponUseCase

    @Before
    fun setup() {
        MockKAnnotations.init(this)

        coEvery { weaponDao.getAllWeapons() } returns emptyFlow()

        getWeaponUseCase = GetWeaponUseCase(service, weaponDao)
    }

    @Test
    fun `get weapon info successfully and save to database`() = runTest() {

        //arrange
        val weaponsList = listOf(
            WEAPON_1
        )

        coEvery { service.getWeapons() } returns weaponsList

        //act
        getWeaponUseCase.getWeaponInfo()

        //assert
        coVerify { weaponDao.insertWeaponList(weaponsList) }
    }

    companion object {
        private val WEAPON_1 = Weapon("",
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
            "weapon 1",
            0,
            0,
            "",
            0,
            "",
            "LMAO",
            0.0
        )

        private val WEAPON_2 = WEAPON_1.copy(name = "weapon 2")
    }
}