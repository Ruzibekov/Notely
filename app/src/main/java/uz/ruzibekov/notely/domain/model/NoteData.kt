package uz.ruzibekov.notely.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_database")
data class NoteData (
    @PrimaryKey(autoGenerate = true)
    var id: Long,
    var title: String,
    var subtitle: String,
) : java.io.Serializable