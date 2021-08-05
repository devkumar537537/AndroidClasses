package com.example.mvvmexamples.viemodels;

import com.example.mvvmexamples.BR;
import com.example.mvvmexamples.MainActivity;
import com.example.mvvmexamples.SecondActivity;
import com.example.mvvmexamples.repositeries.Repositeries;


import android.content.Intent;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.lifecycle.ViewModel;


public class LoginViewModels extends BaseObservable {
    private User user;

     Repositeries repositeries = new Repositeries();

    private String successMessage = "Login was Proceed";
    private String errorMessage = "Email or Password not valid";

    @Bindable
    private String toastMessage = null;


    public String getToastMessage() {
        return toastMessage;
    }


    private void setToastMessage(String toastMessage) {

        this.toastMessage = toastMessage;
        notifyPropertyChanged(BR.toastMessage);
    }


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

    public LoginViewModels() {
        user = new User("","");
    }

    public void onLoginClicked() {
//        if (isInputDataValid())
//        {
            boolean response = repositeries.addemail(getUserEmail().toString(),getUserPassword().toString());
            if(response)
            {

                setToastMessage("Succesd");
            }else
            {
                setToastMessage("Failed");
            }
//
//        } else
//        {
//            setToastMessage(errorMessage);
//        }

    }

//    public boolean isInputDataValid() {
//        return !TextUtils.isEmpty(getUserEmail()) && Patterns.EMAIL_ADDRESS.matcher(getUserEmail()).matches() && getUserPassword().length() > 5;
//    }

    public void movetoNextActivity(View view)
    {
        Intent intent = new Intent(view.getContext(), SecondActivity.class);
        view.getContext().startActivity(intent);

    }
}
