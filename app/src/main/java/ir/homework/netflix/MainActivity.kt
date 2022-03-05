package ir.homework.netflix

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
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
}