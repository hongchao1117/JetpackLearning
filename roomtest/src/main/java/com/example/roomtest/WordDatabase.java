package com.example.roomtest;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Insert;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Word.class},version = 5,exportSchema = false)
public abstract class WordDatabase extends RoomDatabase {
     private static WordDatabase INSTANCE;

     public synchronized static WordDatabase getDatabase(Context context) {
          if (INSTANCE == null) {
               INSTANCE = Room.databaseBuilder(context.getApplicationContext(), WordDatabase.class, "word_database")
                       .addMigrations(MIGRATION_4_5)
                       .build();
          }
          return INSTANCE;
     }

     public abstract WordDao getWordDao();

     static final Migration MIGRATION_2_3 = new Migration(2, 3) {
          @Override
          public void migrate(@NonNull SupportSQLiteDatabase database) {
               database.execSQL("alter table word add column bar_data integer not null default 1");
          }
     };

     static final Migration MIGRATION_3_4 = new Migration(3,4) {
          @Override
          public void migrate(@NonNull SupportSQLiteDatabase database) {
               database.execSQL("create table word_temp(id integer primary key not null,english_word text," +
                       "chinese_meaning text)");
               database.execSQL("insert into word_temp (id,english_word,chinese_meaning)"+
                       "select id,english_word,chinese_meaning from word");
               database.execSQL("drop table word");
               database.execSQL("alter table word_temp rename to word");
          }
     };

     static final Migration MIGRATION_4_5 = new Migration(4, 5) {
          @Override
          public void migrate(@NonNull SupportSQLiteDatabase database) {
               database.execSQL("alter table word add column chinese_invisible integer not null default 1");
          }
     };
}