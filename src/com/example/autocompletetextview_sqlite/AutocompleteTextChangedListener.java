package com.example.autocompletetextview_sqlite;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;

public class AutocompleteTextChangedListener implements TextWatcher {
	Context context;

	public AutocompleteTextChangedListener(Context context) {
		this.context = context;
	}

	@Override
	public void afterTextChanged(Editable s) {

	}

	@Override
	public void beforeTextChanged(CharSequence s, int start, int count,
			int after) {

	}

	@Override
	public void onTextChanged(CharSequence userInput, int start, int before,
			int count) {
		MainActivity mainActivity = (MainActivity) context;
		mainActivity.item = mainActivity.getItemsFromDb(userInput.toString());
		
		// update the adapter
		mainActivity.myAdapter.notifyDataSetChanged();
		mainActivity.myAdapter = new ArrayAdapter<String>(mainActivity,
				android.R.layout.simple_list_item_1, mainActivity.item);
		mainActivity.myAutoComplete.setAdapter(mainActivity.myAdapter);
	}

}
