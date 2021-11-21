package com.example.bookbuy;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;

public class LoginDialogFragment extends DialogFragment {


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        TextView login_name=(TextView) getActivity().findViewById(R.id.creditcard_username) ;
        TextView login_email=(TextView) getActivity().findViewById(R.id.login_email) ;
        ImageView login_user=(ImageView) getActivity().findViewById(R.id.login_user);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());


        // Get the layout inflater
        LayoutInflater inflater = requireActivity().getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(inflater.inflate(R.layout.dialog_login, null))
                .setTitle("BookBuy")

                // Add action buttons
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {


                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                       LoginDialogFragment.this.getDialog().cancel();

                    }
                })

                .setNeutralButton(R.string.clear, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {


                    }
                });






        AlertDialog dialog = builder.create();
        dialog.show();

        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener((v -> {
            EditText name=(EditText) getDialog().findViewById(R.id.creditcard_username);
            EditText password=(EditText) getDialog().findViewById(R.id.bank_password);


            if (name.getText().toString().equals("C108118201") && password.getText().toString().equals("123")){
                login_name.setText("C108118201");
                login_email.setText("C108118201@nkust.edu.tw");
                login_user.setImageResource(R.drawable.user_girl);
                Toast.makeText(getActivity(), "Login", Toast.LENGTH_LONG).show();
                dismiss();
            }
            else{
                Toast.makeText(getActivity(), "Failed.Please try again.", Toast.LENGTH_LONG).show();
            }

        }));
        dialog.getButton(AlertDialog.BUTTON_NEGATIVE).setOnClickListener((v -> {
            dismiss();
        }));


            dialog.getButton(AlertDialog.BUTTON_NEUTRAL).setOnClickListener((v ->{
                EditText name=(EditText) getDialog().findViewById(R.id.creditcard_username);
                EditText password=(EditText) getDialog().findViewById(R.id.bank_password);
                name.setText("");
                password.setText("");


            }));
            return dialog;
}

}
