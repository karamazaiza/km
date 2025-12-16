package com.example.km;

public class AppItem {
    private final int rank;
    private final int iconResId;
    private final String title;
    private final String description;
    private final float rating;
    private final int sizeMB;
    private final boolean hasEvent;
    private final String eventDetails;

    public AppItem(int rank, int iconResId, String title, String description,
                   float rating, int sizeMB, boolean hasEvent, String eventDetails) {
        this.rank = rank;
        this.iconResId = iconResId;
        this.title = title;
        this.description = description;
        this.rating = rating;
        this.sizeMB = sizeMB;
        this.hasEvent = hasEvent;
        this.eventDetails = eventDetails;
    }

    public int getRank() { return rank; }
    public int getIconResId() { return iconResId; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public float getRating() { return rating; }
    public int getSizeMB() { return sizeMB; }
    public boolean hasEvent() { return hasEvent; }
    public String getEventDetails() { return eventDetails; }
}