package uz.ruzibekov.notely.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import uz.ruzibekov.notely.data.NotelyDatabase
import uz.ruzibekov.notely.data.repository.NoteRepository
import uz.ruzibekov.notely.data.room.NoteDao
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NoteRepositoryModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): NotelyDatabase {
        val database = Room.databaseBuilder(
            context,
            NotelyDatabase::class.java,
            "room_database"
        ).build()
        return database
    }

    @Provides
    @Singleton
    fun provideNoteDao(database: NotelyDatabase): NoteDao {
        return database.noteDao()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(noteDao: NoteDao): NoteRepository {
        return NoteRepository(dao = noteDao)
    }
}