package com.example.autocompletetextview_sqlite;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {

	protected static final String DATABASE_NAME = "city";

	private static final int DATABASE_VERSION = 4;

	public String tableName = "city_info";
	public String fieldObjectId = "id";
	public String fieldObjectName = "name";

	public DatabaseHandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String sql = "CREATE TABLE " + tableName + "(" + fieldObjectId
				+ " INTEGER PRIMARY KEY AUTOINCREMENT, " + fieldObjectName
				+ " TEXT )";

		db.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		String sql = "DROP TABLE IF EXISTS " + tableName;
		db.execSQL(sql);
		onCreate(db);
	}

	public boolean create(City city) {
		boolean createSuccessful = false;
		if (!checkIfExists(city.cityName)) {
			SQLiteDatabase db = this.getWritableDatabase();

			ContentValues values = new ContentValues();
			values.put(fieldObjectName, city.cityName);
			createSuccessful = db.insert(tableName, null, values) > 0;

			db.close();
		}
		return createSuccessful;
	}

	private boolean checkIfExists(String cityName) {
		boolean recordExists = false;
		
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery("SELECT "+fieldObjectId+" FROM "+tableName+" WHERE "+fieldObjectName+" = '"+ cityName+"'", null);
		if(cursor != null){
			if(cursor.getCount()>0){
				recordExists = true;
			}
		}
		
		cursor.close();
		db.close();
		
		return recordExists;
	}
	
	public List<City> read(String searchName){
		List<City> recoresList = new ArrayList<City>();
		String sql = "";
		sql += "SELECT * FROM " + tableName;
		sql += " WHERE " + fieldObjectName + " LIKE '%" + searchName + "%'";
		sql += " ORDER BY " + fieldObjectId + " DESC";
		sql += " LIMIT 0,5";
		
		SQLiteDatabase db = this.getWritableDatabase();
		
		Cursor cursor = db.rawQuery(sql, null);
		
		if(cursor.moveToFirst()){
			do{
				String objectName = cursor.getString(cursor.getColumnIndex(fieldObjectName));
				City city = new City(objectName);
				recoresList.add(city);
			}while(cursor.moveToNext());
		}
		
		cursor.close();
		db.close();
		
		return recoresList;
	}
}
