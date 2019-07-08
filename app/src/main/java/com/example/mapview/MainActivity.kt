package com.example.mapview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    private var maplayerListView: ListView? = null
    private var mAdapter: ArrayAdapter<String>? = null

    private val classes = arrayOf<Class<*>>(
        MapLayerTestActivity::class.java,
        BitmapLayerTestActivity::class.java,
        LocationLayerTestActivity::class.java,
        MarkLayerTestActivity::class.java,
        RouteLayerTestActivity::class.java
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        maplayerListView = findViewById(R.id.mapview_lv) as ListView
        mAdapter = ArrayAdapter(
            this, android.R.layout.simple_list_item_1,
            resources.getStringArray(R.array.maplayer_name)
        )
        maplayerListView!!.adapter = mAdapter
        maplayerListView!!.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            Log.i(TAG, classes[position].simpleName)
            startActivity(Intent(this@MainActivity, classes[position]))
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        this.finish()
    }
}
