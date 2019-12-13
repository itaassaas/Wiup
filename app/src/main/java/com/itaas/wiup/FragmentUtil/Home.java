package com.itaas.wiup.FragmentUtil;

import android.content.Intent;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.itaas.wiup.ActivityUtil.History;
import com.itaas.wiup.ActivityUtil.ListOfPlaces;
import com.itaas.wiup.ActivityUtil.PlaceDetail;
import com.itaas.wiup.ActivityUtil.SearchPlace;
import com.itaas.wiup.AdapterUtil.HomeAdapter;
import com.itaas.wiup.ConstantUtil.Constant;
import com.itaas.wiup.InterfaceUtil.DirectoryCallback;
import com.itaas.wiup.InterfaceUtil.LocationCallback;
import com.itaas.wiup.InterfaceUtil.WeatherCallback;
import com.itaas.wiup.ManagementUtil.Management;
import com.itaas.wiup.ObjectUtil.EmptyState;
import com.itaas.wiup.ObjectUtil.NearbyPlaces;
import com.itaas.wiup.ObjectUtil.PlaceData;
import com.itaas.wiup.ObjectUtil.PlaceParameter;
import com.itaas.wiup.ObjectUtil.WeatherDetail;
import com.itaas.wiup.ObjectUtil.WeatherParameter;
import com.itaas.wiup.R;
import com.itaas.wiup.Utility.Utility;

import java.io.Serializable;
import java.util.ArrayList;

import io.nlopez.smartlocation.OnLocationUpdatedListener;
import io.nlopez.smartlocation.SmartLocation;
import io.nlopez.smartlocation.location.config.LocationParams;
import io.nlopez.smartlocation.location.providers.LocationGooglePlayServicesProvider;

import static com.mapbox.mapboxsdk.Mapbox.getApplicationContext;

public class Home extends Fragment implements LocationCallback, DirectoryCallback, View.OnClickListener, OnLocationUpdatedListener, WeatherCallback {
    private Double latitude;
    private Double longitude;
    private TextView txtMenu;
    private ImageView imageBack;
    private ImageView imageShare;
    private Management management;
    private HomeAdapter homeAdapter;
    private SmartLocation smartLocation;
    private RecyclerView recyclerViewHome;
    private GridLayoutManager gridLayoutManager;
    private LocationGooglePlayServicesProvider provider;
    private ArrayList<Object> objectArrayList = new ArrayList<>();
    private int visibleThreshold = 2;
    private int lastVisibleItem, totalItemCount;
    private boolean loading;
    private String cityName;
    public LocationCallback locationCallback;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_home, null);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initUI(view, savedInstanceState); //Initialize UI


    }

    /**
     * <p>It initialize the UI</p>
     */
    private void initUI(View view, Bundle savedInstanceState) {

        txtMenu = (TextView) view.findViewById(R.id.txt_menu);
        txtMenu.setText(Constant.MenuText.HOME_TEXT);

        imageBack = (ImageView) view.findViewById(R.id.image_back);
        imageBack.setVisibility(View.GONE);

        imageShare = view.findViewById(R.id.image_share);
        imageShare.setImageResource(R.drawable.poi_icon);
        imageShare.setVisibility(View.VISIBLE);

        Constant.setLocationCallback(this::locationAccessGranted);

        management = new Management(getActivity());

        startLocation();  //It start location

       /* if (Utility.isLocationProviderAvailable(getActivity(), true))
            startLocation();  //It start location
        else {
            triggerLocationSettingAlert();
        }*/


        gridLayoutManager = new GridLayoutManager(getActivity(), 1, LinearLayoutManager.VERTICAL, false);

        objectArrayList.add(new EmptyState());

        recyclerViewHome = (RecyclerView) view.findViewById(R.id.recycler_view_home);
        recyclerViewHome.setLayoutManager(gridLayoutManager);

        homeAdapter = new HomeAdapter(getActivity(), objectArrayList) {
            @Override
            public void onPlaceSelector(Constant.EVENTS events, int parentPosition, int childPosition) {

                if (events == Constant.EVENTS.FEATURE_PLACE) {

                    ArrayList<PlaceData> placeDataArray = (ArrayList<PlaceData>) objectArrayList.get(parentPosition);
                    PlaceData placeData = placeDataArray.get(childPosition);

                    Intent intent = new Intent(getActivity(), SearchPlace.class);
                    intent.putExtra(Constant.IntentKey.PLACE_REQUIRED, placeData.getPlaceTag());
                    startActivity(intent);

                } else if (events == Constant.EVENTS.PLACE) {

                    ArrayList<NearbyPlaces> placeDataArray = (ArrayList<NearbyPlaces>) objectArrayList.get(parentPosition);
                    NearbyPlaces placeData = placeDataArray.get(childPosition);

                    Utility.Logger("Place Id", placeData.getPlaceId());

                    Intent intent = new Intent(getActivity(), PlaceDetail.class);
                    intent.putExtra(Constant.IntentKey.PLACE_DETAIL, (Serializable) placeData);
                    startActivity(intent);


                }
            }

            @Override
            public void onFeatureMoreView() {

                Intent intent = new Intent(getActivity(), ListOfPlaces.class);
                startActivity(intent);

            }
        };
        recyclerViewHome.setAdapter(homeAdapter);
        recyclerViewHome.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                totalItemCount = gridLayoutManager.getItemCount();
                lastVisibleItem = gridLayoutManager
                        .findLastVisibleItemPosition();
                if (!loading
                        && totalItemCount <= (lastVisibleItem + visibleThreshold)) {
                    // End has been reached
                    // Do something


                    loading = true;
                }

            }
        });

        txtMenu.setOnClickListener(this);
        imageShare.setOnClickListener(this::onClick);


    }

    /**
     * <p>It is used to start location & get user current location</p>
     */
    private void startLocation() {

       /* provider = new LocationGooglePlayServicesProvider();
        provider.setCheckLocationSettings(true);*/

        smartLocation = new SmartLocation.Builder(getActivity()).logging(true).build();
        smartLocation.location().config(LocationParams.BEST_EFFORT).oneFix().start(this);

    }


    @Override
    public void onSuccess(ArrayList<Object> result) {
        objectArrayList.add(result);
        homeAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        if (v == txtMenu) {
            startActivity(new Intent(getActivity(), History.class));
        }
        if (v == imageShare) {
           if (!(android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)) {

                Toast.makeText(getApplicationContext(),"Entro",Toast.LENGTH_SHORT).show();

                Utility.Toaster(getActivity(), Constant.ToastMessage.DID_NOT_SUPPORT_VERSION, Toast.LENGTH_SHORT);
                return;
            }
            else
                Toast.makeText(getApplicationContext(),"entro 2",Toast.LENGTH_SHORT).show();

            if (!Utility.checkIfSensorsAvailable(getContext())) {
                Utility.Toaster(getActivity(), Constant.ToastMessage.DID_NOT_HAVE_COMPASS, Toast.LENGTH_SHORT);
                return;
            }


            Toast.makeText(getApplicationContext(),"Abriendo camara",Toast.LENGTH_SHORT).show();
            Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(i,0);



        }
    }


    @Override
    public void onLocationUpdated(Location location) {

        latitude = location.getLatitude();
        longitude = location.getLongitude();

        /*latitude = 34.067264;
        longitude = -117.280517;*/

        if (location.hasAccuracy() && location.getAccuracy() < 50F) {
            // the location has accuracy and has an accuracy span within 100m radius
            // do whatever you want with this location and stop location listener
            Utility.Logger("Accuracy", String.valueOf(location.getAccuracy()));
            cityName = Utility.getCityNameByCoordinates(getActivity(), latitude, longitude, true);
            management.sendWeatherRequest(new WeatherParameter(latitude, longitude, this, null));
            Constant.setCityName(cityName);

        } else {

            startLocation();

        }


    }

    @Override
    public void onWeatherSuccess(String temp, String tempTagline) {

        Utility.Logger("Summary", tempTagline);

        objectArrayList.clear();
        objectArrayList.add(new WeatherDetail(cityName.toUpperCase(), temp, tempTagline));
        objectArrayList.add(Utility.getFeaturedPlaces());
        homeAdapter.notifyDataSetChanged();
        management.sendServerRequest(Constant.REQUEST.TOP_PLACES, new PlaceParameter(Utility.formatTopPlaceQuery("Best Restaurant in " + cityName), String.valueOf(latitude), String.valueOf(longitude), null, Home.this/*null, , "restaurant", "2500", null, Home.this*/));

    }

    @Override
    public void onWeatherFailure(String error) {
        Utility.Toaster(getActivity(), Constant.ToastMessage.WEATHER_ERROR, Toast.LENGTH_SHORT);

        objectArrayList.clear();
        objectArrayList.add(new WeatherDetail(cityName.toUpperCase(), "0", "Error Occur"));
        objectArrayList.add(Utility.getFeaturedPlaces());
        homeAdapter.notifyDataSetChanged();
        management.sendServerRequest(Constant.REQUEST.TOP_PLACES, new PlaceParameter(Utility.formatTopPlaceQuery("Best Restaurant in " + cityName), String.valueOf(latitude), String.valueOf(longitude), null, Home.this/*null, , "restaurant", "2500", null, Home.this*/));


    }


    @Override
    public void locationAccessGranted() {
        startLocation();
    }


}