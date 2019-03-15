package com.example.roomdatabasewithrxjava.data.source.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.roomdatabasewithrxjava.data.source.local.persistence.DateTypeConvert
import java.util.*

@Entity(tableName = "User")
data class User(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id") var id: Int,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "email") var email: String,
    @ColumnInfo(name = "age") var age: String,
    @ColumnInfo(name = "date") var date: Date
)
