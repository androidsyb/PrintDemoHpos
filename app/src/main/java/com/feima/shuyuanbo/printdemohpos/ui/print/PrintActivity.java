package com.feima.shuyuanbo.printdemohpos.ui.print;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.feima.shuyuanbo.printdemohpos.R;
import com.feima.shuyuanbo.printdemohpos.ui.base.BaseActivity;
import com.feima.shuyuanbo.printdemohpos.utils.LogUtils;
import com.iboxpay.cashbox.minisdk.CashboxProxy;
import com.iboxpay.print.IPrintJobStatusCallback;
import com.iboxpay.print.PrintManager;
import com.iboxpay.print.model.CharacterParams;
import com.iboxpay.print.model.GraphParams;
import com.iboxpay.print.model.PrintItemJobInfo;
import com.iboxpay.print.model.PrintJobInfo;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by shuyuanbo on 17/1/19.
 */

public class PrintActivity extends BaseActivity {

    @BindView(R.id.print_btntext)
    Button mBtnText;
    private PrintManager mPrintManager;
    private boolean isPrinting = false;

    @Override
    public void initView() {
        setContentView(R.layout.activity_print);
        ButterKnife.bind(this);

        initPrintConfig();
    }

    //初始化打印配置
    private void initPrintConfig() {
        try {
            mPrintManager = (PrintManager) getSystemService("iboxpay_print");
        } catch (Exception e) {
            e.printStackTrace();
            LogUtils.e("获取打印manager出错");
        }

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    @OnClick(R.id.print_btntext)
    public void printText(){
        if (mPrintManager == null || isPrinting){
            if (isPrinting){
                showToast("正在打印中,请稍后...");
            }
            return;
        }
        isPrinting = true;
        mPrintManager.printLocaleJob(createCardPrintReceiptTask4CardHolder(),new IPrintJobStatusCallback.Stub(){

            @Override
            public void onPrintJobStatusChange(int status, String taskId) throws RemoteException {
                LogUtils.d("onPrintTaskStatusChange status = " + status + "taskId="+ taskId);
                switch (status) {
                    case 0:
                        LogUtils.e("0:打印任务完成----订单号:");
                        isPrinting = false;
                        break;
                    case 1:
                        LogUtils.e("1:打印任务开始/n");
                        break;
                    case 4:
                        LogUtils.e("4:打印任务的时候出现缺纸/n");
                        break;
                    case -1:
                        LogUtils.e("-1:打印任务失败/n");
                        break;
                    default: //异常情况
                        break;
                }
            }
        });
    }


    public PrintJobInfo createCardPrintReceiptTask4CardHolder() {
        PrintJobInfo receiptTask = new PrintJobInfo();
        try {
            //添加打印任务PrintItemJobInfo对象
//            CharacterParams(int fontSizeWidth, int fontSizeHeight, int fontGravity)
//            构造一个带字体宽度和高度和 字体位置的参数对象,fontGravity = 0时默认靠左显示 ,
//            fontGravity = 1 时居中显示 fontGravity = 2 靠右显示。
//            Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.erwei);
//            receiptTask.addPrintItemJobTask(new PrintItemJobInfo(bitmap,new GraphParams()));
            receiptTask.addPrintItemJobTask(new PrintItemJobInfo("--------------------------------\n",new CharacterParams()));
            receiptTask.addPrintItemJobTask(new PrintItemJobInfo("hello"+ "签购单\n", new CharacterParams(2, 1)));
            receiptTask.addPrintItemJobTask(new PrintItemJobInfo("盒子号-----    "+ CashboxProxy.getBoxSn(this)+"\n",new CharacterParams()));
            receiptTask.addPrintItemJobTask(new PrintItemJobInfo("持卡人存根 CARDHOLDER COPY\n", new CharacterParams()));
            receiptTask.addPrintItemJobTask(new PrintItemJobInfo("--------------------------------\n",new CharacterParams()));
            receiptTask.addPrintItemJobTask(new PrintItemJobInfo("\n\n\n\n", new CharacterParams()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return receiptTask;
    }
}
