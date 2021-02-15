package uz.itjunior.currency.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import uz.itjunior.currency.app.adapter.CurrencyAdapter;

public class HeadActivity extends AppCompatActivity {

    private RecyclerView rvRoot;
    private List<Currency> currencies;
    private CurrencyAdapter adapter;
    private CurrencyAdapter.OnClickListener listener;

    private TextView txtHead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_head);

        listener = new CurrencyAdapter.OnClickListener() {
            @Override
            public void onItemClick(Currency currency) {
                Toast.makeText(HeadActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
            }
        };

        GridLayoutManager manager = new GridLayoutManager(this, 1);
        DividerItemDecoration decoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);

        txtHead = findViewById(R.id.head_currency_top_text);
        rvRoot = findViewById(R.id.head_rv);
        rvRoot.setHasFixedSize(true);
        rvRoot.setLayoutManager(manager);
        rvRoot.addItemDecoration(decoration);
        currencies = new ArrayList<>();
        adapter = new CurrencyAdapter(this, currencies, listener);
        rvRoot.setAdapter(adapter);

        currencyList();
        c();
    }

    public void currencyList() {

        currencies.add(new Currency(R.drawable.usa, "USD", "USA Dollar", 10530.83));
        currencies.add(new Currency(R.drawable.gbr, "GBP", "Great Britain Pound", 14461.99));
        currencies.add(new Currency(R.drawable.jpn, "JPY", "Japan Yuan", 99.95));
        currencies.add(new Currency(R.drawable.kaz, "KZT", "Kazakh Tenge", 25.05));

    }

    @SuppressLint("SetTextI18n")
    void c() {
        for (int i = 0; i < currencies.size(); i++) {
            txtHead.setText("1 USD = " + currencies.get(i).getValue() + " UZS");
        }
    }
}
