package com.example.bookbuy.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.bookbuy.BankDialogFragment;
import com.example.bookbuy.CreditCardDialogFragment;
import com.example.bookbuy.R;
import com.example.bookbuy.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);


        /*       View root = binding.getRoot();

        final TextView textView = binding.textView;
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;*/

        View v = inflater.inflate(R.layout.fragment_home, container, false);

        Spinner spinner = (Spinner) v.findViewById(R.id.spinner_item);
        spinner.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.item_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);

        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void onClick_Buy(){




    }


    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {



        //ImageView for Planet images
        ImageView img= (ImageView) getActivity().findViewById(R.id.imageView_item);
        TextView cost =(TextView) getActivity().findViewById(R.id.cost);
        switch (pos){
            case 0:
                img.setImageResource(R.drawable.ticket);
                cost.setText("480");
                break;
            case 1:
                img.setImageResource(R.drawable.book);
                cost.setText("390");
                break;

            case 2:
                img.setImageResource(R.drawable.stationery);
                cost.setText("250");
                break;


        }


    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }
}