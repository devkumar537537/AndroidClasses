package com.example.realmdatabae;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;
import io.realm.exceptions.RealmPrimaryKeyConstraintException;

public class MainActivity extends AppCompatActivity {
EditText nameedit,ageedit,skilledit;
Button insertbtn,showdata,updatedata,deledata;
Realm mrealm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindView();
Realm.init(getApplicationContext());
mrealm = Realm.getDefaultInstance();
        insertbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addStudent();
            }
        });
        showdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readStudentRecodre();
            }
        });

        updatedata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updatedatafunction();
            }
        });

        deledata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deletfunction();
            }
        });
    }

    private void deletfunction() {
        mrealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Students students = realm.where(Students.class).equalTo(Students.PROPERTY_NAME,nameedit.getText().toString()).findFirst();
                if(students !=null)
                {
                    students.deleteFromRealm();
                    Toast.makeText(MainActivity.this, "Student Deleted", Toast.LENGTH_SHORT).show();
                }else
                {
                    Toast.makeText(MainActivity.this, "Student not exist", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void updatedatafunction() {

        mrealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {

                if(!nameedit.getText().toString().trim().isEmpty())
                {
                    Students students = realm.where(Students.class).equalTo(Students.PROPERTY_NAME,nameedit.getText().toString()).findFirst();
               if(students == null)
               {
                   students = realm.createObject(Students.class,nameedit.getText().toString().trim());

               }
               if(!ageedit.getText().toString().trim().isEmpty())
                   students.age  = Integer.parseInt(ageedit.getText().toString().trim());
               String languageknow = skilledit.getText().toString().trim();
               Skill skill = realm.where(Skill.class).equalTo(Skill.PROPERTY_SKILL,languageknow).findFirst();
               if(skill == null)
               {
                   skill = realm.createObject(Skill.class,languageknow);
                   realm.copyToRealm(skill);
               }

               if(!students.skills.contains(skill))
               {
                   students.skills.add(skill);
               }


                    Toast.makeText(MainActivity.this, "Student Updated Successfully", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    private void readStudentRecodre() {
        mrealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                RealmResults<Students> results = realm.where(Students.class).findAll();

                StringBuffer  stringBuffer = new StringBuffer();
                for(Students students : results)
                {
                    String language = "";
                    RealmList<Skill> skilllist =  students.skills;
                    for(Skill skill : skilllist)
                    {
                        language = skill.skillName;
                    }

                    stringBuffer.append("name: "+students.name+"\n");
                    stringBuffer.append("age: "+students.age+"\n");
                    stringBuffer.append("skilss: "+language+"\n\n");
                }
                  showMessage("Data",stringBuffer.toString());
            }
        });
    }

    private void addStudent() {

        Realm realm = null;
        try {
            realm = Realm.getDefaultInstance();
            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    try {

                        if(!nameedit.getText().toString().trim().isEmpty())
                        {
                            Students students = new Students();
                            students.name = nameedit.getText().toString().trim();


                            if(!ageedit.getText().toString().trim().isEmpty())
                            students.age = Integer.parseInt(ageedit.getText().toString().trim());

                            String skillsknow = skilledit.getText().toString().trim();

                            if(!skillsknow.isEmpty())
                            {
                                Skill skill = realm.where(Skill.class).equalTo(Skill.PROPERTY_SKILL,skillsknow).findFirst();
                                if(skill == null)
                                {
                                    skill = realm.createObject(Skill.class,skillsknow);
                                    realm.copyToRealm(skill);
                                }

                                students.skills = new RealmList<>();
                                students.skills.add(skill);
                            }
                            realm.copyToRealm(students);
                            Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                        }



                    }catch (RealmPrimaryKeyConstraintException e)
                    {
                        Toast.makeText(MainActivity.this, "Primaary key exist", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }finally {
            if(realm != null)
            {
                realm.close();
            }
        }

    }

    private void bindView() {

        nameedit = findViewById(R.id.student_name);
        ageedit = findViewById(R.id.student_age);
        skilledit = findViewById(R.id.student_skill);
        insertbtn = findViewById(R.id.insertdata);
        showdata = findViewById(R.id.showdata);
        updatedata = findViewById(R.id.udatedata);
        deledata = findViewById(R.id.deletedata);


    }
    private void showMessage(String title,String Message)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}