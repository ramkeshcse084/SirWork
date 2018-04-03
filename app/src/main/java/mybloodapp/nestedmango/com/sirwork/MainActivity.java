package mybloodapp.nestedmango.com.sirwork;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.widget.TextView;

import java.math.BigInteger;

public class MainActivity extends AppCompatActivity {
TextView txtValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
txtValue=(TextView)findViewById(R.id.txtValue);
        //VERBOSE(Log.VERBOSE), DEBUG(Log.DEBUG), INFO(Log.INFO), WARN(Log.WARN), ERROR(Log.ERROR), ASSERT(Log.ASSERT), SUPRESS(8);
        String str="FAQyGxcUHBYWBCIWESIQHRQyFBcXFAQSFAQAExEiYRYUBAQTFgRhaF8=";
        String str1="GxE+YRsBEC8YAQBmGhE+ZRsBDGUYARgsGAEAZRoRPmUbPwBlGhE+LV8=";
        String str2="FDJlGREUFB0WBBgaESImGxQyNhIUBDYTFDIAEhYyPhARMhwSESJhaF8=";
        String str3="GxE+YRsBEC8YAQBmGhE+ZRsBDGUYARgsGAEAZRoRPmUbPwBlGhE+LV8=";
            byte a[]=str.getBytes();
        byte b[]=str1.getBytes();
        byte c[]=str2.getBytes();
        byte d[]=str3.getBytes();


       // byte a[]=new  byte[]{"FAQyGxcUHBYWBCIWESIQHRQyFBcXFAQSFAQAExEiYRYUBAQTFgRhaF8="};
        String value=getDecodedKey(a);
        Log.d("MyValue",value);
        txtValue.setText(value);
        int l=value.length();
        Log.d("Len:",l+"");
        Log.d("Value", value);

        BigInteger localBigInteger1 = new BigInteger(getRivestKey(getDecodedKey(a), getDecodedKey(b)));
        BigInteger localBigInteger2 = new BigInteger(getRivestKey(getDecodedKey(c), getDecodedKey(d)));
        Log.d("LocalBigInt1:",localBigInteger1+"");
        Log.d("LocalBigInt2:",localBigInteger2+"");

    }


    public String getDecodedKey(byte[] paramString)
    {

        paramString  = new String(Base64.decode(paramString, 0)).getBytes();
       int len= paramString.length;
       Log.d("Len64",len+"");
       // Log.d("Param64",paramString);
        int i = 0;
        while (i < paramString.length)
        {
            paramString[i] = ((byte)(paramString[i] & 0xFF ^ 0x55));
            i += 1;
        }
        return new String(Base64.decode(new String(paramString), 0));
    }
    private String getRivestKey(String paramString1, String paramString2)
    {
        StringBuilder localStringBuilder = new StringBuilder();
        int i = 0;
        while ((i < paramString1.length()) && (i < paramString2.length()))
        {
            localStringBuilder.append((char)(paramString1.charAt(i) ^ paramString2.charAt(i)));
            i += 1;
        }
        return localStringBuilder.toString();
    }

}
