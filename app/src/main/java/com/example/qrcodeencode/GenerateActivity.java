package com.example.qrcodeencode;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class GenerateActivity extends AppCompatActivity {
    EditText text;
    Button generate_btn;
    ImageView image;
    String text2QR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate);
        text=(EditText) findViewById((R.id.text));
        generate_btn=(Button) findViewById(R.id.generate_btn);
        image=(ImageView)findViewById(R.id.image);
        generate_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text2QR = text.getText().toString().trim();
                MultiFormatWriter multiFormatWriter= new MultiFormatWriter();
                try{
                    BitMatrix bitMatrix= multiFormatWriter.encode(text2QR, BarcodeFormat.QR_CODE,200,200);
                    BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                    Bitmap bitmap= barcodeEncoder.createBitmap(bitMatrix);
                    image.setImageBitmap(bitmap);
                }
                catch(WriterException e){
                    e.printStackTrace();
                }
            }
        });
    }
}
