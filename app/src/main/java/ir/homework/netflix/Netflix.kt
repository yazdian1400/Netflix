package ir.homework.netflix

object Netflix {
    var filmList = mutableListOf<Film>()

    fun setData(){
        filmList.add(Film("اختاپوس", R.drawable.okhtapos, false))
    }
}