package akshay.saurav.chandan.exploreyourplace.ui.My_Shortlisted;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import akshay.saurav.chandan.exploreyourplaces.R;


public class myshortlisted extends Fragment {

    private MyshortlistedViewModel mViewModel;

    public static myshortlisted newInstance() {
        return new myshortlisted();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.myshortlisted_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MyshortlistedViewModel.class);
        // TODO: Use the ViewModel
    }

}
