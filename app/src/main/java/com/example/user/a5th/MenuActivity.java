package com.example.user.a5th;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.buttonTimetable:
                Toast toast=Toast.makeText(this, "good", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 90, 250);
                toast.show();
                //  if(mAuth.getUid()=="member") {
                //      startActivity(new Intent(this, MemberTimetable.class));
                //  }
                //   else {
                Intent intent1=new Intent(MenuActivity.this, TrainerTimetable.class);
                startActivity(intent1);
                //  }
                break;
            case R.id.buttonChangePassword:
                Intent intent2=new Intent(MenuActivity.this, ChangePassword.class);
                startActivity(intent2);
                break;
            case R.id.buttonBoard:
                break;
            case R.id.buttonConversation:
                break;
            default:
                Toast toast1=Toast.makeText(this, "bad", Toast.LENGTH_SHORT);
                toast1.setGravity(Gravity.CENTER, 90, 250);
                toast1.show();
        }
    }
}
