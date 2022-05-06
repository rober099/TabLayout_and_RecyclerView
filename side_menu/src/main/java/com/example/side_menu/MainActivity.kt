package com.example.side_menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.example.side_menu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var bind: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)
        views()
    }


    private fun views(){
        bind.navView.setNavigationItemSelectedListener { items ->
            items.isChecked = true
            bind.drawerLayout.closeDrawers()

            when (items.itemId) {
                R.id.profile -> openFrag(ProfileFragment())
                R.id.wallet -> Toast.makeText(this, "wallet", Toast.LENGTH_SHORT).show()
                R.id.settings -> Toast.makeText(this, "settings", Toast.LENGTH_SHORT).show()
                R.id.nav_offers -> Toast.makeText(this, "Offers", Toast.LENGTH_SHORT).show()
                R.id.log_out -> Toast.makeText(this, "Logout", Toast.LENGTH_SHORT).show()
            }

            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                bind.drawerLayout.openDrawer(GravityCompat.START)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onBackPressed() {
        if (bind.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            bind.drawerLayout.closeDrawers()
        } else {
            super.onBackPressed()
        }
    }

    private fun openFrag(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.container_frag,fragment).commit()
    }


}