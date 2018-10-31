package sorry.aldan.ti3a_8_uts.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import sorry.aldan.ti3a_8_uts.R;
import sorry.aldan.ti3a_8_uts.models.Kota;

public class KotaViewAdapter extends RecyclerView.Adapter<KotaViewAdapter.KotaViewHolder> {
    ArrayList<Kota> dataset;

    public KotaViewAdapter(ArrayList<Kota> dataset) {
        this.dataset = dataset;
    }

    @NonNull

    @Override
    public KotaViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.item_kota,viewGroup,false);
        return new KotaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KotaViewHolder kotaViewHolder, int i) {
        kotaViewHolder.txtNama.setText(dataset.get(i).getNama());
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public class KotaViewHolder extends RecyclerView.ViewHolder{
        TextView txtNama;
        public KotaViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNama = itemView.findViewById(R.id.txtNama);
        }
    }
}
