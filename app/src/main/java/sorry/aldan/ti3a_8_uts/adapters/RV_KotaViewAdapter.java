package sorry.aldan.ti3a_8_uts.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import sorry.aldan.ti3a_8_uts.R;
import sorry.aldan.ti3a_8_uts.models.Kota;
import sorry.aldan.ti3a_8_uts.models.RP_Kota;

public class RV_KotaViewAdapter extends RecyclerView.Adapter<RV_KotaViewAdapter.RV_KotaViewHolder> {
    List<RP_Kota> dataset;

    public RV_KotaViewAdapter(List<RP_Kota> dataset) {
        this.dataset = dataset;
    }

    @NonNull

    @Override
    public RV_KotaViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.item_kota,viewGroup,false);
        return new RV_KotaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RV_KotaViewHolder kotaViewHolder, int i) {
        kotaViewHolder.txtNama.setText(dataset.get(i).getNama());
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public class RV_KotaViewHolder extends RecyclerView.ViewHolder{
        TextView txtNama;
        public RV_KotaViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNama = itemView.findViewById(R.id.txtNama);
        }
    }
}
