package com.example.myapplicationrecyclerview;

import android.view.View;

public interface ClickListener<T> {
    void onClick(View view, T data, int position);
}
