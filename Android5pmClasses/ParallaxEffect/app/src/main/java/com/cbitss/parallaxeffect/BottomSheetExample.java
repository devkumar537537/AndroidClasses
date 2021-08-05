package com.cbitss.parallaxeffect;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.snackbar.Snackbar;

public class BottomSheetExample extends AppCompatActivity {
BottomSheetBehavior behavior;
boolean isOpen = false;
CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_sheet_example);

        coordinatorLayout = findViewById(R.id.coordinator_layout);
        final View BoottomSheet = findViewById(R.id.bottom_sheet);

        behavior = BottomSheetBehavior.from(BoottomSheet);

        Button button = findViewById(R.id.button_bottomSheet);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isOpen == false)
                {
                    isOpen = true;
                    behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                }else
                {
                    isOpen = false;
                    Snackbar.make(coordinatorLayout,"Bottom Sheet Closed",Snackbar.LENGTH_SHORT).setAction("Action",null).show();

                    behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);

                }
            }
        });
    }
}