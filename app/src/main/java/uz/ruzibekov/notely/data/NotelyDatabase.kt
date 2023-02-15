package uz.ruzibekov.notely.data

import androidx.room.Database
import androidx.room.RoomDatabase
import uz.ruzibekov.notely.data.room.NoteDao
import uz.ruzibekov.notely.domain.model.NoteData

@Database(entities = [NoteData::class], version = 1)
abstract class NotelyDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}