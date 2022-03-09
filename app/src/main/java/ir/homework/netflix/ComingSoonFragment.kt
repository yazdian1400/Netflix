package ir.homework.netflix

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.appcompat.view.menu.MenuBuilder
import androidx.navigation.fragment.findNavController
import ir.homework.netflix.databinding.FragmentComingSoonBinding
import ir.homework.netflix.databinding.FragmentHomeBinding


class ComingSoonFragment : Fragment() {
    lateinit var binding: FragmentComingSoonBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentComingSoonBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
    }

    private fun initViews() {
        binding.ivSoon1.setImageResource(Netflix.comingSoonList[0].srcId)
        binding.ivSoon2.setImageResource(Netflix.comingSoonList[1].srcId)
        binding.ivSoon3.setImageResource(Netflix.comingSoonList[2].srcId)

        binding.tvSoon1.text = Netflix.comingSoonList[0].title
        binding.tvSoon2.text = Netflix.comingSoonList[1].title
        binding.tvSoon3.text = Netflix.comingSoonList[2].title
    }

    @SuppressLint("RestrictedApi")
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_coming_soon,menu)
        if (menu is MenuBuilder) {
            menu.setOptionalIconsVisible(true)
        }
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_home -> {
                findNavController().navigate(R.id.action_comingSoonFragment_to_homeFragment)
                return true
            }
            R.id.menu_favorite ->{
                findNavController().navigate(R.id.action_comingSoonFragment_to_favoriteFragment)
                return true
            }
            R.id.menu_profile ->{
                findNavController().navigate(R.id.action_comingSoonFragment_to_profileFragment)
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}