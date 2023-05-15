package org.d3if3050.asesmen1.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [TanamEntity::class], version = 1, exportSchema = false)
abstract class TanamDb : RoomDatabase() {

    abstract val dao: TanamDao

    companion object {
        @Volatile
        private var INSTANCE: TanamDb? = null

        fun getInstance(context: Context): TanamDb {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        TanamDb::class.java,
                        "tanam.db"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }

                return instance
            }
        }
    }
}