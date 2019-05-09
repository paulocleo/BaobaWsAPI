package com.baoba.home;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Firebase {

	public static void addProduto(Feira feira) {
		FileInputStream serviceAccount;
		FirebaseOptions options = null;

		try {
			serviceAccount = new FileInputStream("src/main/resources/baoba-home-firebase-adminsdk.json");

			options = new FirebaseOptions
					.Builder()
					.setCredentials(GoogleCredentials.fromStream(serviceAccount))
					.setDatabaseUrl("https://baoba-home.firebaseio.com/")
					.build();

			FirebaseApp.initializeApp(options);

			final FirebaseDatabase database = FirebaseDatabase.getInstance();
			DatabaseReference ref = database.getReference("Feira");

			ref.child("KeyTestejava").setValueAsync(feira);

			FirebaseApp.getInstance().delete();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
