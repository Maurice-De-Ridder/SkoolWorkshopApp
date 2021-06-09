package com.example.homelayout.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.homelayout.R;
import com.example.homelayout.ui.Cultureday.Form.CulturedayBookingFormFragment;
import com.example.homelayout.ui.messagebox.MessageBoxFragment;
import com.example.homelayout.ui.workshops.WorkshopsFragment;
import com.example.homelayout.ui.workshops.WorkshopsPopular;

public class HomeFragment extends Fragment implements View.OnClickListener {

    private Button btnBookWorkshop;
    private Button btnBookCultureDay;
    private ConstraintLayout clPopularWorkshops;
    private ImageView ivBell;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        btnBookWorkshop = root.findViewById(R.id.button_book_workshop);
        btnBookWorkshop.setClickable(true);
        btnBookCultureDay = root.findViewById(R.id.button_book_culture_day);
        btnBookCultureDay.setClickable(true);
        clPopularWorkshops = root.findViewById(R.id.home_item_popular_workshops);
        clPopularWorkshops.setClickable(true);
        ivBell = root.findViewById(R.id.iv_home_bell);
        ivBell.setClickable(true);

        btnBookWorkshop.setOnClickListener(this);
        btnBookCultureDay.setOnClickListener(this);
        clPopularWorkshops.setOnClickListener(this);
        ivBell.setOnClickListener(this);

        return root;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_book_workshop:
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new WorkshopsFragment()).commit();
                break;
            case R.id.button_book_culture_day:
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new CulturedayBookingFormFragment()).commit();
                break;
            case R.id.home_item_popular_workshops:
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new WorkshopsPopular()).commit();
                break;
            case R.id.iv_home_bell:
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new MessageBoxFragment()).commit();
                break;
        }
    }
}