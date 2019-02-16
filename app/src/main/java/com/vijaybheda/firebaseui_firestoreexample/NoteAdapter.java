package com.vijaybheda.firebaseui_firestoreexample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.DocumentSnapshot;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NoteAdapter extends FirestoreRecyclerAdapter<Note, NoteAdapter.NoteHolder> {
    private OnItemClickListener listener;

    public NoteAdapter(@NonNull FirestoreRecyclerOptions<Note> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull NoteHolder holder, int position, @NonNull Note model) {
        holder.textViewTitle.setText(model.getTitle());
        holder.textViewDescription.setText(model.getDescription());
        holder.textViewRetailerNameCode.setText(model.getRetailerNameCode());
        holder.textViewDrCoNo.setText(model.getDrContactNo());
        holder.textViewDrEmail.setText(model.getDrEmail());
        holder.textViewcount.setText(String.valueOf(model.getPriority()));
        holder.fsRate.setText(model.getRate());
        holder.textViewSpecility.setText(model.getSpeciality());
    }

    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_item, parent, false);
        return new NoteHolder(v);
    }

    public void deleteItem(int position) {
        getSnapshots().getSnapshot(position).getReference().delete();
    }

    class NoteHolder extends RecyclerView.ViewHolder {
        TextView textViewTitle,textViewDescription, textViewRetailerNameCode, textViewDrCoNo,textViewDrEmail, textViewcount, fsRate,textViewSpecility;

//        TextView textViewPriority;

        public NoteHolder(View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.text_view_title);
            textViewDescription = itemView.findViewById(R.id.text_view_description);
            textViewRetailerNameCode = itemView.findViewById(R.id.text_view_RetailerNameCode);
            textViewDrCoNo = itemView.findViewById(R.id.text_view_CoNo);
            textViewDrEmail= itemView.findViewById(R.id.text_view_dremail);
            fsRate= itemView.findViewById(R.id.text_view_ratebar);
            textViewcount = itemView.findViewById(R.id.text_view_count);
            textViewSpecility = itemView.findViewById(R.id.text_view_Specility);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION && listener != null) {
                        listener.onItemClick(getSnapshots().getSnapshot(position), position);
                    }
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(DocumentSnapshot documentSnapshot, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

}
