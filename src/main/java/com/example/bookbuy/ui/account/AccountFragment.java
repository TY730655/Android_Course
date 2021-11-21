package com.example.bookbuy.ui.account;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.bookbuy.R;
import com.example.bookbuy.databinding.FragmentAccountBinding;

public class AccountFragment extends Fragment {

    private AccountViewModel accountViewModel;
    private FragmentAccountBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        accountViewModel =
                new ViewModelProvider(this).get(AccountViewModel.class);

       binding = FragmentAccountBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

   /*      final TextView textView = binding.textGallery;
        accountViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {


            }
        });*/

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }



}
