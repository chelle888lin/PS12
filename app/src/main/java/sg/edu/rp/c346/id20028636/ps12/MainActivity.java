package sg.edu.rp.c346.id20028636.ps12;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    ListView lvBusiness;
    AsyncHttpClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvBusiness = findViewById(R.id.lvBusiness);
        client = new AsyncHttpClient();
    }

    @Override
    protected void onResume() {
        super.onResume();

        ArrayList<BusinessForecast> alBusiness = new ArrayList<BusinessForecast>();

        client.get("https://data.gov.sg/api/action/datastore_search?resource_id=c3f30388-60f9-4124-b211-72683993a47c", new JsonHttpResponseHandler() {

            String Quarter;
            int ID;
            String Lvl1;
            int value;

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                try {
                    JSONArray jsonArrItems = response.getJSONArray("items");
                    JSONObject firstObj = jsonArrItems.getJSONObject(0);
                    JSONArray jsonArrForecasts = firstObj.getJSONArray("forecasts");
                    for (int i = 0; i < jsonArrForecasts.length(); i++) {
                        JSONObject jsonObjForecast = jsonArrForecasts.getJSONObject(i);
                        Quarter = jsonObjForecast.getString("Quarter");
                        ID = jsonObjForecast.getInt("ID");
                        Lvl1 = jsonObjForecast.getString("Lvl1");
                        value = jsonObjForecast.getInt("value");
                        BusinessForecast business = new BusinessForecast(Quarter,ID,Lvl1,value);
                        alBusiness.add(business);
                    }
                } catch (JSONException e) {
                    Log.d("exception", e.toString());
                }

                //POINT X – Code to display List View
                ArrayAdapter<BusinessForecast> aaBusiness = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, alBusiness);
                lvBusiness.setAdapter(aaBusiness);

            }
            //end onSuccess

        });
    }//end onResume

}