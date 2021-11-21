package com.example.bookbuy.ui.deposit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.bookbuy.BankDialogFragment;
import com.example.bookbuy.CreditCardDialogFragment;
import com.example.bookbuy.R;
import com.example.bookbuy.databinding.FragmentDepositBinding;

public class DepositFragment extends Fragment implements AdapterView.OnItemSelectedListener {


    private DepositViewModel depositViewModelViewModel;
    private FragmentDepositBinding binding;






    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        depositViewModelViewModel =
                new ViewModelProvider(this).get(DepositViewModel.class);

        binding = FragmentDepositBinding.inflate(inflater, container, false);
        /*View root = binding.getRoot();
        Spinner spinner = (Spinner) getActivity().findViewById(R.id.spinner_deposit);
        spinner.setOnItemSelectedListener(this);


        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.deposit_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

       /* final TextView textView = binding.textDeposit;
        depositViewModelViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });
        return root;*/

        //Spinner
        View v = inflater.inflate(R.layout.fragment_deposit, container, false);

        Spinner spinner = (Spinner) v.findViewById(R.id.spinner_deposit);
        spinner.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.deposit_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);

        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {




        switch (pos){
            case 0:
                Toast.makeText(getActivity(),"請選擇儲值方式...",Toast.LENGTH_LONG).show();
                break;
            case 1:
                DialogFragment newFragment = new BankDialogFragment();
                newFragment.show(getChildFragmentManager(), "Deposit Method");


                break;
            case 2:
                DialogFragment newFragment_credit = new CreditCardDialogFragment();
                newFragment_credit .show(getChildFragmentManager(), "Deposit Method");
                break;

        }
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }
}