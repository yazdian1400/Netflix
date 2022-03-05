package ir.homework.netflix

import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.menu.MenuBuilder


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        forceRTLIfSupported()
    }

    @SuppressLint("RestrictedApi")
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        if (menu is MenuBuilder) {
            menu.setOptionalIconsVisible(true)
        }
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_home -> {
                Toast.makeText(applicationContext, "click on home", Toast.LENGTH_LONG).show()
                true
            }
            R.id.menu_coming_soon ->{
                Toast.makeText(applicationContext, "click on coming soon", Toast.LENGTH_LONG).show()
                return true
            }
            R.id.menu_favorite ->{
                Toast.makeText(applicationContext, "click on favorite", Toast.LENGTH_LONG).show()
                return true
            }
            R.id.menu_profile ->{
                Toast.makeText(applicationContext, "click on favorite", Toast.LENGTH_LONG).show()
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    private fun forceRTLIfSupported() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            window.decorView.layoutDirection = View.LAYOUT_DIRECTION_RTL
        }
    }
}