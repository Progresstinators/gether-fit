package de.progresstinators.getherfit.personal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import de.progresstinators.getherfit.R
import de.progresstinators.getherfit.shared.TrainingFragment

class PersonalFragment: Fragment() {

    /**
     * The view pager
     */
    private lateinit var viewPager: ViewPager2

    /**
     * The bottom navigation bar
     */
    private lateinit var bottomNav: BottomNavigationView

    /***
     * Initialize the view
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) : View {
        val view = inflater.inflate(R.layout.fragment_personal, container, false)

        // Instantiate the view pager
        viewPager = view.findViewById(R.id.view_pager)
        viewPager.adapter = ScreenSlidePagerAdapter(this)
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                when (position) {
                    1 -> bottomNav.selectedItemId = R.id.todo
                    2 -> bottomNav.selectedItemId = R.id.training
                    else -> bottomNav.selectedItemId = R.id.overview
                }
                super.onPageSelected(position)
            }
        })

        // Initialize the bottom navigation bar
        bottomNav = view.findViewById(R.id.bottom_navigation)
        bottomNav.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.todo -> {
                    viewPager.setCurrentItem(1, true)
                    true
                }
                R.id.training -> {
                    viewPager.setCurrentItem(2, true)
                    true
                }
                else -> {
                    viewPager.setCurrentItem(0, true)
                    true
                }
            }
        }

        return view
    }

    /**
     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
     * sequence.
     */
    private inner class ScreenSlidePagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
        /**
         * @return The page count
         */
        override fun getItemCount(): Int = 3
        /**
         * Find the right view for a given position
         *
         * @param position The required position
         * @return The corresponding fragment
         */
        override fun createFragment(position: Int): Fragment {
            return when(position) {
                1 -> TodoFragment()
                2 -> TrainingFragment()
                else -> OverviewFragment()
            }
        }
    }
}