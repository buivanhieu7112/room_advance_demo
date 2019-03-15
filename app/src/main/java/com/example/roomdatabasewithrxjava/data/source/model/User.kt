package com.example.roomdatabasewithrxjava.data.source.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import java.util.*

@Entity(
    tableName = "User", indices = [Index("id", unique = true)]
    )
data class User(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id") var id: Int,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "email") var email: String,
    @ColumnInfo(name = "age") var age: String,
    @ColumnInfo(name = "date") var date: Date
)
