package com.shubhamahirwar.addpayapp.viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.shubhamahirwar.addpayapp.ui.fragment.BusinessFragment
import com.shubhamahirwar.addpayapp.ui.fragment.Category2Fragment

class ViewPagerAdapter(fm: FragmentManager) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> BusinessFragment()
            1 -> Category2Fragment()
            else -> BusinessFragment()
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "Business"
            1 -> "Category2"
            else -> "Business"
        }
    }
}