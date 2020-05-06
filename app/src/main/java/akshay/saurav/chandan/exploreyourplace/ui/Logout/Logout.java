package akshay.saurav.chandan.exploreyourplace.ui.Logout;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import akshay.saurav.chandan.exploreyourplace.MainActivity;
import akshay.saurav.chandan.exploreyourplace.services.MyInterface;

public class Logout extends Fragment {
    MyInterface logoutListener;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view= super.onCreateView(inflater, container, savedInstanceState);

        logoutListener.logout();

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = (Activity) context;
        logoutListener = (MyInterface) activity;

    }
}
