package com.example.homelayout.ui.workshops;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.homelayout.R;
import com.example.homelayout.controller.WorkshopController;
import com.example.homelayout.domain.WorkshopPictureObject;
import com.example.homelayout.domain.Workshops;
import com.example.homelayout.domain.WorkshopsObject;

import java.sql.SQLException;
import java.util.List;

public class WorkshopDanceFragment extends Fragment implements View.OnClickListener, WorkshopController.WorkshopsControllerListener {
    private WorkshopController workshopController;
    private int workshopIndex;
    private List<WorkshopsObject> workshopsObjectList;
    private WorkshopPictureObject workshopPictureObject;
    private LinearLayout llBreakdance;
    private LinearLayout llDanceFit;
    private LinearLayout llFlashmob;
    private LinearLayout llHiphop;
    private LinearLayout llModernDance;
    private LinearLayout llStepping;
    private LinearLayout llStreetDance;
    private ImageButton mButtonBreakdance;
    private ImageButton mButtonDanceFit;
    private ImageButton mButtonFlashmob;
    private ImageButton mButtonHipHop;
    private ImageButton mButtonModernDance;
    private ImageButton mButtonStepping;
    private ImageButton mButtonStreetdance;
    private ImageView mImageViewBreakDance;
    private ImageView mImageViewDanceFit;
    private ImageView mImageViewFlashMob;
    private ImageView mImageViewHipHop;
    private ImageView mImageViewModernDance;
    private ImageView mImageViewStepping;
    private ImageView mImageViewStreetdance;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_workshop_dance, container, false);

        mImageViewBreakDance = root.findViewById(R.id.iv_workshop_breakdance);
        mImageViewDanceFit = root.findViewById(R.id.iv_workshop_dance_fit);
        mImageViewFlashMob = root.findViewById(R.id.iv_workshop_flashmob);
        mImageViewHipHop = root.findViewById(R.id.iv_workshop_hiphop_design);
        mImageViewModernDance = root.findViewById(R.id.iv_workshop_modern_dance);
        mImageViewStepping = root.findViewById(R.id.iv_workshop_stepping);
        mImageViewStreetdance = root.findViewById(R.id.iv_workshop_streetdance);
        mButtonBreakdance = root.findViewById(R.id.breakdance_info);

        new WorkshopController(this).loadWorkshopsByCategory("Dans");

        mButtonBreakdance.setClickable(true);
        mButtonDanceFit = root.findViewById(R.id.dance_fit_info);
        mButtonDanceFit.setClickable(true);
        mButtonFlashmob = root.findViewById(R.id.flashmob_info);
        mButtonFlashmob.setClickable(true);
        mButtonHipHop = root.findViewById(R.id.hiphop_info);
        mButtonHipHop.setClickable(true);
        mButtonModernDance = root.findViewById(R.id.modern_dance_info);
        mButtonModernDance.setClickable(true);
        mButtonStepping = root.findViewById(R.id.stepping_info);
        mButtonStepping.setClickable(true);
        mButtonStreetdance = root.findViewById(R.id.streetdance_info);
        mButtonStreetdance.setClickable(true);
        mButtonBreakdance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://skoolworkshop.nl/workshops/workshop-breakdance/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        mButtonDanceFit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://skoolworkshop.nl/workshops/workshop-dance-fit/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        mButtonFlashmob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://skoolworkshop.nl/workshops/workshop-flashmob/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        mButtonHipHop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://skoolworkshop.nl/workshops/workshop-hiphop/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        mButtonModernDance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://skoolworkshop.nl/workshops/workshop-moderne-dans/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        mButtonStepping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://skoolworkshop.nl/workshops/workshop-stepping/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        mButtonStreetdance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://skoolworkshop.nl/workshops/workshop-streetdance/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        llBreakdance = root.findViewById(R.id.layout_workshop_breakdance);
        llDanceFit = root.findViewById(R.id.layout_workshop_dance_fit);
        llFlashmob = root.findViewById(R.id.layout_workshop_flashmob);
        llHiphop = root.findViewById(R.id.layout_workshop_hiphop);
        llModernDance = root.findViewById(R.id.layout_workshop_modern_dance);
        llStepping = root.findViewById(R.id.layout_workshop_stepping);
        llStreetDance = root.findViewById(R.id.layout_workshop_streetdance);

        llBreakdance.setOnClickListener(this);
        llDanceFit.setOnClickListener(this);
        llFlashmob.setOnClickListener(this);
        llHiphop.setOnClickListener(this);
        llModernDance.setOnClickListener(this);
        llStepping.setOnClickListener(this);
        llStreetDance.setOnClickListener(this);

        return root;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.layout_workshop_breakdance:
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new WorkshopsForm(Workshops.Breakdance)).addToBackStack(null).commit();
                break;
            case R.id.layout_workshop_dance_fit:
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new WorkshopsForm(Workshops.DanceFit)).addToBackStack(null).commit();
                break;
            case R.id.layout_workshop_flashmob:
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new WorkshopsForm(Workshops.Flashmob)).addToBackStack(null).commit();
                break;
            case R.id.layout_workshop_hiphop:
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new WorkshopsForm(Workshops.Hiphop)).addToBackStack(null).commit();
                break;
            case R.id.layout_workshop_modern_dance:
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new WorkshopsForm(Workshops.ModerneDans)).addToBackStack(null).commit();
                break;
            case R.id.layout_workshop_stepping:
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new WorkshopsForm(Workshops.Stepping)).addToBackStack(null).commit();
                break;
            case R.id.layout_workshop_streetdance:
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new WorkshopsForm(Workshops.Streetdance)).addToBackStack(null).commit();
                break;
        }
    }

    @Override
    public void onWorkshopsAvailable(List<WorkshopsObject> workshopsObjectList) throws SQLException {
        this.workshopsObjectList = workshopsObjectList;
        for (WorkshopsObject i : workshopsObjectList) {
            fillImages(i);
        }
    }

    public void fillImages(WorkshopsObject workshopsObject) throws SQLException {
        WorkshopPictureObject[] workshopPictureObject = workshopsObject.getPictureObject();
        switch (workshopsObject.getCodeName()) {
            case "SkoolHiphop":
                mImageViewHipHop
                        .setImageBitmap(workshopPictureObject[0]
                                .getBlob()
                                .convertBlobIntoImage());

            case "SkoolModerneDans":
                mImageViewModernDance
                        .setImageBitmap(workshopPictureObject[0]
                                .getBlob()
                                .convertBlobIntoImage());
            case "SkoolBreakdance":
                mImageViewBreakDance
                        .setImageBitmap(workshopPictureObject[0]
                                .getBlob()
                                .convertBlobIntoImage());
            case "SkoolDance-Fit":
                mImageViewDanceFit
                        .setImageBitmap(workshopPictureObject[0]
                                .getBlob()
                                .convertBlobIntoImage());
            case "SkoolFlashmob":
                mImageViewFlashMob
                        .setImageBitmap(workshopPictureObject[0]
                                .getBlob()
                                .convertBlobIntoImage());
            case "SkoolStepping":
                mImageViewStepping
                        .setImageBitmap(workshopPictureObject[0]
                                .getBlob()
                                .convertBlobIntoImage());
            case "SkoolStreetdance":
                mImageViewStreetdance
                        .setImageBitmap(workshopPictureObject[0]
                                .getBlob()
                                .convertBlobIntoImage());
            case "DigitaleDans":
        }
    }
}

