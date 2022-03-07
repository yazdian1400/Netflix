package ir.homework.netflix

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.appcompat.view.menu.MenuBuilder
import androidx.navigation.fragment.findNavController
import ir.homework.netflix.databinding.FragmentFavoriteBinding
import ir.homework.netflix.databinding.FragmentHomeBinding

class FavoriteFragment : Fragment() {
    lateinit var binding: FragmentFavoriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoriteBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    @SuppressLint("RestrictedApi")
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_favorite,menu)
        if (menu is MenuBuilder) {
            menu.setOptionalIconsVisible(true)
        }
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_home -> {
                findNavController().navigate(R.id.action_favoriteFragment_to_homeFragment)
                return true
            }
            R.id.menu_coming_soon ->{
                findNavController().navigate(R.id.action_favoriteFragment_to_comingSoonFragment)
                return true
            }
            R.id.menu_profile ->{
                findNavController().navigate(R.id.action_favoriteFragment_to_profileFragment)
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}