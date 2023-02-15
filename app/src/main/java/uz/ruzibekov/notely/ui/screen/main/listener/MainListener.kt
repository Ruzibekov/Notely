package uz.ruzibekov.notely.ui.screen.main.listener

interface MainListener : MainSheetListener{

    fun openAddNoteScreen(id: Long = -1)

    fun showMoreDialog()

    fun onSearch(text: String)
}