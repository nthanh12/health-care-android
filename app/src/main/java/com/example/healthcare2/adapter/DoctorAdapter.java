package com.example.healthcare2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.healthcare2.R;
import com.example.healthcare2.data.model.Doctor;
import com.example.healthcare2.data.model.Post;
import com.example.healthcare2.databinding.ItemDoctorBinding;

import java.util.List;

public class DoctorAdapter extends RecyclerView.Adapter<DoctorAdapter.ViewHolder> {
    private LayoutInflater inflater;
    private Context context;
    private List<Doctor> list;
    private List<Integer> listTotalPost;
    private int layout;

    public DoctorAdapter(Context context, List<Doctor> list, List<Integer> listTotalPost, int layout) {
        this.list = list;
        this.context = context;
        this.layout = layout;
        this.listTotalPost = listTotalPost;
        this.inflater = LayoutInflater.from(context);
    }

    public DoctorAdapter(Context context, List<Post> postList, int itemPostHome) {

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemDoctorBinding binding = ItemDoctorBinding.inflate(inflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Doctor doctor = list.get(position);
        int totalPost = listTotalPost.get(position);
        holder.bind(doctor, totalPost);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemDoctorBinding binding;

        public ViewHolder(@NonNull ItemDoctorBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
        public void bind(Doctor doctor, int totalPost) {
            binding.txtNameDoctor.setText(doctor.getNameUser());
            binding.txtTotalPosts.setText(String.valueOf(totalPost));
            binding.txtDoctorDescription.setText(doctor.getDescription());
            setStar(doctor.getRatingDoctor());
        }
        public void setStar(float rating) {
            if (rating > 0 && rating <= 0.5) {
                setNumberStar(0.5f);
            } else if (rating > 0.5 && rating <= 1) {
                setNumberStar(1f);
            } else if (rating > 1 && rating <= 1.5) {
                setNumberStar(1.5f);
            } else if (rating > 1.5 && rating <= 2) {
                setNumberStar(2f);
            } else if (rating > 2 && rating <= 2.5) {
                setNumberStar(2.5f);
            } else if (rating > 2.5 && rating <= 3) {
                setNumberStar(3f);
            } else if (rating > 3 && rating <= 3.5) {
                setNumberStar(3.5f);
            } else if (rating > 3.5 && rating <= 4) {
                setNumberStar(4f);
            } else if (rating > 4 && rating <= 4.5) {
                setNumberStar(4.5f);
            } else {
                setNumberStar(5f);
            }
        }

        public void setNumberStar(float star) {
            if (star == 0){
                binding.icSao1.setImageResource(R.drawable.ic_star_empty);
                binding.icSao2.setImageResource(R.drawable.ic_star_empty);
                binding.icSao3.setImageResource(R.drawable.ic_star_empty);
                binding.icSao4.setImageResource(R.drawable.ic_star_empty);
                binding.icSao5.setImageResource(R.drawable.ic_star_empty);
            } else if(star == 0.5) {
                binding.icSao1.setImageResource(R.drawable.ic_star_half);
                binding.icSao2.setImageResource(R.drawable.ic_star_empty);
                binding.icSao3.setImageResource(R.drawable.ic_star_empty);
                binding.icSao4.setImageResource(R.drawable.ic_star_empty);
                binding.icSao5.setImageResource(R.drawable.ic_star_empty);
            } else if(star == 1) {
                binding.icSao1.setImageResource(R.drawable.ic_star_full);
                binding.icSao2.setImageResource(R.drawable.ic_star_empty);
                binding.icSao3.setImageResource(R.drawable.ic_star_empty);
                binding.icSao4.setImageResource(R.drawable.ic_star_empty);
                binding.icSao5.setImageResource(R.drawable.ic_star_empty);
            } else if(star == 1.5) {
                binding.icSao1.setImageResource(R.drawable.ic_star_full);
                binding.icSao2.setImageResource(R.drawable.ic_star_half);
                binding.icSao3.setImageResource(R.drawable.ic_star_empty);
                binding.icSao4.setImageResource(R.drawable.ic_star_empty);
                binding.icSao5.setImageResource(R.drawable.ic_star_empty);
            } else if(star == 2) {
                binding.icSao1.setImageResource(R.drawable.ic_star_full);
                binding.icSao2.setImageResource(R.drawable.ic_star_full);
                binding.icSao3.setImageResource(R.drawable.ic_star_empty);
                binding.icSao4.setImageResource(R.drawable.ic_star_empty);
                binding.icSao5.setImageResource(R.drawable.ic_star_empty);
            } else if(star == 2.5) {
                binding.icSao1.setImageResource(R.drawable.ic_star_full);
                binding.icSao2.setImageResource(R.drawable.ic_star_full);
                binding.icSao3.setImageResource(R.drawable.ic_star_half);
                binding.icSao4.setImageResource(R.drawable.ic_star_empty);
                binding.icSao5.setImageResource(R.drawable.ic_star_empty);
            } else if(star == 3) {
                binding.icSao1.setImageResource(R.drawable.ic_star_full);
                binding.icSao2.setImageResource(R.drawable.ic_star_full);
                binding.icSao3.setImageResource(R.drawable.ic_star_full);
                binding.icSao4.setImageResource(R.drawable.ic_star_empty);
                binding.icSao5.setImageResource(R.drawable.ic_star_empty);
            } else if(star == 3.5) {
                binding.icSao1.setImageResource(R.drawable.ic_star_full);
                binding.icSao2.setImageResource(R.drawable.ic_star_full);
                binding.icSao3.setImageResource(R.drawable.ic_star_full);
                binding.icSao4.setImageResource(R.drawable.ic_star_half);
                binding.icSao5.setImageResource(R.drawable.ic_star_empty);
            } else if(star == 4) {
                binding.icSao1.setImageResource(R.drawable.ic_star_full);
                binding.icSao2.setImageResource(R.drawable.ic_star_full);
                binding.icSao3.setImageResource(R.drawable.ic_star_full);
                binding.icSao4.setImageResource(R.drawable.ic_star_full);
                binding.icSao5.setImageResource(R.drawable.ic_star_empty);
            } else if(star == 4.5) {
                binding.icSao1.setImageResource(R.drawable.ic_star_full);
                binding.icSao2.setImageResource(R.drawable.ic_star_full);
                binding.icSao3.setImageResource(R.drawable.ic_star_full);
                binding.icSao4.setImageResource(R.drawable.ic_star_full);
                binding.icSao5.setImageResource(R.drawable.ic_star_half);
            } else {
                binding.icSao1.setImageResource(R.drawable.ic_star_full);
                binding.icSao2.setImageResource(R.drawable.ic_star_full);
                binding.icSao3.setImageResource(R.drawable.ic_star_full);
                binding.icSao4.setImageResource(R.drawable.ic_star_full);
                binding.icSao5.setImageResource(R.drawable.ic_star_full);
            }
        }
    }
}
