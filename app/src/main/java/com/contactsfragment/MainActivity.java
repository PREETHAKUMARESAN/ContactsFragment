package com.contactsfragment;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import layout.Contacts_List;

public class MainActivity extends FragmentActivity implements LoaderManager.LoaderCallbacks<Cursor>{


    ListView lw;
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

        Fragment myFragment;
        myFragment=new Contacts_List();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        holder = new Holder();
        holder.tvCOntactName = (TextView)findViewById(R.id.tvContactName);
        holder.tvContactNumber = (TextView)findViewById(R.id.tvContactNumber);
        holder.ivContactImage = (ImageView)findViewById(R.id.ivContactImage);


        cursor.moveToFirst();
        while(!cursor.isAfterLast()){

            holder.tvCOntactName.setText(cursor.getString(cursor
                    .getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)));
            holder.tvContactNumber.setText(cursor.getString(cursor
                    .getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)));


        }

        fragmentTransaction.add(R.id.frag, myFragment);
        fragmentTransaction.replace(R.id.frag,myFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();


    }


}
