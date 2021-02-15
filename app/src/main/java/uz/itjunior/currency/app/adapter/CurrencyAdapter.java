package uz.itjunior.currency.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import uz.itjunior.currency.app.Currency;
import uz.itjunior.currency.app.R;

public class CurrencyAdapter extends RecyclerView.Adapter<CurrencyAdapter.CurrencyHolder>{

    Context context;
    List<Currency> currencies;
    OnClickListener listener;


    public CurrencyAdapter(Context context, List<Currency> currencies, OnClickListener listener) {
        this.context = context;
        this.currencies = currencies;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CurrencyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_currency, parent, false);
        return new CurrencyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CurrencyHolder holder, int position) {

        Currency currency = currencies.get(position);

        holder.imgFlag.setImageResource(currencies.get(position).getImgFlag());
        holder.txtName.setText(currencies.get(position).getName());
        holder.txtFullName.setText(currencies.get(position).getFullName());
        holder.txtValue.setText(String.valueOf(currencies.get(position).getValue()));

        holder.itemView.setOnClickListener(v -> {
            listener.onItemClick(currency);
        });
    }

    @Override
    public int getItemCount() {
        return currencies.size();
    }

    public class CurrencyHolder extends RecyclerView.ViewHolder {

        private ImageView imgFlag;
        private TextView txtName;
        private TextView txtFullName;
        private TextView txtValue;

        public CurrencyHolder(@NonNull View itemView) {
            super(itemView);

            imgFlag = itemView.findViewById(R.id.item_currency_flag_img);
            txtName = itemView.findViewById(R.id.item_currency_name_text);
            txtFullName = itemView.findViewById(R.id.item_currency_full_name_text);
            txtValue = itemView.findViewById(R.id.item_currency_value);
        }
    }

    public interface OnClickListener {

        void onItemClick(Currency currency);

    }
}
