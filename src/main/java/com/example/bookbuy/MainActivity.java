package com.example.bookbuy;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import androidx.fragment.app.DialogFragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bookbuy.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity{

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        //FAB_Login
        setSupportActionBar(binding.appBarMain.toolbar);
        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LogIn();


            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_account, R.id.nav_deposit,R.id.nav_notice)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.action_record:
                recordDialog();

                return true;

            case R.id.action_search:
                Uri webpage = Uri.parse("https://english.nkust.edu.tw/p/406-1098-48470,r11.php?Lang=zh-tw");
                Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
                startActivity(webIntent);

                return true;

            case R.id.action_position:

                // Map point based on address
                Uri location = Uri.parse("geo:0,0?q=國立高雄科技大學（第一校區）圖文部");

                Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
                startActivity(mapIntent);

                return true;

            case R.id.action_mail:
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                // The intent does not have a URI, so declare the "text/plain" MIME type
                emailIntent.setType("text/plain");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {"bookstor@nkust.edu.tw"}); // recipients
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "詢問書籍價錢");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "請問微積分課本的價格為多少呢");
                emailIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse("content://path/to/email/attachment"));
                // You can also attach multiple items by passing an ArrayList of Uris
                startActivity(emailIntent);
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

    public void LogIn() {
        DialogFragment newFragment = new LoginDialogFragment();
        newFragment.show(getSupportFragmentManager(), "log_in");


    }



    public void onClick(View view){

        //nav_header_main
        TextView login_name=(TextView) this.findViewById(R.id.creditcard_username) ;
        TextView login_email=(TextView) this.findViewById(R.id.login_email) ;
        ImageView login_user=(ImageView) this.findViewById(R.id.login_user);

        //fragment_account
        ImageView account_user=(ImageView) this.findViewById(R.id.account_user);
        TextView account_name=(TextView) this.findViewById(R.id.account_name) ;
        TextView account_email=(TextView) this.findViewById(R.id.account_email) ;
        TextView account_password=(TextView) this.findViewById(R.id.account_password) ;

        switch (view.getId()){
            case R.id.button_singout:
                Toast.makeText(this,"Sign Out ~",Toast.LENGTH_LONG).show();
                login_name.setText("Android Studio");
                login_email.setText("android.studio@android.com");
                login_user.setImageResource(R.mipmap.ic_launcher_round);
                account_user.setImageResource(R.drawable.user);
                account_name.setText("");
                account_email.setText("");
                account_password.setText("");
                DrawerLayout drawer = binding.drawerLayout;

                break;
            case R.id.button_modify:
                Toast.makeText(this,"Successfully modified.",Toast.LENGTH_LONG).show();
                break;

            case R.id.button_buy:

                if (login_name.getText().toString().equals("C108118201") && login_email.getText().toString().equals("C108118201@nkust.edu.tw")){

                    Toast.makeText(this, "BUY.", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(this, "Please Login", Toast.LENGTH_LONG).show();
                }



        }




    }
    public void recordDialog(){


        DialogFragment newFragment = new RecordDialogFragment();
        newFragment.show(getSupportFragmentManager(), "record");
    }



}