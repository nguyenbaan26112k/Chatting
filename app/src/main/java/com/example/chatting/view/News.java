package com.example.chatting.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.chatting.R;
import com.example.chatting.databinding.FramentNewsBinding;

public class News extends Fragment {
    FramentNewsBinding binding;

    public News(){
    }
    public static News newInstance() {

        Bundle args = new Bundle();

        News fragment = new News();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.frament_news,container,false);
        return binding.getRoot();
    }
}
