package com.example.pc43.myfacebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.login.LoginManager;
import com.facebook.login.widget.LoginButton;
import com.squareup.picasso.Picasso;

import java.net.URL;

public class DashboardActivity extends AppCompatActivity {
    private LinearLayout mInfoLayout;
    private TextView mName;
    private TextView mEmail;
    private TextView mDob;
    private ImageView mProfileImage;
    private Button mLogOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        mName=(TextView)findViewById(R.id.textView1);
        mEmail=(TextView)findViewById(R.id.textView2);
        mDob=(TextView)findViewById(R.id.textView4);
        mLogOut=(Button)findViewById(R.id.logOut);
        mProfileImage=(ImageView)findViewById(R.id.profileImage);
        mInfoLayout=(LinearLayout)findViewById(R.id.infoLayout);
        String id=getIntent().getExtras().getString("id");
        String name=getIntent().getExtras().getString("name");
        String email=getIntent().getExtras().getString("email");
        String dob=getIntent().getExtras().getString("dob");
        String image=getIntent().getExtras().getString("profile_url");
        mName.setText(name);
        mEmail.setText(email);
        mDob.setText(dob);
        Picasso.with(this).load(image).into(mProfileImage);
        mLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginManager.getInstance().logOut();
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
}
