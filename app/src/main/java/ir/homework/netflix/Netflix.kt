package ir.homework.netflix

object Netflix {
    var filmList = mutableListOf<Film>()
    var comingSoonList = mutableListOf<Film>()

    fun setData(){
        filmList.clear()
        filmList.add(Film("اختاپوس", R.drawable.okhtapos, false))
        filmList.add(Film("بنیامین",R.drawable.benjamin, false))
        filmList.add(Film("جنجال در عروسی",R.drawable.janjal_dar_aroosi, false))
        filmList.add(Film("خاله قورباغه",R.drawable.khale_ghurbaghe, false))
        filmList.add(Film("کلاه قرمزی و سروناز",R.drawable.kolah_ghermezi_va_sarve_naz, false))
        filmList.add(Film("آخرین داستان",R.drawable.last_story, false))
        filmList.add(Film("منطقه پرواز ممنوع",R.drawable.mantaghe_parvaz_mamnoo, false))
        filmList.add(Film("فیلشاه",R.drawable.pilshah, false))
        filmList.add(Film("پیشونی سفید2",R.drawable.pishooni_sefid_2, false))
        filmList.add(Film("رستم و سهراب",R.drawable.rostam_va_sohrab, false))
        filmList.add(Film("سوم شخص",R.drawable.sevvom_shakhs, false))
        filmList.add(Film("شهر موش ها",R.drawable.shahr_mushha, false))

        comingSoonList.clear()
        comingSoonList.add(Film("پیشونی سفید3", R.drawable.pishuni_sefid_3, false))
        comingSoonList.add(Film("خنگول و منگول", R.drawable.khengul_o_mangul, false))
        comingSoonList.add(Film("23 نفر", R.drawable.nafar_23, false))
    }
}