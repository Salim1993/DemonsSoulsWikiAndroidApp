package com.example.demonsoulswiki.weapon.weaponList

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.demonsoulswiki.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WeaponListFragment : Fragment(R.layout.weapon_list_fragment) {

    private val viewModel: WeaponListViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //do stuff
    }
}