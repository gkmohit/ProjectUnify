package com.projectunify.www.View;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUpActivity extends AppCompatActivity {


    public static String LOG_TAG = SignUpActivity.class.getSimpleName();

    EditText mEmailText;

    EditText mPasswordText;

    Button mSignUpButton;

    private FirebaseAuth mAuth;

    private FirebaseAuth.AuthStateListener mAuthListener;

    ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mAuth = FirebaseAuth.getInstance();

        mEmailText = (EditText) findViewById(R.id.signupEmailText);
        mPasswordText = (EditText) findViewById(R.id.signupPasswordText);
        mSignUpButton = (Button) findViewById(R.id.signupSignupButton);

        mAuthListener = getAuthStateListener();


        mSignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (validate()) {
                    createProgressDialog();
                    mProgressDialog = ProgressDialog.show(SignUpActivity.this, getString(R.string.progress_bar_creating_account), null);
                    String email = mEmailText.getText().toString();
                    String password = mPasswordText.getText().toString();
                    mAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    Log.d(LOG_TAG, "createUserWithEmail:onComplete:" + task.isSuccessful());
                                    mProgressDialog.dismiss();
                                    // If sign in fails, display a message to the user. If sign in succeeds
                                    // the auth state listener will be notified and logic to handle the
                                    // signed in user can be handled in the listener.
                                    if (!task.isSuccessful()) {
                                        Toast.makeText(SignUpActivity.this, R.string.auth_failed_to_create,
                                                Toast.LENGTH_SHORT).show();
                                    }

                                    // ...
                                }
                            });
                }
            }
        });
    }

    private void createProgressDialog() {
        mProgressDialog = new ProgressDialog(SignUpActivity.this,
                R.style.AppTheme);
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setMessage(getString(R.string.progress_bar_creating_account));
        mProgressDialog.getWindow().setGravity(Gravity.CENTER_HORIZONTAL|Gravity.CENTER_VERTICAL);
    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    @NonNull
    private FirebaseAuth.AuthStateListener getAuthStateListener() {
        return new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d(LOG_TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                    Intent homePage = new Intent(SignUpActivity.this, HomePageActivity.class);
                    startActivity(homePage);
                    finish();

                } else {
                    // User is signed out
                    Log.d(LOG_TAG, "onAuthStateChanged:signed_out");
                }
            }
        };
    }

    public boolean validate() {
        boolean valid = true;

        String email = mEmailText.getText().toString();
        String password = mPasswordText.getText().toString();
        String emailError = getResources().getString(R.string.error_validator_email);
        String passwordError = getResources().getString(R.string.error_validator_password);

        //TODO
        //Compare email domains with university domains.
        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            mEmailText.setError(emailError);
            valid = false;
        } else {
            mEmailText.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            mPasswordText.setError(passwordError);
            valid = false;
        } else {
            mPasswordText.setError(null);
        }

        return valid;
    }


    public void signupFailedAlertDialog(String message) {
        validationErrorAlertDialog(message, SignUpActivity.this);
    }

    /**
     * Creates an alert dialog with the passed title and message.
     *
     * @param title   Title for the Alert Dialog
     * @param message Message on the Alert Dialog
     * @return
     */
    public static android.app.AlertDialog.Builder createAlertDialog(String title, String message, Context context) {
        //Creating an alert window.
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage(message);
        return builder;
    }

    /**
     * Created dialog if no permission is available.
     */
    public void validationErrorAlertDialog(String message, Context context) {

        android.app.AlertDialog.Builder builder = createAlertDialog(getResources().getString(R.string.dialog_error_title), message, context);

        builder.setPositiveButton(getResources().getString(R.string.dialog_okay), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }

        });

        builder.setNegativeButton(getResources().getString(R.string.dialog_close), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.setCancelable(false);
        android.app.AlertDialog dialog = builder.create();
        dialog.show();
    }


}
