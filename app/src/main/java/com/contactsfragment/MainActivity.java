package com.contactsfragment;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends FragmentActivity implements LoaderManager.LoaderCallbacks<Cursor>{


    ListView lw;
    CustomContactAdapter adapter;
    Button b1,b2,b3,b4,b5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1=(Button)findViewById(R.id.button_1);
        b2=(Button)findViewById(R.id.button_2);
        b3=(Button)findViewById(R.id.button_3);
        b4=(Button)findViewById(R.id.button_4);
        b5=(Button)findViewById(R.id.button_5);
        lw=(ListView)findViewById(R.id.list);

        getSupportLoaderManager().initLoader(1,null,this);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        Uri CONTACT_URI = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        CursorLoader cursorLoader = new CursorLoader(this, CONTACT_URI, null,null, null, null);
        return cursorLoader;
    }


    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }

    class Holder {
        TextView tvCOntactName, tvContactNumber;
        ImageView ivContactImage;
    }


    Holder holder;
    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        cursor.moveToFirst();
        adapter = new CustomContactAdapter(this, cursor);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lw.setAdapter(adapter);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lw.setAdapter(adapter);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lw.setAdapter(adapter);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lw.setAdapter(adapter);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lw.setAdapter(adapter);
            }
        });



    }


}
