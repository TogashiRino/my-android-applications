package com.example.dell.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public String createOrderSummary(int totalPrice, boolean hasWhippedCream, boolean hasChocolate,String name) {
        return "Name: "+name
                + "\nAdd whipped cream?" + hasWhippedCream
                + "\nAdd Chocolate?" + hasChocolate
                + "\n Quantity: " + quantity
                + "\n Total: $" + totalPrice + "\n Thank You";
    }

    public void submitOrder(View view) {
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkBox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckBox.isChecked();
        EditText addName =(EditText)findViewById(R.id.plain_text_input) ;
        String name= addName.getText().toString();
        // Log.v("Main Activity"," has whipped cream "+hasWhippedCream);
        int totalPrice = calculatePrice(hasWhippedCream,hasChocolate);
        String orderSummary = createOrderSummary(totalPrice, hasWhippedCream, hasChocolate,name);
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Just java Order for "+name);
        intent.putExtra(Intent.EXTRA_TEXT, orderSummary);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }





    }

    public void increment(View view) {
        if(quantity<100){
            quantity++;

        }
        else{
            Toast.makeText(this,"You can't have more than 100 Coffees ",Toast.LENGTH_SHORT).show();
        }
            displayQuantity(quantity);


    }

    public void decrement(View view) {
        if(quantity>1){
            quantity--;
        }
        else{
            Toast.makeText(this,"You can't have less than 1 cup of Coffee ",Toast.LENGTH_SHORT).show();
        }

        displayQuantity(quantity);

    }

    /**
     * Calculates the price of the order.
     */
    private int calculatePrice( boolean hasWhippedCream, boolean hasChocolate) {

        int price = quantity * 5;
        if(hasChocolate)
            price+=quantity*2;
        if(hasWhippedCream)
            price+=quantity;
        return price;

    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given text on the screen.
     */



}