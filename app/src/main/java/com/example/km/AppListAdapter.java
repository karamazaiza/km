package com.example.km;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import java.util.Locale;

public class AppListAdapter extends RecyclerView.Adapter<AppListAdapter.AppViewHolder> {

    private final List<AppItem> appList;

    public AppListAdapter(List<AppItem> appList) {
        this.appList = appList;
    }

    public static class AppViewHolder extends RecyclerView.ViewHolder {
        public TextView rankTextView;
        public ImageView iconImageView;
        public TextView titleTextView;
        public TextView descriptionTextView;
        public TextView ratingTextView;
        public TextView sizeTextView;
        public TextView eventBadge;

        public AppViewHolder(View itemView) {
            super(itemView);
            rankTextView = itemView.findViewById(R.id.rank_textView);
            iconImageView = itemView.findViewById(R.id.icon_imageView);
            titleTextView = itemView.findViewById(R.id.title_textView);
            descriptionTextView = itemView.findViewById(R.id.description_textView);
            ratingTextView = itemView.findViewById(R.id.rating_textView);
            sizeTextView = itemView.findViewById(R.id.size_textView);
            eventBadge = itemView.findViewById(R.id.event_badge);
        }
    }

    @NonNull
    @Override
    public AppViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_app, parent, false);
        return new AppViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AppViewHolder holder, int position) {
        AppItem currentItem = appList.get(position);

        holder.rankTextView.setText(String.valueOf(currentItem.getRank()));
        holder.iconImageView.setImageResource(currentItem.getIconResId());
        holder.titleTextView.setText(currentItem.getTitle());
        holder.descriptionTextView.setText(currentItem.getDescription());

        String formattedRating = String.format(Locale.US, "%.1f", currentItem.getRating()) + "★";
        holder.ratingTextView.setText(formattedRating);
        holder.sizeTextView.setText("• " + currentItem.getSizeMB() + " MB"); // تم تغيير م.ب إلى MB لتكون أقرب للصورة

        if (currentItem.hasEvent()) {
            holder.eventBadge.setVisibility(View.VISIBLE);
            // لعرض النص: "Ends in 6 days"
            holder.eventBadge.setText(" • Event " + currentItem.getEventDetails());
        } else {
            holder.eventBadge.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return appList.size();
    }
}