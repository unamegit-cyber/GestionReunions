package com.openclassrooms.gestionreunions.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.AttributeSet;
import android.widget.ArrayAdapter;

import com.openclassrooms.gestionreunions.model.Contributor;

import java.util.ArrayList;
import java.util.List;

public class MultiSpinner extends androidx.appcompat.widget.AppCompatSpinner implements
        DialogInterface.OnMultiChoiceClickListener, DialogInterface.OnCancelListener {

    private List<String> items;
    private boolean[] selected;
    private String defaultText;

    public MultiSpinner(Context context) {
        super(context);
    }

    public MultiSpinner(Context arg0, AttributeSet arg1) {
        super(arg0, arg1);
    }

    public MultiSpinner(Context arg0, AttributeSet arg1, int arg2) {
        super(arg0, arg1, arg2);
    }

    @Override
    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
        selected[which] = isChecked;
    }

    @Override
    public void onCancel(DialogInterface dialog) {
        StringBuffer spinnerBuffer = new StringBuffer();
        boolean someSelected = false;
        for (int i = 0; i < items.size(); i++) {
            if (selected[i] == true) {
                spinnerBuffer.append(items.get(i));
                spinnerBuffer.append(", ");
                someSelected = true;
            }
        }
        String spinnerText;
        if (someSelected) {
            spinnerText = spinnerBuffer.toString();
            if (spinnerText.length() > 2)
                spinnerText = spinnerText.substring(0, spinnerText.length() - 2);
        } else {
            spinnerText = defaultText;
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_spinner_item,
                new String[] { spinnerText });
        setAdapter(adapter);
        //listener.onItemsSelected(selected);
    }

    @Override
    public boolean performClick() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMultiChoiceItems(
                items.toArray(new CharSequence[items.size()]), selected, this);
                builder.setPositiveButton(android.R.string.ok,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        builder.setOnCancelListener(this);
        builder.show();
        return true;
    }

    public void setItems(List<String> items) {
        this.items = items;
        this.selected = new boolean[items.size()];
    }

    public ArrayList<String> getItems() {
        ArrayList<String> result = new ArrayList<>();
        for(int i = 0; i < this.items.size(); i++) {
            if (this.selected[i]) {
                result.add(this.items.get(i));
            }
        }
        return result;
    }
}