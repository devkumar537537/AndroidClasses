package com.example.typesofadapters.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.typesofadapters.R;
import com.example.typesofadapters.models.ReccylerModel;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class ReccylerAdapter  extends RecyclerView.Adapter<ReccylerAdapter.MyViewHolder> {
    ArrayList<ReccylerModel> imagelist;
    Context context;

    public ReccylerAdapter(ArrayList<ReccylerModel> imagelist, Context context) {
        this.imagelist = imagelist;
        this.context = context;
    }

    @NonNull
    @Override
    public ReccylerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerformat,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReccylerAdapter.MyViewHolder holder, int position) {
ReccylerModel reccylerModel = imagelist.get(position);
holder.profileimage.setImageResource(reccylerModel.getImagure());
holder.showbtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String name_Text = holder.infoedit.getText().toString();

        Snackbar.make(v,"name => "+name_Text,Snackbar.LENGTH_LONG)
             .setAction("UNDO", new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     holder.infoedit.setText("UNDO");
                     Toast.makeText(context, "yes it is toast", Toast.LENGTH_SHORT).show();
                 }
             }).show();
    }
});



    }

    @Override
    public int getItemCount() {
        return imagelist.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView profileimage;
        CardView showbtn;
        EditText infoedit;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            profileimage = itemView.findViewById(R.id.recyclrimage);
            showbtn = itemView.findViewById(R.id.takenamebtn);
            infoedit = itemView.findViewById(R.id.namedittext);
        }
    }
}

