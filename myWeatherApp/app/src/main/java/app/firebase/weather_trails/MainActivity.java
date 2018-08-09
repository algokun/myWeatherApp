package app.firebase.weather_trails;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView,wind_icon,pressure_icon;
    private ConstraintLayout constraintLayout;
    private EditText city;
    private Drawable snow,clearsky,rainy,defaulte,mist,thunder,clouds;
    private TextView lattitude, longitude, lat_data, long_data, condition, temp, degree,status,wind,wind_data,pressure,pressure_data,degreeC;
    private CardView cardView;
    private Button button;
    public String city_data = "";
    String baseURL="http://api.openweathermap.org/data/2.5/weather?q=";
    String API="&appid=79e9565b6d45f0a48a3ff121a711792c";
    String myURL="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        snow = getResources().getDrawable(R.drawable.snow);
        defaulte = getResources().getDrawable(R.drawable.bg43);
        rainy = getResources().getDrawable(R.drawable.rainy);
        clearsky = getResources().getDrawable(R.drawable.clearsky);
        mist = getResources().getDrawable(R.drawable.mist);
        thunder = getResources().getDrawable(R.drawable.thunder);
        clouds = getResources().getDrawable(R.drawable.cloudds);


        constraintLayout = findViewById(R.id.weather);
        button = findViewById(R.id.button);
        imageView = findViewById(R.id.icon);
        city = findViewById(R.id.city);
        degreeC = findViewById(R.id.ddegre2);
        wind_icon = findViewById(R.id.wind_icon);
        pressure_icon = findViewById(R.id.presurre_icon);
        temp = findViewById(R.id.temp);
        condition = findViewById(R.id.condition);
        wind = findViewById(R.id.wind);
        wind_data = findViewById(R.id.wind_data);
        pressure = findViewById(R.id.pressure);
        pressure_data = findViewById(R.id.pressure_data);
        lat_data = findViewById(R.id.lat_data);
        long_data = findViewById(R.id.long_data);
        lattitude = findViewById(R.id.lattitude);
        longitude = findViewById(R.id.longitude);
        degree = findViewById(R.id.degree);
        status = findViewById(R.id.status);
        cardView = findViewById(R.id.cardView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                city_data = city.getText().toString();
                if (city_data.isEmpty()) {
                    status.setText("Please Enter the city");
                    status.setVisibility(View.VISIBLE);
                } else {
                    cardView.setVisibility(View.VISIBLE);
                    status.setVisibility(View.INVISIBLE);
                    myURL = baseURL + city_data + API;
                    Log.i("Url", "Url is" + myURL);
                    JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, myURL, null, new Response.Listener <JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            String main, coord = null;
                            String lat = "", lon = "";
                            try {
                                String weather = response.getString("weather");
                                String mWeather = "", icon = "";

                                JSONArray array = new JSONArray(weather);
                                for (int i = 0; i < array.length(); i++) {
                                    JSONObject object = array.getJSONObject(i);
                                    mWeather = object.getString("main");
                                    //Setting the Condition
                                    condition.setText(mWeather);
                                    condition.setVisibility(View.VISIBLE);
                                    icon = "w" + object.getString("icon");
                                    Log.i("ICon", "ICOn is" + icon);
                                    //setting the weather icon
                                    imageView.setVisibility(View.VISIBLE);
                                    switch (icon) {
                                        case "w01d":
                                            imageView.setImageResource(R.drawable.w01d);
                                            constraintLayout.setBackground(clearsky);
                                            break;
                                        case "w01n":
                                            imageView.setImageResource(R.drawable.w01n);
                                            constraintLayout.setBackground(clearsky);
                                            break;
                                        case "w02d":
                                            imageView.setImageResource(R.drawable.w02d);
                                            constraintLayout.setBackground(clouds);
                                            break;
                                        case "w02n":
                                            imageView.setImageResource(R.drawable.w02n);
                                            constraintLayout.setBackground(clouds);
                                            break;
                                        case "w03d":
                                            imageView.setImageResource(R.drawable.w03d);
                                            constraintLayout.setBackground(clouds);
                                            break;
                                        case "w03n":
                                            imageView.setImageResource(R.drawable.w03n);
                                            constraintLayout.setBackground(clouds);
                                            break;
                                        case "w04d":
                                            imageView.setImageResource(R.drawable.w04d);
                                            constraintLayout.setBackground(clouds);
                                            break;
                                        case "w04n":
                                            imageView.setImageResource(R.drawable.w04n);
                                            constraintLayout.setBackground(clouds);
                                            break;
                                        case "w09d":
                                            imageView.setImageResource(R.drawable.w09d);
                                            constraintLayout.setBackground(rainy);
                                            break;
                                        case "w09n":
                                            imageView.setImageResource(R.drawable.w09n);
                                            constraintLayout.setBackground(rainy);
                                            break;
                                        case "w10d":
                                            imageView.setImageResource(R.drawable.w10d);
                                            constraintLayout.setBackground(rainy);
                                            break;
                                        case "w10n":
                                            imageView.setImageResource(R.drawable.w10n);
                                            constraintLayout.setBackground(rainy);
                                            break;
                                        case "w11d":
                                            imageView.setImageResource(R.drawable.w11d);
                                            constraintLayout.setBackground(thunder);
                                            break;
                                        case "w11n":
                                            imageView.setImageResource(R.drawable.w11n);
                                            constraintLayout.setBackground(thunder);
                                            break;
                                        case "w13d":
                                            imageView.setImageResource(R.drawable.w13d);
                                            constraintLayout.setBackground(snow);
                                            break;
                                        case "w13n":
                                            imageView.setImageResource(R.drawable.w13n);
                                            constraintLayout.setBackground(snow);
                                            break;
                                        case "w50d":
                                            imageView.setImageResource(R.drawable.w50d);
                                            constraintLayout.setBackground(mist);
                                            break;
                                        case "w50n":
                                            imageView.setImageResource(R.drawable.w50n);
                                            constraintLayout.setBackground(mist);
                                            break;
                                    }
                                }
                                coord = response.getString("coord");
                                JSONObject cordinates = new JSONObject(coord);
                                //setting the lat and lon
                                lon = cordinates.getString("lon");
                                lat = cordinates.getString("lat");
                                lattitude.setVisibility(View.VISIBLE);
                                lat_data.setText(lat);
                                longitude.setVisibility(View.VISIBLE);
                                long_data.setText(lon);

                                main = response.getString("main");
                                Log.i("main", main);
                                JSONObject jsonObject = new JSONObject(main);
                                String tempear = "";
                                tempear = jsonObject.getString("temp");
                                String prs = jsonObject.getString("pressure");
                                pressure_data.setVisibility(View.VISIBLE);
                                pressure.setVisibility(View.VISIBLE);
                                pressure_data.setText(prs);
                                float f = Float.parseFloat(tempear);
                                f = f - 273.5f;
                                double d = Math.ceil(Double.parseDouble(Float.toString(f)));
                                temp.setVisibility(View.VISIBLE);
                                Log.i("Temp", "Temp : " + tempear);
                                temp.setText(Double.toString(d));
                                degree.setVisibility(View.VISIBLE);
                                degreeC.setVisibility(View.VISIBLE);
                                String wind_string = response.getString("wind");
                                JSONObject wind_json = new JSONObject(wind_string);
                                String wind_json_op = wind_json.getString("speed");
                                wind.setVisibility(View.VISIBLE);
                                wind_data.setVisibility(View.VISIBLE);
                                wind_data.setText(wind_json_op);
                                wind_icon.setVisibility(View.VISIBLE);
                            } catch (JSONException e) {
                                status.setText(e.getMessage().toString());
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            status.setText("Some Thing Went Wrong");
                        }
                    });
                    mRequest.getInstance(MainActivity.this).addToRequestQue(jsonObjectRequest);
                }
            }
        });
    }
}