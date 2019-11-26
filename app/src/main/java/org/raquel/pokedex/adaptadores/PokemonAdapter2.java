package org.raquel.pokedex.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.raquel.pokedex.R;
import org.raquel.pokedex.modelos.Pokemon;
import org.raquel.pokedex.viewholders.PokemonAdapter2ViewHolder;
import org.raquel.pokedex.viewholders.PokemonAdapterViewHolder;

import java.util.List;

public class PokemonAdapter2 extends RecyclerView.Adapter<PokemonAdapter2ViewHolder> {

    private List<Pokemon> mData;
    private LayoutInflater mInflater;
    private PokemonAdapter2.ItemClickListener mClickListener;
    private Context mContext;

    // data is passed into the constructor
    public PokemonAdapter2(Context context, List<Pokemon> data) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    // inflates the cell layout from xml when needed
    @Override
    @NonNull
    public PokemonAdapter2ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.pokemon_item2, parent, false);
        return new PokemonAdapter2ViewHolder(view, mClickListener);
    }

    // binds the data to the TextView in each cell
    @Override
    public void onBindViewHolder(@NonNull PokemonAdapter2ViewHolder holder, int position) {
        Pokemon pokemon = mData.get(position);

        Glide.with(mContext).load(pokemon.getImage()).into(holder.pokemonImage);
        holder.pokemonName.setText(pokemon.getName());
    }

    // total number of cells
    @Override
    public int getItemCount() {
        return mData.size();
    }

    // convenience method for getting data at click position
    public Pokemon getPokemon(int id) {
        return mData.get(id);
    }

    // allows clicks events to be caught
    public void setClickListener(PokemonAdapter2.ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}