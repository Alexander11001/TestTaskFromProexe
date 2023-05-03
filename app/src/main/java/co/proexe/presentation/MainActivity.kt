package co.proexe.presentation

import android.os.Bundle
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.fragment.NavHostFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(co.proexe.R.layout.activity_main)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        val navHostFragment =
            supportFragmentManager.findFragmentById(co.proexe.R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController

//        val toolbar: Toolbar = findViewById(co.proexe.R.id.toolbar)
//        setSupportActionBar(toolbar)
    }


}