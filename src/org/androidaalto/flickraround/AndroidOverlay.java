package org.androidaalto.flickraround;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.Drawable;

import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.OverlayItem;


public class AndroidOverlay extends ItemizedOverlay {
	Context mContext;
    public AndroidOverlay(Drawable defaultMarker, Context context) {
          super(defaultMarker);
          ;
          mContext = context;
        }

    private ArrayList<OverlayItem>mOverlays= new ArrayList<OverlayItem>();

    public AndroidOverlay(Drawable defaultMarker) {
        super(boundCenterBottom(defaultMarker));
    }
    public void addOverlay(OverlayItem overlay) {
        mOverlays.add(overlay);
        populate();
    }

    @Override
    protected OverlayItem createItem(int i) {
        return mOverlays.get(i); }

    @Override
    public int size() {
        return mOverlays.size();
    }

    @Override
    protected boolean onTap(int index) {
      OverlayItem item = mOverlays.get(index);
    
	AlertDialog.Builder dialog = new AlertDialog.Builder(mContext);
      dialog.setTitle(item.getTitle());
      dialog.setMessage(item.getSnippet());
      dialog.show();
      return true;
    }

}