package com.bhoomiputra.Util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by NandKishor on 7/21/2015.
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    public static final String data_base_name="lockdb.db";
    public static final String create_table_user="create table user (USERNAME text, MOBILE text, PASSWORD text, STATE text, DISTRICT text, TEHSIL text, IMAGE bitmap)";
    public static final String create_table_tool="create table tool (USER text)";


    private String userType;
    public DatabaseHandler(Context context,String userType){super(context,data_base_name, null, 1);this.userType=userType;}


    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(create_table_user);
            if(userType.equals("SELLER")){ db.execSQL(create_table_tool);}
            Log.e("Message", "############## database created");
        } catch (Exception e) {	Log.e("Exception","############## table not created "+e);}

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


   /* public void lock(lockHelper helperObj){

        try {
            SQLiteDatabase db=this.getWritableDatabase();
            ContentValues cv=new ContentValues();
            cv.put("APPNAME", helperObj.appName);
            cv.put("PACKAGE", helperObj.appPackage);
            cv.put("PASSWORD", helperObj.appPassword);

            db.insert("lockdata", null, cv);

            Log.e("Message", "############## new Project inserted");
            //  db.close();
        } catch (Exception e) {
            Log.e("Message","##############:"+e);
        }
    }

    public String getAppPassword(String pac){
        String pass=null;
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor datacursor=db.rawQuery("select * from lockdata where PACKAGE='" + pac + "'", null);
        datacursor.moveToFirst();
        if(datacursor.moveToFirst())
        {
            pass=datacursor.getString(2);
        }
        return pass;
    }


    public void registerUser(String user){

        try {
            SQLiteDatabase db=this.getWritableDatabase();
            ContentValues cv=new ContentValues();
            cv.put("USER",user);
            db.insert("user", null, cv);
            Log.e("Message", "############## new user created");
        } catch (Exception e) {
            Log.e("Message","##############:"+e);
        }
    }

    public String getUser(){
        String user=null;
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor datacursor=db.rawQuery("select * from user", null);
        datacursor.moveToFirst();
        if(datacursor.moveToFirst()){
             user=datacursor.getString(0);
        }

        return user;
    }

    public void updateUser(String newUser,String oldUser){
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL("UPDATE user SET USER ='" + newUser + "' WHERE USER='" + oldUser + "'");
        Log.e("", "###################Updated successfully");
    }*/





  /*  public ArrayList<projectDataBase_HelperClass> verifyProject(String project,String owner){
        ArrayList<projectDataBase_HelperClass>details=new ArrayList<projectDataBase_HelperClass>();
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor datacursor=db.rawQuery("select * from projectdata where owner='"+owner+"'", null);
        datacursor.moveToFirst();
        if(datacursor.moveToFirst()){
            do{
                String projectname=datacursor.getString(0);
                String pojectOwner=datacursor.getString(1);
                String start=datacursor.getString(2);
                String end=datacursor.getString(3);
                todoDataGetter newTodo=new todoDataGetter();
                projectDataBase_HelperClass tempObj=new projectDataBase_HelperClass();
                tempObj.projectName=projectname;
                tempObj.owner=pojectOwner;
                tempObj.startDate=start;
                tempObj.endDate=end;

                details.add(tempObj);
            }while(datacursor.moveToNext());
        }
        return details;
    }
*/




/*
    public ArrayList<lockHelper> getApps(){
        ArrayList<lockHelper>details=new ArrayList<lockHelper>();
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor datacursor=db.rawQuery("select * from lockdata", null);
        datacursor.moveToFirst();
        if(datacursor.moveToFirst()){
            do{
                String appName=datacursor.getString(0);
                String appPackage=datacursor.getString(1);
                String password=datacursor.getString(2);
               *//* Bitmap APPbmimage = BitmapFactory.decodeByteArray(APPbArray, 0,
                        APPbArray.length);
                Bitmap lockbmimage = BitmapFactory.decodeByteArray(lockbArray, 0,
                        lockbArray.length);*//*

                lockHelper tempObj=new lockHelper();
                tempObj.appName=appName;
                tempObj.appPackage=appPackage;
                tempObj.appPassword=password;

                details.add(tempObj);
            }while(datacursor.moveToNext());
        }
        return details;
    }




    public void setProgress(String progress,String project,String owner,String start,String end){
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL("UPDATE projectdata SET percentage ='" + progress + "' WHERE owner='" + owner + "' and start='" + start + "' and end ='" + end + "'");
        Log.e("","###################Setting progress");

    }





    public void insertMembers(String project,String owner,ArrayList<String>members){
        try {
            SQLiteDatabase db=this.getWritableDatabase();
            ContentValues cv=new ContentValues();
            for(int i=0;i<members.size();i++) {
                cv.put("projectname", project);
                cv.put("owner", owner);
                cv.put("member", members.get(i));
                db.insert("project_member", null, cv);
            }
            Log.e("Message", "############## member inserted");
            //  db.close();
        } catch (Exception e) {
            Log.e("Message","##############:"+e);
        }
    }






    public void addOneMember(String project,String owner,String member){
        try {
            SQLiteDatabase db=this.getWritableDatabase();
            ContentValues cv=new ContentValues();

            cv.put("projectname", project);
            cv.put("owner", owner);
            cv.put("member",member);
            db.insert("project_member", null, cv);
            Log.e("Message", "############## member inserted");
            //  db.close();
        } catch (Exception e) {
            Log.e("Message","##############:"+e);
        }
    }





    public void unlockApp(String Package){
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL("DELETE FROM lockdata WHERE PACKAGE='" + Package+ "'");
    }






    public ArrayList<String> getMembers(String owner,String projectName){
        ArrayList<String>members=new ArrayList<String>();
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor datacursor=db.rawQuery("select * from project_member where owner='" + owner + "' and projectName='" + projectName + "'", null);
        if(datacursor.moveToFirst()){
            do{
                String member=datacursor.getString(2);
                members.add(member);
            }while(datacursor.moveToNext());
        }
        datacursor.moveToFirst();
        return members;
    }


    public  void deleteProject(String projectName,String owner,String Start,String end){
        SQLiteDatabase db=this.getWritableDatabase();
        Log.e("","#############Projectname:"+projectName);
        Log.e("","#############owner:"+owner);
        Log.e("","#############start date:"+Start);
        Log.e("","#############end date:"+end);

        db.execSQL("DELETE FROM projectdata WHERE projectname='" + projectName+ "' and owner='" + owner + "' and start='"+Start+"' and end ='"+end+"'");
        Log.e("","#############data deleted from database");
    }

    public boolean ApplockedORnot(String pac){
        boolean flag=false;
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor datacursor=db.rawQuery("select * from lockdata where PACKAGE='" + pac + "'", null);

        int x = datacursor.getCount(); //this will return number of records in current cursor
        if ( x == 0 ) {
          flag=true;
        } else {
            flag=false;
        }
        return flag;}*/

}
