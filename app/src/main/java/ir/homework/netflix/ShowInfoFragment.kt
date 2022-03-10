package ir.homework.netflix

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.*
import androidx.appcompat.view.menu.MenuBuilder
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ir.homework.netflix.databinding.FragmentProfileBinding
import ir.homework.netflix.databinding.FragmentShowInfoBinding

class ShowInfoFragment : Fragment() {
    lateinit var binding: FragmentShowInfoBinding
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentShowInfoBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
    }

    private fun initViews() {
        binding.tvFullName.text = "نام و نام خانوادگی: " + sharedPreferences.getString("fullName", "")
        binding.tvEmail.text = "آدرس ایمیل: " + sharedPreferences.getString("email", "")
        binding.tvPhoneNumber.text = "شماره تلفن: " + sharedPreferences.getString("phoneNumber", "")
        binding.tvUsername.text = "نام کاربری: " + sharedPreferences.getString("username", "")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        sharedPreferences = context.getSharedPreferences("pref", Context.MODE_PRIVATE)
    }

    @SuppressLint("RestrictedApi")
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_profile,menu)
        if (menu is MenuBuilder) {
            menu.setOptionalIconsVisible(true)
        }
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_home -> {
                findNavController().navigate(R.id.action_showInfoFragment_to_homeFragment)
                return true
            }
            R.id.menu_coming_soon ->{
                findNavController().navigate(R.id.action_showInfoFragment_to_comingSoonFragment)
                return true
            }
            R.id.menu_favorite ->{
                findNavController().navigate(R.id.action_showInfoFragment_to_favoriteFragment)
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}