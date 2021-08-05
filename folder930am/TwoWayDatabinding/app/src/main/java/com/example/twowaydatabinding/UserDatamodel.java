package com.example.twowaydatabinding;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class UserDatamodel extends BaseObservable {
    private String email;
    private String password;
    private Context context;

    public UserDatamodel(Context context) {
        this.context = context;
    }

    @Bindable
    public String getEmail() {
        if (email == null) {
            return "";
        }
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        notifyPropertyChanged(BR.email);
    }

    @Bindable({"email"})
    public String getEmailError() {
        if (getEmail().isEmpty()) {
            return "EMAIL IS EMPTY";
        }
        return "";
    }

    @Bindable
    public String getPassword() {
        if (password == null) {
            return "";
        }
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(BR.password);
    }

    @Bindable({"password"})
    public String getPasswordError() {
        if (getPassword().isEmpty()) {
            return "PASSWORD IS EMPTY";
        } else {
            return "";
        }
    }

    public void loginmethod(View view)
    {
        String email = getEmail();
        String password = getPassword();

        Toast.makeText(context, "email is => "+email+ "password =>"+password, Toast.LENGTH_SHORT).show();
    }
}
