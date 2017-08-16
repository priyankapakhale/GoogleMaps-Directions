package com.example.priyanka.mapsnearbyplaces;

import android.renderscript.ScriptGroup;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Priyanka on 7/11/17.
 */

public class DownloadUrl {

    public String readUrl(String myUrl) throws IOException
    {
        String data = "";
        InputStream inputStream = null;
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL(myUrl);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.connect();

            inputStream = urlConnection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            StringBuffer sb = new StringBuffer();

            String line = "";
            while((line = br.readLine()) != null)
            {
                sb.append(line);

            }

            data = sb.toString();
            Log.d("downloadUrl", data.toString());

            br.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(inputStream != null)
                inputStream.close();
            urlConnection.disconnect();
        }

        Log.d("data downlaod",data);
        return data;

    }
}
