package com.detrickdeburr.albertblackformayor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.braintreepayments.api.dropin.DropInActivity;
import com.braintreepayments.api.dropin.DropInRequest;
import com.braintreepayments.api.dropin.DropInResult;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import cz.msebera.android.httpclient.Header;
public class DonateActivity extends AppCompatActivity {
    EditText donationAmount;
    final int REQUEST_CODE = 999;
    double DonationAmt=0.00;
    final String TAG = "DonateActivity";
    final String API_CHECK_OUT = "http://x1.gametimegiving.com/experiment/CreateTransaction";
    private AsyncHttpClient client = new AsyncHttpClient();
    Button btnDonate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate);
        donationAmount = findViewById(R.id.etDonationAmount);
        btnDonate = findViewById(R.id.btndonate);
        btnDonate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProcessDonation();
            }
        });

    }

    private void ProcessDonation() {
        DonationAmt= Double.parseDouble(donationAmount.getText().toString());
        DropInRequest dropInRequest = new DropInRequest()
                .clientToken("sandbox_mdys6zxr_jstvnq9hgzfgrt79");
        startActivityForResult(dropInRequest.getIntent(DonateActivity.this), REQUEST_CODE);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                DropInResult result = data.getParcelableExtra(DropInResult.EXTRA_DROP_IN_RESULT);
                // use the result to update your UI and send the payment method nonce to your server
                String PaymentMethodNonce = result.getPaymentMethodNonce().getNonce();
                SendPaymentMethod(PaymentMethodNonce, DonationAmt);
                Log.d(TAG, String.format("PaymentMethodNonce:%s", PaymentMethodNonce));
            } else if (resultCode == Activity.RESULT_CANCELED) {
                // the user canceled
                Log.d(TAG, String.format("Result Cancelled:%s", Activity.RESULT_CANCELED));
            } else {
                // handle errors here, an exception may be available in
                Exception error = (Exception) data.getSerializableExtra(DropInActivity.EXTRA_ERROR);
                Log.d(TAG, String.format("Activity OK: %s Exception:%s",
                        Activity.RESULT_OK,
                        error.toString()));
            }
        }
    }
    public void SendPaymentMethod(String nonce, double amt) {
        RequestParams params = new RequestParams();
        params.put("nonce", nonce);
        params.put("amt", amt);
        client.post(API_CHECK_OUT, params,
                new AsyncHttpResponseHandler() {

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                        Log.d(TAG, String.format("Payment Successful:%s", responseBody.toString()));
                        btnDonate.setText("Payment Successful");
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                        Log.d(TAG, String.format("Payment Not Successful:%s", error.toString()));
                        btnDonate.setText("Try Again.. Payment NOT Successful");

                    }
                }
        );
    }

}
