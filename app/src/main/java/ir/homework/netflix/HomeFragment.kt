package ir.homework.netflix

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.*
import android.widget.ImageView
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.appcompat.view.menu.MenuBuilder
import androidx.navigation.fragment.findNavController
import ir.homework.netflix.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        setOnClickListeners()
    }

    fun setOnClickListeners(){
        binding.iv1.setOnClickListener{
            onFilmClick(1, binding.ivFavorite1)
        }
        binding.iv2.setOnClickListener{
            onFilmClick(2, binding.ivFavorite2)
        }
        binding.iv3.setOnClickListener{
            onFilmClick(3, binding.ivFavorite3)
        }
        binding.iv4.setOnClickListener{
            onFilmClick(4, binding.ivFavorite4)
        }
        binding.iv5.setOnClickListener{
            onFilmClick(5, binding.ivFavorite5)
        }
        binding.iv6.setOnClickListener{
            onFilmClick(6, binding.ivFavorite6)
        }
        binding.iv7.setOnClickListener{
            onFilmClick(7, binding.ivFavorite7)
        }
        binding.iv8.setOnClickListener{
            onFilmClick(8, binding.ivFavorite8)
        }
        binding.iv9.setOnClickListener{
            onFilmClick(9, binding.ivFavorite9)
        }
        binding.iv10.setOnClickListener{
            onFilmClick(10, binding.ivFavorite10)
        }
        binding.iv11.setOnClickListener{
            onFilmClick(11, binding.ivFavorite11)
        }
        binding.iv12.setOnClickListener{
            onFilmClick(12, binding.ivFavorite12)
        }
    }

    fun onFilmClick(num: Int, view: ImageView){
        Netflix.filmList[num - 1].hasLiked = true
        view.setImageResource(R.drawable.ic_baseline_favorite_24)
    }
    @SuppressLint("UseCompatLoadingForDrawables")
    fun initViews(){
        Netflix.setData()
        binding.iv1.setImageResource(Netflix.filmList[0].srcId)
        binding.iv2.setImageResource(Netflix.filmList[1].srcId)
        binding.iv3.setImageResource(Netflix.filmList[2].srcId)
        binding.iv4.setImageResource(Netflix.filmList[3].srcId)
        binding.iv5.setImageResource(Netflix.filmList[4].srcId)
        binding.iv6.setImageResource(Netflix.filmList[5].srcId)
        binding.iv7.setImageResource(Netflix.filmList[6].srcId)
        binding.iv8.setImageResource(Netflix.filmList[7].srcId)
        binding.iv9.setImageResource(Netflix.filmList[8].srcId)
        binding.iv10.setImageResource(Netflix.filmList[9].srcId)
        binding.iv11.setImageResource(Netflix.filmList[10].srcId)
        binding.iv12.setImageResource(Netflix.filmList[11].srcId)

        binding.tv1.text = Netflix.filmList[0].title
        binding.tv2.text = Netflix.filmList[1].title
        binding.tv3.text = Netflix.filmList[2].title
        binding.tv4.text = Netflix.filmList[3].title
        binding.tv5.text = Netflix.filmList[4].title
        binding.tv6.text = Netflix.filmList[5].title
        binding.tv7.text = Netflix.filmList[6].title
        binding.tv8.text = Netflix.filmList[7].title
        binding.tv9.text = Netflix.filmList[8].title
        binding.tv10.text = Netflix.filmList[9].title
        binding.tv11.text = Netflix.filmList[10].title
        binding.tv12.text = Netflix.filmList[11].title
    }

    @SuppressLint("RestrictedApi")
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_home,menu)
        if (menu is MenuBuilder) {
            menu.setOptionalIconsVisible(true)
        }
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_coming_soon ->{
                findNavController().navigate(R.id.action_homeFragment_to_comingSoonFragment)
                return true
            }
            R.id.menu_favorite ->{
                findNavController().navigate(R.id.action_homeFragment_to_favoriteFragment)
                return true
            }
            R.id.menu_profile ->{
                findNavController().navigate(R.id.action_homeFragment_to_profileFragment)
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}