package com.example.hasee.spinner;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends Activity implements View.OnClickListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1 = (Button)findViewById(R.id.bt_1);
        button1.setOnClickListener(this);
        Button button2 = (Button)findViewById(R.id.bt_2);
        button2.setOnClickListener(this);
        Button button3 = (Button)findViewById(R.id.bt_3);
        button3.setOnClickListener(this);
        Button button4 = (Button)findViewById(R.id.bt_4);
        button4.setOnClickListener(this);
        Button button5 = (Button)findViewById(R.id.bt_5);
        button5.setOnClickListener(this);
        Button button6 = (Button)findViewById(R.id.bt_6);
        button6.setOnClickListener(this);
        Button button7 = (Button)findViewById(R.id.bt_7);
        button7.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_1:
                Log.d("233","11111");
                AlertDialog dialog = new AlertDialog.Builder(this)
                        .setIcon(R.drawable.pc)//标题的图片
                        .setTitle("我的普通对话框")
                        .setMessage("这个是对话框的内容")
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this,"点击了取消按钮",Toast.LENGTH_SHORT).show();
                                dialog.dismiss();
                            }
                        })
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this,"点击了确定按钮",Toast.LENGTH_SHORT).show();
                                dialog.dismiss();
                            }
                        }).create();
                dialog.show();
                Log.d("233","222");
                break;
            case R.id.bt_2:
                Log.d("233","111");
                final String items[] = {"我是选择一","我是选择二","我是选择三"};
                final AlertDialog dialog1 = new AlertDialog.Builder(this)
                        .setIcon(R.drawable.pc)
                        .setTitle("单选对话框")
                        .setSingleChoiceItems(items, 1, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this,items[which],Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).create();
                dialog1.show();
                break;
                case R.id.bt_3:
                    final String item[] = {"我是选择一","我是选择二","我是选择三"};
                    final AlertDialog dialog2 = new AlertDialog.Builder(this)
                            .setIcon(R.drawable.pc)
                            .setTitle("列表对话框")
                            .setItems(item, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast.makeText(MainActivity.this,item[which],Toast.LENGTH_SHORT).show();
                                }
                            })
                            .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            })
                            .setNegativeButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            }).create();
                    dialog2.show();
                    break;
                    case R.id.bt_4:
                        final String itemss[] = {"我是选择一","我是选择二","我是选择三"};
                        final boolean checkedItem[] = {true,false,true,false};
                        AlertDialog dialog3 = new AlertDialog.Builder(this)
                                .setIcon(R.drawable.pc)
                                .setTitle("多选对话框")
                                .setMultiChoiceItems(itemss, checkedItem, new DialogInterface.OnMultiChoiceClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                        checkedItem[which] = isChecked;
                                    }
                                })
                                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                })
                                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        for(int i = 0;i < checkedItem.length;i++){
                                            if (checkedItem[i]){
                                                Toast.makeText(MainActivity.this,"选中了"+i,Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                        dialog.dismiss();
                                    }
                                }).create();
                        dialog3.show();
                        break;
                        case R.id.bt_5:
                            View view = getLayoutInflater().inflate(R.layout.half_dialog_view,null);
                            final EditText editText = (EditText)view.findViewById(R.id.dialog_edit);
                            AlertDialog dialog4 = new AlertDialog.Builder(this)
                                    .setIcon(R.drawable.pc)
                                    .setTitle("半自定义")
                                    .setView(view)
                                    .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.dismiss();
                                        }
                                    })
                                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            String c = editText.getText().toString();
                                            Toast.makeText(MainActivity.this,c,Toast.LENGTH_SHORT).show();
                                            dialog.dismiss();
                                        }
                                    }).create();
                            dialog4.show();
                            break;
                            case R.id.bt_6:
                                Log.d("233","666");
                                Dialog dialog5 = new Dialog(this,R.style.NormalDialogStyle);
                                View view1 = View.inflate(this,R.layout.dialog_bottom,null);
                                setContentView(view1);
                                dialog5.setCanceledOnTouchOutside(true);
                                view1.setMinimumHeight((int)(ScreenSize.getInstance(this).getScreenHeight()*0.23f));
                                Window dialaogWindow = dialog5.getWindow();
                                WindowManager.LayoutParams lp = dialaogWindow.getAttributes();
                                lp.width = (int)(ScreenSize.getInstance(this).getScreenWidth()*0.9f);
                                lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
                                lp.gravity = Gravity.BOTTOM;
                                dialaogWindow.setAttributes(lp);
                                Log.d("233","777");
                                dialog5.show();
                                break;
                                case R.id.bt_7:
                                    final ProgressDialog dialog6 = new ProgressDialog(this);
                                    dialog6.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                                    dialog6.setMessage("正在加载");
                                    dialog6.setMax(100);
                                    final Timer timer = new Timer();
                                    timer.schedule(new TimerTask() {
                                        int progress = 0;
                                        @Override
                                        public void run() {
                                            dialog6.setProgress(progress+=5);
                                            if (progress==100){
                                                timer.cancel();
                                            }
                                        }
                                    },0,1000);
                                    dialog6.show();
                                    break;




        }
    }
}


