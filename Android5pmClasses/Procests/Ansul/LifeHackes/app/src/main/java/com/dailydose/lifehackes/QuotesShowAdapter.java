package com.dailydose.lifehackes;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Vibrator;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class QuotesShowAdapter extends RecyclerView.Adapter<QuotesShowAdapter.MyViewHolder> {
    private Context context;
    private List<QuotsShowItems> quotsShowItems;
    private InterstitialAd mInterstitialAd;

    public QuotesShowAdapter(Context context, List<QuotsShowItems> quotsShowItems) {
        this.context = context;
        this.quotsShowItems = quotsShowItems;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(context);
        view = mInflater.inflate(R.layout.quots_show, parent, false);
        return new QuotesShowAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        holder.quotesText.setText(quotsShowItems.get(position).getQuotes());
        holder.sherText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Vibrator vibe = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
                String quote = holder.quotesText.getText().toString();
                vibe.vibrate(30);
                Intent shareIntent = new Intent();
                shareIntent.setAction(Intent.ACTION_SEND);
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Life Hacks and Status");
                shareIntent.putExtra(Intent.EXTRA_TEXT, quote);
                shareIntent.setType("text/plain");
                context.startActivity(shareIntent);
            }
        });
        holder.copyText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Vibrator vibe = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
                String quote = holder.quotesText.getText().toString();
                vibe.vibrate(30);
                ClipboardManager clipboard = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("Text Copied", quote);
                clipboard.setPrimaryClip(clip);
                Toast toast
                        = Toast.makeText(
                        context,
                        "Text Copied",
                        Toast.LENGTH_SHORT);
                // Getting the View
                View view = toast.getView();
                toast.setView(view);

                // Finding the textview in Toast view
                TextView text
                        = (TextView) view.findViewById(
                        android.R.id.message);
                // Setting the Text Appearance
                if (Build.VERSION.SDK_INT
                        >= Build.VERSION_CODES.M) {
                    text.setTextAppearance(
                            R.style.toastTextStyle);

                }
                toast.setGravity(Gravity.BOTTOM, 0, 30);
                // Showing the Toast Message
                toast.show();

//                Load Ads
                mInterstitialAd = new InterstitialAd(context);
                mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
                mInterstitialAd.setAdListener(new AdListener() {
                                                  @Override
                                                  public void onAdLoaded() {
                                                      super.onAdLoaded();
                                                      mInterstitialAd.show();
                                                  }

                                              }
                );


            }
        });
    }

    @Override
    public int getItemCount() {
        return quotsShowItems.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView quotesText, copyText, sherText;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            quotesText = itemView.findViewById(R.id.quotesShow);
            copyText = itemView.findViewById(R.id.copyText);
            sherText = itemView.findViewById(R.id.shearText);

        }
    }
}
