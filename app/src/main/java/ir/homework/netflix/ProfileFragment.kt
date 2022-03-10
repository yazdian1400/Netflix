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

class ProfileFragment : Fragment() {
    lateinit var binding: FragmentProfileBinding
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setOnClickListeners()
    }

    private fun setOnClickListeners(){
        binding.btnSubmit.setOnClickListener{
            if (binding.etName.text.isNullOrBlank()){
                binding.etName.error = "لطفا نام و نام خانوادگی خود را وارد کنید."
            } else if (binding.etEmail.text.isNullOrBlank()) {
                binding.etEmail.error = "لطفا آدرس ایمیل خود را وارد کنید."
            } else {
                Netflix.hasRegistered = true
                val editor = sharedPreferences.edit()
                editor.putString("fullName", binding.etName.text.toString())
                editor.putString("email", binding.etEmail.text.toString())
                editor.putString("phoneNumber", binding.etPhoneNumber.text.toString())
                editor.putString("username", binding.etUsername.text.toString())
                editor.apply()
                findNavController().navigate(R.id.action_profileFragment_to_showInfoFragment)
            }
        }
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
                findNavController().navigate(R.id.action_profileFragment_to_homeFragment)
                return true
            }
            R.id.menu_coming_soon ->{
                findNavController().navigate(R.id.action_profileFragment_to_comingSoonFragment)
                return true
            }
            R.id.menu_favorite ->{
                findNavController().navigate(R.id.action_profileFragment_to_favoriteFragment)
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}