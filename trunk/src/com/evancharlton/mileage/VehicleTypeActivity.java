package com.evancharlton.mileage;

import android.content.ContentUris;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.widget.EditText;

import com.evancharlton.mileage.dao.Dao;
import com.evancharlton.mileage.dao.VehicleType;
import com.evancharlton.mileage.provider.FillUpsProvider;
import com.evancharlton.mileage.provider.tables.VehicleTypesTable;

public class VehicleTypeActivity extends BaseFormActivity {
	private EditText mTitle;
	private EditText mDescription;
	private VehicleType mVehicleType = new VehicleType(new ContentValues());

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState, R.layout.vehicle_type);
	}

	@Override
	protected Dao getDao() {
		return mVehicleType;
	}

	@Override
	protected void initUI() {
		mTitle = (EditText) findViewById(R.id.title);
		mDescription = (EditText) findViewById(R.id.description);
	}

	@Override
	protected void populateUI() {
		mTitle.setText(mVehicleType.getTitle());
		mDescription.setText(mVehicleType.getDescription());
	}

	@Override
	protected void setFields() {
		mVehicleType.setTitle(mTitle.getText().toString());
		mVehicleType.setDescription(mDescription.getText().toString());
	}

	@Override
	protected String[] getProjectionArray() {
		return VehicleTypesTable.getFullProjectionArray();
	}

	@Override
	protected Uri getUri(long id) {
		return ContentUris.withAppendedId(Uri.withAppendedPath(FillUpsProvider.BASE_URI, VehicleTypesTable.TYPE_URI), id);
	}
}