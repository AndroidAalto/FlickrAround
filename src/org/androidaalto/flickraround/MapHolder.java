package org.androidaalto.flickraround;

import java.util.ArrayList;
import java.util.List;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.MyLocationOverlay;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

public class MapHolder extends MapActivity{
	
	private MyLocationOverlay myLocationOverlay;
	private GeoPoint geoPoint;
	private ArrayList<OverlayItem> mOverlays = new ArrayList<OverlayItem>();
	
	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;	
	}

	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		try {
			setContentView(R.layout.map_layout);
			MapView mapView = (MapView) findViewById(R.id.mapview);
			mapView.setBuiltInZoomControls(true);
			myLocationOverlay = new MyLocationOverlay(this, mapView);
			mapView.getOverlays().add(myLocationOverlay);
			mapView.invalidate();
			mapView.setSatellite(false);
			
			//LocationOverlay over = new LocationOverlay();
			
			 List<Overlay> mapOverlays = mapView.getOverlays();
			    Drawable drawable = this.getResources().getDrawable(R.drawable.androidmarker );
			    AndroidOverlay itemizedoverlay = new AndroidOverlay(drawable);
			
			    OverlayItem overlayitem = new OverlayItem(geoPoint, "Hola, Mundo!", "I'm in Mexico City!");
			    itemizedoverlay.addOverlay(overlayitem);
			    
			    mapOverlays.add(itemizedoverlay);
			    geoPoint = new GeoPoint( (int) (52.334822 * 1E6), (int) (4.668907 * 1E6));
			GeoPoint geoPoint2 = new GeoPoint( (int) (52.334832 * 1E6), (int) (4.668907 * 1E6));
			MapController mc = mapView.getController();
			mc.setZoom(18);
			mc.animateTo(geoPoint);
			
			
			
			
			//List<Overlay> mapOverlays = mapView.getOverlays();
			
			 
			
		} catch (Exception e) {
			// TODO: handle exception
			Log.v("map", e.toString());
		}

	}
	
	
 
	 
 
	
	@Override
	protected void onPause() {
		super.onPause();
		//Don't using navigation to prevent battery drain
		myLocationOverlay.disableMyLocation();
	}
	
	@Override
		protected void onResume() {
		super.onResume();
	myLocationOverlay.enableMyLocation();
	}
	
	
	
}
