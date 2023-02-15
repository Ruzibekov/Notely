package uz.ruzibekov.notely.ui.screen.details.listener

import uz.ruzibekov.notely.domain.model.NoteData

interface DetailsListener {

    fun onClickBack()

    fun showMoreDialog()

    fun addAttachment(note: NoteData)

    fun deleteNote()

    fun shareNote(note: NoteData)

    fun lockNote(note: NoteData)

    fun pinToTop(note: NoteData)
}