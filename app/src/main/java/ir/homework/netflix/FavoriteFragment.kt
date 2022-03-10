package ir.homework.netflix

import android.annotation.SuppressLint
import android.opengl.Visibility
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.view.menu.MenuBuilder
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import ir.homework.netflix.databinding.FragmentFavoriteBinding

class FavoriteFragment : Fragment() {
    lateinit var binding: FragmentFavoriteBinding
    var numPage = 1
    var likedFilms = mutableListOf<Film>()
    private var numLikedFilm = 0

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        setOnClickListeners()
    }

    private fun setOnClickListeners(){
        binding.ivNext.setOnClickListener{
            nextPage()
        }
        binding.ivPrev.setOnClickListener{
            prevPage()
        }
    }
    private fun initViews(){
        likedFilms = Netflix.filmList.filter { it.hasLiked }.toMutableList()
        numLikedFilm = likedFilms.size
        if (!Netflix.hasRegistered){
            binding.tvMessageFavorite.isVisible = true
            binding.tvMessageFavorite.text = "شما هنوز ثبت نام نکرده اید!"
            binding.ivFavorite.isVisible = false
            binding.tvTitle.isVisible = false
            binding.ivNext.isVisible = false
            binding.ivPrev.isVisible = false
        }
        else if (numLikedFilm > 0) {
            binding.tvMessageFavorite.isVisible = false
            binding.ivFavorite.setImageResource(likedFilms[0].srcId)
            binding.tvTitle.text = likedFilms[0].title
        } else {
            binding.tvMessageFavorite.isVisible = true
            binding.tvMessageFavorite.text = "فیلمی انتخاب نشده است."
            binding.ivFavorite.isVisible = false
            binding.tvTitle.isVisible = false
            binding.ivNext.isVisible = false
            binding.ivPrev.isVisible = false

        }
        binding.ivPrev.setImageResource(R.drawable.ic_baseline_arrow_back_ios_24_disabled)
        if (1 == numLikedFilm)
            binding.ivNext.setImageResource(R.drawable.ic_baseline_arrow_forward_ios_24_disabled)
    }

    fun nextPage(){
        if (numPage + 1 <= numLikedFilm){
            numPage ++
            if (numPage == numLikedFilm)
                binding.ivNext.setImageResource(R.drawable.ic_baseline_arrow_forward_ios_24_disabled)
            binding.ivPrev.setImageResource(R.drawable.ic_baseline_arrow_back_ios_24)
            binding.ivFavorite.setImageResource(likedFilms[numPage - 1].srcId)
            binding.tvTitle.text = likedFilms[numPage - 1].title
        }
    }

    fun prevPage(){
        if (numPage - 1 >= 1){
            numPage --
            if (numPage == 1)
                binding.ivPrev.setImageResource(R.drawable.ic_baseline_arrow_back_ios_24_disabled)
            binding.ivNext.setImageResource(R.drawable.ic_baseline_arrow_forward_ios_24)
            binding.ivFavorite.setImageResource(likedFilms[numPage - 1].srcId)
            binding.tvTitle.text = likedFilms[numPage - 1].title
        }
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
                when (Netflix.hasRegistered){
                    true -> findNavController().navigate(R.id.action_favoriteFragment_to_showInfoFragment)
                    else -> findNavController().navigate(R.id.action_favoriteFragment_to_profileFragment)
                }
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}