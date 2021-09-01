package ps.aio.gazacars.ui.activities

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import ps.aio.gazacars.R
import ps.aio.gazacars.databinding.ActivityMainBinding
import ps.aio.gazacars.init.StandardActivity

class MainActivity : StandardActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding
    private lateinit var appBarConfigurationDrawer: AppBarConfiguration
    private lateinit var navController:NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding=DataBindingUtil.setContentView(this, R.layout.activity_main)
        setSupportActionBar(activityMainBinding.appBarLayoutIn.homeToolbar)
        val bottom_nav: BottomNavigationView = findViewById(R.id.bottom_nav)
        navController = findNavController(R.id.nav_host_fragment)
        bottom_nav.setupWithNavController(navController)
        bottom_nav.setOnNavigationItemReselectedListener {return@setOnNavigationItemReselectedListener}
        appBarConfigurationDrawer= AppBarConfiguration(
            navController.graph
            ,activityMainBinding.drawerLayout
        )
        activityMainBinding.navViewDrawer.setupWithNavController(navController = navController)
        setupActionBarWithNavController(navController, appBarConfigurationDrawer)
        bottom_nav.getOrCreateBadge(R.id.navigation_notifications).number=10

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfigurationDrawer) || super.onSupportNavigateUp()
    }
}