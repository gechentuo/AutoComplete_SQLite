package com.example.autocompletetextview_sqlite;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.AutoCompleteTextView;

public class MyAutoCompleteTextView extends AutoCompleteTextView {

	public MyAutoCompleteTextView(Context context) {
		super(context);
	 }
	
	public MyAutoCompleteTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
 	}

	public MyAutoCompleteTextView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
 	}

	 
	
	@Override
	protected void performFiltering(CharSequence text, int keyCode) {
		String filterText = "";
		super.performFiltering(filterText, keyCode);
	}
	
	@Override
	protected void replaceText(final CharSequence text) {
		super.replaceText(text);
	}
	
}
