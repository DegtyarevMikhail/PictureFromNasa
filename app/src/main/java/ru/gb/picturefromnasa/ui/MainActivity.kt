package ru.gb.picturefromnasa.ui

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.materialapp.ui.SettingsFragment
import com.example.materialapp.ui.THEME
import ru.gb.picturefromnasa.R
import ru.gb.picturefromnasa.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        val theme = getPreferences(Context.MODE_PRIVATE)
            .getInt(THEME, R.style.AppTheme_GreenTheme)
        setTheme(theme)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, SettingsFragment())
            .commit()

        binding.mainBottomNavigation.setOnItemSelectedListener { id ->
            when (id.itemId) {
                R.id.bottom_menu_pic_of_day -> {
                    loadFragment(MainFragment())
                    true
                }
                R.id.bottom_menu_settings -> {
                    loadFragment(SettingsFragment())
                    true
                }
                else -> false
            }
        }
        binding.mainBottomNavigation.selectedItemId = R.id.bottom_menu_settings
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
        supportFragmentManager.popBackStack()
    }

}