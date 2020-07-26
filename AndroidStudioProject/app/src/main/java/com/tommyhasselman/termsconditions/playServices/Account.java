package com.tommyhasselman.termsconditions.playServices;

import android.app.Activity;

import androidx.annotation.NonNull;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.tommyhasselman.termsconditions.Controller;

import static com.google.android.gms.drive.Drive.SCOPE_APPFOLDER;

public class Account {

    private Controller cont;

    public Account(Controller c) {
        cont = c;
    }

    public void signInSilently(Activity act) {

        GoogleSignInOptions signInOption =
                new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_GAMES_SIGN_IN)
                        .requestScopes(SCOPE_APPFOLDER)
                        .build();

        GoogleSignInClient signInClient = GoogleSignIn.getClient(act, signInOption);
        signInClient.silentSignIn().addOnCompleteListener(act,
                new OnCompleteListener<GoogleSignInAccount>() {
                    @Override
                    public void onComplete(@NonNull Task<GoogleSignInAccount> task) {
                        if (task.isSuccessful()) {
                            GoogleSignInAccount signedInAccount = task.getResult();
                            cont.setSignedInAccount(signedInAccount);
                        } else {
                            // Player will need to sign-in explicitly using via UI.
                            // See [sign-in best practices](http://developers.google.com/games/services/checklist) for guidance on how and when to implement Interactive Sign-in,
                            // and [Performing Interactive Sign-in](http://developers.google.com/games/services/android/signin#performing_interactive_sign-in) for details on how to implement
                            // Interactive Sign-in.
                        }
                    }
                });
    }

}
