package com.tboys.expressdelivery.entity;

import android.graphics.Bitmap;

/**
 * Created by Dell on 2016/2/24.
 */
public class Delivery {

    private String delivery_number;
    private String delivery_company;
    private Bitmap bitmap_company;
    private String time;

    public Delivery() {
    }

    public Delivery(String delivery_number, String delivery_company, Bitmap bitmap_company, String time) {
        this.delivery_number = delivery_number;
        this.delivery_company = delivery_company;
        this.bitmap_company = bitmap_company;
        this.time = time;
    }

    public String getDelivery_number() {
        return delivery_number;
    }

    public void setDelivery_number(String delivery_number) {
        this.delivery_number = delivery_number;
    }

    public String getDelivery_company() {
        return delivery_company;
    }

    public void setDelivery_company(String delivery_company) {
        this.delivery_company = delivery_company;
    }

    public Bitmap getBitmap_company() {
        return bitmap_company;
    }

    public void setBitmap_company(Bitmap bitmap_company) {
        this.bitmap_company = bitmap_company;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "delivery_number='" + delivery_number + '\'' +
                ", delivery_company='" + delivery_company + '\'' +
                ", bitmap_company=" + bitmap_company +
                ", time='" + time + '\'' +
                '}';
    }
}
