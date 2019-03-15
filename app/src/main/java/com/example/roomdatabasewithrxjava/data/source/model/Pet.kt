package com.example.roomdatabasewithrxjava.data.source.model

import androidx.room.*

@Entity(
    tableName = "Pet",
    foreignKeys = [ForeignKey(entity = User::class, parentColumns = arrayOf("id"), childColumns = arrayOf("user_id"), onDelete = ForeignKey.CASCADE)]
)
data class Pet(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "pet_id") var petId: Int,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "user_id") var userId: Int
)
