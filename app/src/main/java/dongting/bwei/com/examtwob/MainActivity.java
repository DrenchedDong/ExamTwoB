package dongting.bwei.com.examtwob;

import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

import dongting.bwei.com.examtwob.bean.Bean;

public class MainActivity extends Activity implements View.OnClickListener{

    private RecyclerView recyclerView;
    private List<Bean> list=new ArrayList<>();
    private MyListAdapter adapter;

     boolean checked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button selectAll =(Button) findViewById(R.id.selectAll);
        Button selectReverse =(Button) findViewById(R.id.selectReverse);

        selectAll.setOnClickListener(this);
        selectReverse.setOnClickListener(this);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        //设置布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.addItemDecoration(
                new HorizontalDividerItemDecoration.Builder(this)
                        .color(Color.RED)
//                        .sizeResId(R.dimen.divider)
//                        .marginResId(R.dimen.leftmargin, R.dimen.rightmargin)
                        .build());

        initData();

        adapter = new MyListAdapter(this,list);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new MyListAdapter.OnItemClickListener() {
            @Override
            public void onItemClickListener(int position, View view) {
                Toast.makeText(MainActivity.this, "当前条目position为"+position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClickListener(int position, View view) {
                alert(position);
            }
        });

    }

    private void alert(final int position) {

        // 创建构建器
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // 设置参数
        builder.setTitle("当前条目position为"+position);

        builder.create().show();
    }

    private void initData() {
           for(int i=0;i<50;i++){
            list.add(new Bean(""+(i+1),false));
        }
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.selectAll:
                for(int i=0;i<list.size();i++){
                    if(!checked){
                        list.get(i).setIschecked(true);
                    }else{
                        list.get(i).setIschecked(false);
                    }
                    adapter.notifyDataSetChanged();
                }
                break;
            case R.id.selectReverse:
                for(int i=0;i<list.size();i++){
                    if(list.get(i).ischecked){
                        list.get(i).setIschecked(false);
                    }else{
                        list.get(i).setIschecked(true);
                    }
                    adapter.notifyDataSetChanged();
                }
                break;
        }
    }
}
