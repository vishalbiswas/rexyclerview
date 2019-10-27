package com.vishalbiswas.rexyclerviewexample.adapters;

import android.content.Context;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.vishalbiswas.rexyclerviewexample.R;
import com.vishalbiswas.rexyclerviewexample.models.Category;

import java.util.ArrayList;
import java.util.List;

public final class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.Holder> {
    private Context context;
    private LayoutInflater inflater;
    private List<Category> items;
    private int indentation;
    private ChildCollapsedExpandedListener childListener;

    public CategoriesAdapter(Context context, List<Category> categories) {
        this(context, categories, 0, null);
    }

    /**
     * Constructor for use in recursive child recycler views.
     */
    private CategoriesAdapter(Context context, List<Category> categories, float indentation, ChildCollapsedExpandedListener listener) {
        super();

        this.context = context;
        inflater = LayoutInflater.from(context);
        items = categories;
        this.indentation = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, indentation, context.getResources().getDisplayMetrics());
        childListener = listener;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Holder holder = new Holder(inflater.inflate(R.layout.item_category, parent, false));
        holder.childRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        holder.itemView.setPadding(
                holder.itemView.getPaddingLeft() + indentation,
                holder.itemView.getPaddingTop(),
                holder.itemView.getPaddingRight(),
                holder.itemView.getPaddingBottom()
        );
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, final int position) {
        final Category item = items.get(position);
        holder.textView.setText(item.getName());
        holder.checkbox.setChecked(item.isSelected());
        holder.checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                item.setSelected(b);
            }
        });

        final int collapseResId = item.isExpanded() ? android.R.drawable.arrow_up_float : android.R.drawable.arrow_down_float;
        if (item.getChildItems() != null && item.getChildItems().size() > 0) {
            holder.imageView.setImageResource(collapseResId);
            holder.imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    item.setExpanded(!item.isExpanded());
                    if (childListener != null) {
                        childListener.onChildToggle();
                    }
                    notifyItemChanged(position);
                }
            });

            if (item.isExpanded()) {
                holder.childRecyclerView.setAdapter(new CategoriesAdapter(
                        context,
                        item.getChildItems(),
                        20,
                        new ChildCollapsedExpandedListener() {
                            @Override
                            public void onChildToggle() {
                                notifyItemChanged(position);
                            }
                        }
                ));
                holder.childRecyclerView.setVisibility(View.VISIBLE);
            } else {
                holder.childRecyclerView.setVisibility(View.GONE);
            }
            holder.imageView.setVisibility(View.VISIBLE);
        } else {
            holder.imageView.setVisibility(View.GONE);
            holder.childRecyclerView.setVisibility(View.GONE);
            holder.childRecyclerView.setAdapter(null);
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public List<Integer> getSelectedIds() {
        return getSelected(items);
    }

    private static List<Integer> getSelected(List<Category> items) {
        List<Integer> ids = new ArrayList<>();
        for (Category item : items) {
            if (item.isSelected()) ids.add(item.getId());
            if (item.getChildItems() != null && item.getChildItems().size() > 0) ids.addAll(getSelected(item.getChildItems()));
        }

        return ids;
    }

    class Holder extends RecyclerView.ViewHolder {
        CheckBox checkbox;
        TextView textView;
        ImageView imageView;
        RecyclerView childRecyclerView;

        Holder(View parent) {
            super(parent);
            checkbox = parent.findViewById(R.id.checkbox);
            textView = parent.findViewById(R.id.textview);
            imageView = parent.findViewById(R.id.imageview);
            childRecyclerView = parent.findViewById(R.id.childRecyclerView);
        }
    }

    private interface ChildCollapsedExpandedListener {
        void onChildToggle();
    }
}
