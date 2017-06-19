package dongting.bwei.com.examtwob;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

import dongting.bwei.com.examtwob.bean.Bean;

/**
 * 作者:${董婷}
 * 日期:2017/6/19
 * 描述:
 */

public class MyListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<Bean> list;
    //List<Bean1> list;
    MainActivity context;
    LayoutInflater inflater;

    public MyListAdapter(MainActivity context, List<Bean> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.listadapter, parent, false);

        OneViewHolder hViewHolder = new OneViewHolder(view);

        return hViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        OneViewHolder oneViewHolder = (OneViewHolder) holder;
        oneViewHolder.content.setText(list.get(position).getText());
        oneViewHolder.checkBox.setChecked(list.get(position).ischecked());

        oneViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClickListener(position,v);
            }
        });

        oneViewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                listener.onItemLongClickListener(position,v);
                return true;
            }
        });


    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }

    class OneViewHolder extends RecyclerView.ViewHolder {

        TextView content;
        CheckBox checkBox;

        public OneViewHolder(View itemView) {
            super(itemView);

            content = (TextView) itemView.findViewById(R.id.textview_id_list);
            checkBox = (CheckBox) itemView.findViewById(R.id.checkbox);
        }
    }

    interface OnItemClickListener {

        void onItemClickListener(int position,View view);
        void onItemLongClickListener(int position,View view);
    }

    OnItemClickListener listener ;

    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }
}
