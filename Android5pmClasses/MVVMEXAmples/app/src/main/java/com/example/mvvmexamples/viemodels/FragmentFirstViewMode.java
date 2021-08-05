package com.example.mvvmexamples.viemodels;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.mvvmexamples.BR;

public class FragmentFirstViewMode extends BaseObservable {
    private User user;


    public void setUserEmail(String email) {
        user.setEmail(email);
        notifyPropertyChanged(BR.userEmail);
    }

    @Bindable
    public String getUserEmail() {
        return user.getEmail();
    }

    @Bindable
    public String getUserPassword() {
        return user.getPassword();
    }

    public void setUserPassword(String password) {
        user.setPassword(password);
        notifyPropertyChanged(BR.userPassword);
    }
    public FragmentFirstViewMode() {
        user = new User("","");
    }
public void showvalues(View view)
{
    Toast.makeText(view.getContext(), "This is email"+getUserEmail()+" and password is "+getUserPassword(), Toast.LENGTH_SHORT).show();
}



}
