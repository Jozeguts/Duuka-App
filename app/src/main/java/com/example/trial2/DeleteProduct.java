package com.example.trial2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.PopupWindow;
import java.util.ArrayList;

public class DeleteProduct extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<String> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_delete_product_home);



        // Initialize RecyclerView and product list
        recyclerView = findViewById(R.id.orders_recycler_view);
        productList = new ArrayList<>();

        // Populate product list (replace with your data)
        productList.add("Product 1");
        productList.add("Product 2");
        productList.add("Product 3");
        productList.add("Product 4");
        productList.add("Product 5");
        productList.add("Product 6");
        productList.add("Product 7");
        productList.add("Product 8");

        // Add more products as needed

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Enable the back button
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        // Set up RecyclerView adapter
        DeleteProductAdapter adapter = new DeleteProductAdapter(productList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    // RecyclerView Adapter class
    private class DeleteProductAdapter extends RecyclerView.Adapter<DeleteProductAdapter.ProductViewHolder> {

        private ArrayList<String> productList;

        public DeleteProductAdapter(ArrayList<String> productList) {
            this.productList = productList;
        }

        @Override
        public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.admin_delete_product_card, parent, false);
            return new ProductViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ProductViewHolder holder, int position) {
            String product = productList.get(position);
            holder.productNameTextView.setText(product);

            // Handle delete button click
            holder.deleteTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Show popup for delete confirmation
                    showDeleteConfirmationPopup();
                }
            });
        }

        @Override
        public int getItemCount() {
            return productList.size();
        }

        // ViewHolder class
        public class ProductViewHolder extends RecyclerView.ViewHolder {
            public TextView productNameTextView;
            public TextView deleteTextView;

            public ProductViewHolder(View itemView) {
                super(itemView);
                productNameTextView = itemView.findViewById(R.id.product_name_text_view);
                deleteTextView = itemView.findViewById(R.id.delete_text_view);
            }
        }
    }

    // Method to show popup for delete confirmation
    private void showDeleteConfirmationPopup() {
        View popupView = LayoutInflater.from(this).inflate(R.layout.admin_delete_notice_pop_up, null);
        PopupWindow popupWindow = new PopupWindow(popupView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);

        TextView yesTextView = popupView.findViewById(R.id.yes_text_view);
        TextView noTextView = popupView.findViewById(R.id.no_text_view);

        // Handle Yes button click
        yesTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform delete operation
                // For demonstration, let's remove the first item from the list
                if (!productList.isEmpty()) {
                    productList.remove(0); // Remove the first item
                    recyclerView.getAdapter().notifyDataSetChanged(); // Notify adapter
                }
                popupWindow.dismiss(); // Dismiss the popup
            }
        });

        // Handle No button click
        noTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss(); // Dismiss the popup
            }
        });

        // Show the popup window
        popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0);


    }

    // Handle back button click
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            // Navigate back to previous activity
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
