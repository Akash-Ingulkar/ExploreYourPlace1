package akshay.saurav.chandan.exploreyourplace.ui.Logout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import akshay.saurav.chandan.exploreyourplace.services.MyInterface;

public class Logout extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        MyInterface logoutfun=null;
        logoutfun.logout();
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
