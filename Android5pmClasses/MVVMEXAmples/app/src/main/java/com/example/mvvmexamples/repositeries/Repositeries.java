package com.example.mvvmexamples.repositeries;

import com.example.mvvmexamples.databasefiles.Databasefiles;

public class Repositeries {
Databasefiles databasefiles = new Databasefiles();
 public boolean addemail(String email,String password)
    {
       boolean result = databasefiles.insertUser(email,password);
     return result;

    }
}
