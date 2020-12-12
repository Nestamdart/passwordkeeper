package com.olegdev.passwordkeeper;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;

public class MainActivity extends AppCompatActivity implements NavController.OnDestinationChangedListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Navigation.findNavController(this, R.id.mainNavHostFragment)
                .addOnDestinationChangedListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Navigation.findNavController(this, R.id.mainNavHostFragment)
                .removeOnDestinationChangedListener(this);
    }

    @Override
    public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {
        if (destination.getLabel().toString().equals("fragment_main")) {
            controller.navigate(R.id.action_fragmentMain_to_passwordsFragment);
        }
    }
}