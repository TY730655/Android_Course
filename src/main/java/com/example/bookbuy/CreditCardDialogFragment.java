package com.example.bookbuy;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;

public class CreditCardDialogFragment extends DialogFragment {


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {




        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        // Get the layout inflater
        LayoutInflater inflater = requireActivity().getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(inflater.inflate(R.layout.dialog_creditcard, null))
                .setTitle("Deposit Method--Credit Card")
                // Add action buttons
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {


                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        CreditCardDialogFragment.this.getDialog().cancel();

                    }
                })

                .setNeutralButton(R.string.clear, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {


                    }
                });






        AlertDialog dialog = builder.create();
        dialog.show();

        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener((v -> {
            EditText amount=(EditText) getDialog().findViewById(R.id.creditcard_storeamount);

            String text=amount.getText().toString();

            Toast.makeText(getActivity(), "CreditCard Stored $"+text, Toast.LENGTH_LONG).show();
            dismiss();

        }));
        dialog.getButton(AlertDialog.BUTTON_NEGATIVE).setOnClickListener((v -> {
            dismiss();
        }));


        dialog.getButton(AlertDialog.BUTTON_NEUTRAL).setOnClickListener((v ->{
            EditText username=(EditText) getDialog().findViewById(R.id.creditcard_username);
            EditText password=(EditText) getDialog().findViewById(R.id.creditcard_password);
            EditText storedamount=(EditText) getDialog().findViewById(R.id.creditcard_storeamount);
            username.setText("");
            password.setText("");
            storedamount.setText("");


        }));
        return dialog;
}
}
