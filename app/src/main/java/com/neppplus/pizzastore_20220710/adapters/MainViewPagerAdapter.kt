package com.neppplus.pizzastore_20220710.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.neppplus.pizzastore_20220710.fragments.ChickenFragment
import com.neppplus.pizzastore_20220710.fragments.PizzaFragment
import com.neppplus.pizzastore_20220710.fragments.ProfileFragment

class MainViewPagerAdapter(
    fm : FragmentManager
) : FragmentPagerAdapter(fm) {

    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
        when(position) {
            0 -> {
                return PizzaFragment()
            }
            1 -> {
                return ChickenFragment()
            }
            else -> {
                return ProfileFragment()
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when(position) {
            0 -> {
                return "피자 가게"
            }
            1 -> {
                return "치킨 가게"
            }
            else -> {
                return "내 정보 설정"
            }
        }
    }
}