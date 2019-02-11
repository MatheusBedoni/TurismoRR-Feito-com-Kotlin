package com.app.redes.turismorr;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.redes.turismorr.R;
import com.app.redes.turismorr.auxiliares.RecyclerViewOnClickListenerHack;
import com.app.redes.turismorr.Tips;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.List;

/**
 * Created by Matt on 12/01/2019.
 */

public class TipsAdapter extends RecyclerView.Adapter<TipsAdapter.MyViewHolder>{
    private List<Tips> list;
    private LayoutInflater layoutInflater;
    private RecyclerViewOnClickListenerHack recyclerViewOnClickListenerHack;

    public TipsAdapter(Context c,List<Tips> l){
        list = l;
        layoutInflater = (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.i("LOG","oscreateviewholder");
        View view = layoutInflater.inflate(R.layout.item_pedido,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    public void setRecyclerViewOnClickListenerHack(RecyclerViewOnClickListenerHack r){
        recyclerViewOnClickListenerHack = r;
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Log.i("com.app.redes.turismorr","onbindviewholder");

        holder.nome.setText(list.get(position).getNome());
        holder.image.setImageResource(list.get(position).getPhoto());
        YoYo.with(Techniques.Tada)
                .duration(700)
                .repeat(5)
                .playOn(holder.itemView);
    }

    @Override
    public int getItemCount() {
        try{
            return list.size();
        }
        catch (Exception e){

        }
       return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView nome;
        public ImageView image ;
        public MyViewHolder(View itemView) {
            super(itemView);
            nome = (TextView) itemView.findViewById(R.id.nome);
            image = (ImageView) itemView.findViewById(R.id.avatar);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(recyclerViewOnClickListenerHack != null){
                recyclerViewOnClickListenerHack.onClickListener(view, getPosition());
            }
        }
    }
}
