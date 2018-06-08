package com.example.user.a5th;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ChangePassword extends AppCompatActivity {

    private TextView txtCurPassword;
    private TextView txtNewPassword;
    private TextView txtWelcome;
    private Button btnChangePass;
    private RelativeLayout activity_dashboard;
    private String user_id;

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        txtCurPassword=(TextView)findViewById(R.id.currentPassword);
        txtNewPassword=(EditText)findViewById(R.id.newPassword);
        btnChangePass=(Button)findViewById(R.id.dashboard_btn_change_pass);

        btnChangePass.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                changePassword(txtNewPassword.getText().toString());
            }
        });

        auth=FirebaseAuth.getInstance();
    }

    private void changePassword(String newPassword) {
        FirebaseUser user=auth.getCurrentUser();
        user.updatePassword(newPassword).addOnCompleteListener(this, new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful())
                {
                    new AlertDialog.Builder(ChangePassword.this).setTitle("Password Changed").show();
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    ChangePassword.this.startActivity(intent);
                }
            }
        });
    }
}
