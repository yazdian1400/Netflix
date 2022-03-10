package ir.homework.netflix

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.view.menu.MenuBuilder
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ir.homework.netflix.databinding.FragmentComingSoonBinding


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
        setOnClickListeners()
    }

    private fun initViews() {
        binding.ivSoon1.setImageResource(Netflix.comingSoonList[0].srcId)
        binding.ivSoon2.setImageResource(Netflix.comingSoonList[1].srcId)
        binding.ivSoon3.setImageResource(Netflix.comingSoonList[2].srcId)

        binding.tvSoon1.text = Netflix.comingSoonList[0].title
        binding.tvSoon2.text = Netflix.comingSoonList[1].title
        binding.tvSoon3.text = Netflix.comingSoonList[2].title

    }

    private fun setOnClickListeners() {
        binding.ivShare1.setOnClickListener{
            onShareClick(0)
        }
        binding.ivShare2.setOnClickListener{
            onShareClick(1)
        }
        binding.ivShare3.setOnClickListener{
            onShareClick(2)
        }
    }

    private fun onShareClick(num: Int) {
        if (Netflix.hasRegistered) {
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, Netflix.comingSoonList[num].title)
                type = "text/plain"
            }
            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
        } else {
            Toast.makeText(activity, "شما هنوز ثبت نام نکرده اید!", Toast.LENGTH_LONG).show()
        }
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
                when (Netflix.hasRegistered){
                    true -> findNavController().navigate(R.id.action_comingSoonFragment_to_showInfoFragment)
                    else -> findNavController().navigate(R.id.action_comingSoonFragment_to_profileFragment)
                }
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}