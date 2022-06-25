package com.example.chatting.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.chatting.R;
import com.example.chatting.databinding.ActivityMainBinding;
import com.example.chatting.support.DataLocalManager;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private final FragmentManager fragmentManager = getSupportFragmentManager();
    private final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        CheckLogin();
        setColor1(true);
        fragmentTransaction.add(R.id.viewMain,new Messenger()).commit();

        binding.messenger.setOnClickListener(view -> setItem(1));
        binding.news.setOnClickListener(view -> setItem(2));
        binding.account.setOnClickListener(view -> setItem(3));


    }

    public void setItem(int possition) {
        switch (possition) {
            case 1:
                setColor1(true);
                setColor2(false);
                setColor3(false);
                openFragment(new Messenger());
                break;
            case 2:
                setColor1(false);
                setColor2(true);
                setColor3(false);
                openFragment(new News());
                break;
            case 3:
                setColor1(false);
                setColor2(false);
                setColor3(true);
                openFragment(new Account());
                break;
        }
    }

    public void setColor1(boolean check) {
        if (check) {
            binding.messengericon.setColorFilter(getResources().getColor(R.color.white));
            binding.messengerName.setTextColor(getResources().getColor(R.color.white));
        } else {
            binding.messengericon.setColorFilter(getResources().getColor(R.color.grey));
            binding.messengerName.setTextColor(getResources().getColor(R.color.grey));
        }
    }

    public void setColor2(boolean check) {
        if (check) {
            binding.newsicon.setColorFilter(getResources().getColor(R.color.white));
            binding.newstext.setTextColor(getResources().getColor(R.color.white));
        } else {
            binding.newsicon.setColorFilter(getResources().getColor(R.color.grey));
            binding.newstext.setTextColor(getResources().getColor(R.color.grey));
        }
    }

    public void setColor3(boolean check) {
        if (check) {
            binding.accountIcon.setColorFilter(getResources().getColor(R.color.white));
            binding.accountText.setTextColor(getResources().getColor(R.color.white));
        } else {
            binding.accountIcon.setColorFilter(getResources().getColor(R.color.grey));
            binding.accountText.setTextColor(getResources().getColor(R.color.grey));
        }
    }
    private void openFragment(final Fragment fragment)   {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.viewMain, fragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }
    private void CheckLogin(){
        if (!DataLocalManager.getCheckLogin()){
            binding.accountIcon.setImageResource(R.drawable.ic_baseline_account_circle_24);
        } else {
            binding.accountIcon.setImageResource(R.drawable.abc);
        }
    }

}