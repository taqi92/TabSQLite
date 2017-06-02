
package thedev.taqi.tabsqlite;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.BitmapDrawable;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.vision.barcode.Barcode;

import java.util.ArrayList;
import java.util.List;

import thedev.taqi.tabsqlite.R;

public class FragmentPage3 extends Fragment implements OnMapReadyCallback {





    GoogleMap mGoogleMap;
    MapView mMapView;
    View mView;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView =  inflater.inflate(R.layout.fragment_fragment_page3, container,false);
        return mView;
    }


    public void onViewCreated(View view,Bundle saveInstanceState){
        super.onViewCreated(view,saveInstanceState);

        mMapView = (MapView) mView.findViewById(R.id.map);
        if(mMapView != null){
            mMapView.onCreate(null);
            mMapView.onResume();
            mMapView.getMapAsync(this);
        }

    }






    public void onMapReady(GoogleMap googleMap){

        MapsInitializer.initialize(getContext());

        mGoogleMap = googleMap;




        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        googleMap.addMarker(new MarkerOptions().position(new LatLng(37.4220,-122.084)).title("Dhaka").snippet("fine Place"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(40.64648844,-74.545458)).title("India").snippet("decent Place"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(44.64648844,-70.545458)).title("Bhutan").snippet("nice Place"));

        CameraPosition Liberty = CameraPosition.builder().target(new LatLng(40.64648844,-74.545458)).zoom(16).bearing(0).tilt(45).build();

        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(Liberty));





    }
}